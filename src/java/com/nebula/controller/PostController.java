package com.nebula.controller;

import com.nebula.domain.*;
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

@WebServlet("/post")
public class PostController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) //Should be a get but I have it wired up as post to get it working
            throws ServletException, IOException
    {
        DbThreadDao threadDao = new DbThreadDao();
        HttpSession session = request.getSession();
        int postId = Integer.parseInt(request.getParameter("id"));
        session.setAttribute("currentThread", postId);
        Thread currentThread = threadDao.getThread(postId);
        request.setAttribute("thread", currentThread);
        request.getRequestDispatcher("/comments.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        DbThreadDao threadDao = new DbThreadDao();
        HttpSession session = request.getSession();
        Customer currentUser = (Customer) session.getAttribute("customer");
        Message newMessage = new Message(currentUser.getUsername(),request.getParameter("description"));
        int currentThread = (int) session.getAttribute("currentThread");
        Thread thread = threadDao.getThread(currentThread);
        threadDao.postComment(newMessage, thread);
        response.sendRedirect("/post?id=" + currentThread);
    }
}

