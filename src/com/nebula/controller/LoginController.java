package com.nebula.controller;

import com.nebula.db.DbManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        DbManager db = new DbManager();
        Connection connection = db.getConnection();
        try {
            connection.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        String dbStatusStyle = "";
        String dbStatusMessage = "";

        if (connection == null) {
            dbStatusStyle = "alert alert-danger";
            dbStatusMessage = "The system was unable to communicate with the database server. Login will ont be available.";
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
