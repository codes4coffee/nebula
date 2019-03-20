package com.nebula.controller;

import com.nebula.domain.Customer;
import com.nebula.domain.dao.DbCustomerDao;
import com.nebula.domain.Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        DbCustomerDao customerDao = new DbCustomerDao();

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Login login = new Login(username, password);
        Customer customer = customerDao.validateCustomer(login);

        customerDao.close();

        if (customer != null && customer.getName() != null) {
            HttpSession session = request.getSession();
            session.setAttribute("name", customer.getName());
            System.out.println(session.getAttribute("name"));
            request.setAttribute("message", "Hello " + customer.getName());
            request.getRequestDispatcher("feed.jsp").forward(request, response);
        }
        else {
            request.setAttribute("message", "Data Not Found! Please register!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
