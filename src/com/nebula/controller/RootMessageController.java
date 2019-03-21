package com.nebula.controller;

import com.nebula.domain.Customer;
import com.nebula.domain.Location;
import com.nebula.domain.RootMessage;
import com.nebula.domain.dao.DbThreadDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/message")
public class RootMessageController extends HttpServlet {
    private Customer customer;

    public RootMessageController(Customer customer) {
        this.customer = customer;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException
    {
        DbThreadDao threadDao = new DbThreadDao(); // threadDao used to create the new thread

        // get the required information to create a new thread
        String customerId = request.getParameter("customerId");
        String body = request.getParameter("body");
        String title = request.getParameter("title");
        String type = request.getParameter("type");
        String imageUrl = request.getParameter("imageUrl");

        RootMessage rootMessage = new RootMessage(customerId, body, title, type, imageUrl); // create a new root message from info
        Location location = new Location(); // get the location for use in creating the new thread

        threadDao.postThread(location, rootMessage); // create the new thread
    }
}
