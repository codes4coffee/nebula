package com.nebula.controller;

import com.nebula.domain.Customer;
import com.nebula.domain.Location;
import com.nebula.domain.RootMessage;
import com.nebula.domain.Thread;
import com.nebula.domain.dao.DbThreadDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

@WebServlet("/create-thread")
public class PostController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) //Should be a get but I have it wired up as post to get it working
            throws ServletException, IOException
    {
        DbThreadDao threadDao = new DbThreadDao();
        HttpSession session = request.getSession();
        RootMessage op = new RootMessage();

        /* get post information */
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        /* set post information */
        System.out.println("description: " + description);
        op.setTitle(title);
        op.setBody(description);

        /* set location information */
        Location loc = new Location();
        loc.setCity("Dallas");
        loc.setCountry("US");
        loc.setLatitude("2");
        loc.setLongitude("2");
        loc.setPostalCode("75080");

        threadDao.postThread((Customer) session.getAttribute("customer"), loc, op); // post the thread
        request.getRequestDispatcher("/feed").forward(request,response); // redirect the user to the feed
    }
}
