package com.nebula.domain.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nebula.db.DbConnectionFactory;
import com.nebula.domain.*;
import com.nebula.domain.Thread;

public class DbThreadDao implements ThreadDao {
    private static final DbConnectionFactory DB_CONNECTION_FACTORY = new DbConnectionFactory();
    private final Connection connection = DB_CONNECTION_FACTORY.getConnection();

    @Override
    public void close() throws Exception {
        connection.close();
    }

    @Override
    public Thread[] getFeed(int maxThreads) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM thread ORDER BY lastActive DESC LIMIT ?");
            statement.setInt(1, maxThreads);

            List<Thread> feed = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int threadId = resultSet.getInt(1);
                //String customerId = resultSet.getString(2);
                String customerId = "test";
                Date lastActive = new Date(resultSet.getTime(2).getTime());
                // TODO: Get location.
                RootMessage openingPost = getOpeningPost(threadId);
                List<Message> comments = getComments(threadId);
                feed.add(new Thread(threadId, customerId, new Location(), lastActive, openingPost, comments));
            }

            statement.close();

            return feed.toArray(new Thread[maxThreads]);
        }
        catch (SQLException e) {
            // HACK: Workaround for Java's checked exceptions.
            throw new RuntimeException(e);
        }
    }

    private RootMessage getOpeningPost(int threadId) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT customerId, body, title, type, imageUrl FROM rootMessage WHERE threadId = ?");
            statement.setInt(1, threadId);

            ResultSet resultSet = statement.executeQuery();
                resultSet.next();
                System.out.println("This is the result!" + resultSet.getString(1));
                String customerId = resultSet.getString(1);
                String body = resultSet.getString(2);
                String title = resultSet.getString(3);
                String type = resultSet.getString(4);
                String imageUrl = resultSet.getString(5);
                statement.close();
                return new RootMessage(customerId, body, title, type, imageUrl);
        }
        catch (SQLException e) {
            // HACK: Workaround for Java's checked exceptions.
            throw new RuntimeException(e);
        }
    }

    private List<Message> getComments(int threadId) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT customerId, body FROM message WHERE threadId = ?");
            statement.setInt(1, threadId);

            List<Message> comments = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String customerId = resultSet.getString(1);
                String body = resultSet.getString(2);

                comments.add(new Message(customerId, body));
            }

            statement.close();
            return comments;
        }
        catch (SQLException e) {
            // HACK: Workaround for Java's checked exceptions.
            throw new RuntimeException(e);
        }
    }

    @Override
    public Thread postThread(Customer customer, Location location, RootMessage openingPost) {
        // TODO: Must be an atomic transaction.
        try {
            Date now = new Date();

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO thread (lastActive, latitude, longitude) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            // TODO: Set location.
            statement.setTimestamp(1, new Timestamp(now.getTime()));
            statement.setDouble(2, Double.parseDouble(location.getLatitude()));
            statement.setDouble(3, Double.parseDouble(location.getLongitude()));
            statement.executeUpdate();

            Thread thread = new Thread(0, customer.getUsername(), location, now, openingPost, new ArrayList<>());

            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();
            thread.setId(generatedKeys.getInt(1));

            insertOpeningPost(thread);

            return thread;
        }
        catch (SQLException e) {
            // HACK: Workaround for Java's checked exceptions.
            throw new RuntimeException(e);
        }
    }

    private void insertOpeningPost(Thread thread) {
        try {
            RootMessage openingPost = thread.getOpeningPost();

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO rootMessage (threadId, customerId, body, title, type, imageUrl) VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, thread.getId());
            statement.setString(2, thread.getCustomerId());
            statement.setString(3, openingPost.getBody());
            statement.setString(4, openingPost.getTitle());
            statement.setString(5, openingPost.getType());
            statement.setString(6, openingPost.getImageUrl());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            // HACK: Workaround for Java's checked exceptions.
            throw new RuntimeException(e);
        }
    }

    @Override
    public void postComment(Message comment, Thread thread) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO message (threadId, customerId, body) VALUES (?, ?, ?)");
            statement.setInt(1, thread.getId());
            statement.setString(2, comment.getCustomerId());
            statement.setString(3, comment.getBody());
            statement.executeUpdate();
        }
        catch (SQLException e) {
            // HACK: Workaround for Java's checked exceptions.
            throw new RuntimeException(e);
        }
    }
}
