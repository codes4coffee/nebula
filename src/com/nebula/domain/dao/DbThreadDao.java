package com.nebula.domain.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.nebula.db.DbManager;
import com.nebula.domain.Location;
import com.nebula.domain.Message;
import com.nebula.domain.RootMessage;
import com.nebula.domain.Thread;

public class DbThreadDao implements ThreadDao {
    private static final DbManager dbManager = new DbManager();
    private final Connection connection = dbManager.getConnection();

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
                String customerId = resultSet.getString(2);
                Date lastActive = new Date(resultSet.getTime(3).getTime());
                // TODO: Get location.

                RootMessage openingPost = getOpeningPost(threadId);
                List<Message> comments = getComments(threadId);

                feed.add(new Thread(threadId, new Location(), lastActive, openingPost, comments));
            }

            statement.close();
            return (Thread[]) feed.toArray();
        }
        catch (SQLException e) {
            // HACK: Workaround for Java's checked exceptions.
            throw new RuntimeException(e);
        }
    }

    private RootMessage getOpeningPost(int threadId) {
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT (customerId, body, title, type, imageUrl) FROM rootMessage WHERE threadId = ?");
            statement.setInt(1, threadId);

            ResultSet resultSet = statement.executeQuery();
            resultSet.next();

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
                    "SELECT (customerId, body) FROM message WHERE threadId = ?");
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
    public void postThread(Thread thread) {
        // TODO: Must be an atomic transaction.
        try {
            Date now = new Date();

            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO thread (lastActive, latitude, longitude) VALUES (?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);
            // TODO: Set location.
            statement.setTimestamp(1, new Timestamp(now.getTime()));
            statement.setDouble(2, 0.0);
            statement.setDouble(3, 0.0);
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            generatedKeys.next();

            int threadId = generatedKeys.getInt(1);
            thread.setId(threadId);

            insertOpeningPost(thread);
            insertExistingComments(thread);
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
            statement.setString(2, openingPost.getCustomerId());
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

    private void insertExistingComments(Thread thread) {
        if (thread.getComments().isEmpty())
            return;

        // TODO: Must be an atomic transaction.
        for (Message comment : thread.getComments())
            postComment(thread, comment);
    }

    @Override
    public void postComment(Thread thread, Message comment) {
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
