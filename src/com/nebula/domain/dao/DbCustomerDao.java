package com.nebula.domain.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.nebula.db.DbConnectionFactory;
import com.nebula.domain.Customer;
import com.nebula.domain.Login;

public class DbCustomerDao implements CustomerDao, AutoCloseable {
    private static DbConnectionFactory db = new DbConnectionFactory();
    private Connection connection;

    public DbCustomerDao() {
        connection = db.getConnection();
    }

    @Override
    public void close() {
        try {
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int register(Customer c) {
        int status = 0;

        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO customer VALUES(?,?,?)");
            ps.setString(1, c.getUsername());
            ps.setString(2, c.getName());
            ps.setString(3, c.getPassword());

            status = ps.executeUpdate();
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        return status;
    }

    @Override
    public Customer validateCustomer(Login login) {
        Customer customer = new Customer();

        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM customer WHERE customerId=? AND password=?");
            ps.setString(1, login.getUsername());
            ps.setString(2, login.getPassword());

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                customer.setUsername(rs.getString(1));
                customer.setName(rs.getString(2));
                customer.setPassword(rs.getString(3));
            }
        }
        catch (SQLException e) {
            System.out.println(e);
        }

        return customer;
    }
}
