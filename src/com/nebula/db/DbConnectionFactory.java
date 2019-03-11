package com.nebula.db;

import java.sql.Connection;
   import java.sql.DriverManager;

public class DbConnectionFactory {
    private static final String USER = "root";
    private static final String PASSWORD = "Test1234";
    private static final String CONNECTION_URL = "jdbc:mysql://127.0.0.1:3306/coursedatabase";

    /**
     * getConnection method help us to connect to the appropriate database. In this project we only have one
     * database.
     */
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(CONNECTION_URL, USER, PASSWORD);
            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
