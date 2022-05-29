package com.simo333.learning.java.filter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {
    private final static String USER = "admin";
    private final static String PASSWORD = "coderslab";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("username");
        String pass = request.getParameter("password");
        HttpSession session = request.getSession();
        if (user.equals(USER) && pass.equals(PASSWORD)) {
            session.setAttribute("username", user);
            session.setMaxInactiveInterval(5); //Logout after being inactive for 5 seconds
            request.setAttribute("valid", true);
            response.sendRedirect("/admin");
        } else {
            request.setAttribute("valid", false);
            getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp")
                    .forward(request, response);
        }
    }
}
