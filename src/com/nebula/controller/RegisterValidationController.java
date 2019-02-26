package com.nebula.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.nebula.domain.Customer;
import com.nebula.domain.Login;
import com.nebula.domain.dao.CustomerDao;
import com.nebula.domain.dao.CustomerDaoImpl;

@WebServlet("/RegisterValidationController")
public class RegisterValidationController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CustomerDao customerDao = new CustomerDaoImpl();

        String fullName = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Login login = new Login(username, password);
        Customer c = customerDao.validateCustomer(login);

        c.setName(fullName);
        c.setUsername(username);
        c.setPassword(password);
        customerDao.register(c);

        response.sendRedirect("/LoginController?s=1");
    }
}
