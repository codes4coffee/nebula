package com.nebula.db;

import java.sql.Connection;
   import java.sql.DriverManager;

/**
 *
 * @author mehra
 * getConnection method help us to connect to the appropriate database. In this project we only have one
 * database. Data comes from MyDB interface.
 */
public class DbManager implements MyDB {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(CONN_URL, USER, PASS);
            return connection;
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
