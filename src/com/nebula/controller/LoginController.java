package com.nebula.controller;

import com.nebula.db.DbManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        DbManager db = new DbManager();
        Connection connection = db.getConnection();

        String dbStatusMessage = "";

        if (connection == null) {
            dbStatusMessage =
                    "<div class=\"alert alert-danger\" role=\"alert\">" +
                    "<div class=\"alert alert-danger\" role=\"alert\">" +
                    "The system was unable to communicate with the database server. Login will not be available." +
                    "</div>";
        }
        else {
            dbStatusMessage =
                    "<div class=\"alert alert-success\" role=\"alert\">" +
                    "MySQL Connection was successful!" +
                    "</div>";
        }

        request.setAttribute("dbStatusMessage", dbStatusMessage);
        request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
