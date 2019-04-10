package com.nebula.controller;

import com.nebula.db.DbConnectionFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        DbConnectionFactory db = new DbConnectionFactory();
        Connection connection = db.getConnection();
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        String dbStatusStyle;
        String dbStatusMessage;

        if (connection == null) {
            dbStatusStyle = "alert alert-danger";
            dbStatusMessage = "The system was unable to communicate with the database server. Login will not be available.";
        }
        else {
            dbStatusStyle = "alert alert-success";
            dbStatusMessage = "MySQL Connection was successful!";
        }

        request.setAttribute("dbStatusStyle", dbStatusStyle);
        request.setAttribute("dbStatusMessage", dbStatusMessage);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
