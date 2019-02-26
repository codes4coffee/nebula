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
        String username = request.getParameter("username");
        String fullName = request.getParameter("name");
        String password = request.getParameter("password");
        String retryPassword = request.getParameter("retry-password");

        // TODO: Better server-side validation.
        boolean valid = true;
        if (username.isEmpty()) {
            request.setAttribute("usernameError", true);
            valid = false;
        }
        if (fullName.isEmpty()) {
            request.setAttribute("fullNameError", true);
            valid = false;
        }
        if (password.isEmpty()) {
            request.setAttribute("passwordError", true);
            valid = false;
        }
        if (!password.equals(retryPassword)) {
            request.setAttribute("passwordMatchError", true);
            valid = false;
        }

        if (!valid) {
            request.getRequestDispatcher("/register.jsp").forward(request, response);
        }

        Login login = new Login(username, password);
        CustomerDao customerDao = new CustomerDaoImpl();
        Customer c = customerDao.validateCustomer(login);

        c.setName(fullName);
        c.setUsername(username);
        c.setPassword(password);
        customerDao.register(c);

        response.sendRedirect("/LoginController?s=1");
    }
}
