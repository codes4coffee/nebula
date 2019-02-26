package com.nebula.controller;

import com.nebula.domain.Customer;
import com.nebula.domain.dao.CustomerDao;
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
@WebServlet("/LoginValidationController")
public class LoginValidationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public LoginValidationController() {}

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        CustomerDao customerDao = new CustomerDaoImpl();

        String username = request.getParameter("username");
        String pass = request.getParameter("password");
        String submitType = request.getParameter("submit");
        Login login = new Login(username, pass);
        Customer c = customerDao.validateCustomer(login);

        if (submitType.equals("login") && c != null && c.getName() != null) {
            request.setAttribute("message", "Hello " + c.getName());
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
        else if (submitType.equals("register")) {
            c.setName(request.getParameter("name"));
            c.setUsername(request.getParameter("username"));
            c.setPassword(request.getParameter("password"));
            customerDao.register(c);
            //request.setAttribute("successMessage", "Registration done, please login!");
            response.sendRedirect("/LoginController?s=1");
        }
        else {
            request.setAttribute("message", "Data Not Found! Please register!");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
