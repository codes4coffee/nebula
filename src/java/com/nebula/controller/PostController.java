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

@WebServlet("/post")
public class PostController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) //Should be a get but I have it wired up as post to get it working
            throws ServletException, IOException
    {
        DbThreadDao threadDao = new DbThreadDao();
        HttpSession session = request.getSession();
        int postId = Integer.parseInt(request.getParameter("id"));
        Thread currentThread = threadDao.getThread(postId);
        request.setAttribute("thread", currentThread);
        request.getRequestDispatcher("/comments.jsp").forward(request,response);
    }
}

