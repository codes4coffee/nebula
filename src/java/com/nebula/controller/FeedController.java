package com.nebula.controller;

import com.nebula.domain.Customer;
import com.nebula.domain.Thread;
import com.nebula.domain.dao.DbThreadDao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/feed")
public class FeedController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) //Should be a get but I have it wired up as post to get it working
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        DbThreadDao threadDao = new DbThreadDao();

        Thread[] threads = threadDao.getFeed(customer.getLocation().getCity());
        ArrayList<Thread> t = new ArrayList<>(Arrays.asList(threads));
        for(Thread tr : t) {
            System.out.println(tr.getId());
        }
        request.setAttribute("threads", t);
//        String author;
//        String title;
//        String text;
//        author = t.getCustomerId();
//        title = t.getOpeningPost().getTitle();
//        text = t.getOpeningPost().getBody();
//        request.setAttribute("post", "Posted by @" + author);
//        request.setAttribute("title", title);
//        request.setAttribute("text", text);
        request.getRequestDispatcher("/feed.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) //Should be a get but I have it wired up as post to get it working
            throws ServletException, IOException
    {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        if(session.getAttribute("customer") == null) {
            response.setStatus(403);
        }else {
            DbThreadDao threadDao = new DbThreadDao();

            Thread[] threads = threadDao.getFeed(customer.getLocation().getCity());
            ArrayList<Thread> t = new ArrayList<>(Arrays.asList(threads));
            for(Thread tr : t) {
                System.out.println(tr.getId());
            }
            request.setAttribute("threads", t);
//        String author;
//        String title;
//        String text;
//        author = t.getCustomerId();
//        title = t.getOpeningPost().getTitle();
//        text = t.getOpeningPost().getBody();
//        request.setAttribute("post", "Posted by @" + author);
//        request.setAttribute("title", title);
//        request.setAttribute("text", text);
            request.getRequestDispatcher("/feed.jsp").forward(request, response);
        }
    }
}
