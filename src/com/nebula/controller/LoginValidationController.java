package com.nebula.controller;

import com.nebula.domain.Customer;
import com.nebula.domain.dao.CustomerDaoImpl;
import com.nebula.domain.Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login.
 */
@WebServlet("/login-validation")
public class LoginValidationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginValidationController() {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CustomerDaoImpl customerDao = new CustomerDaoImpl();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Login login = new Login(username, password);
        Customer customer = customerDao.validateCustomer(login);

        customerDao.close();

        if (customer != null && customer.getName() != null) {
            request.setAttribute("message", "Hello " + customer.getName());
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
        else {
            request.setAttribute("message", "Data Not Found! Please register!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
