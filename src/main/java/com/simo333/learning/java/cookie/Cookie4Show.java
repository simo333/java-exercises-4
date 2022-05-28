package com.simo333.learning.java.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookie4Show", value = "/showAllCookies")
public class Cookie4Show extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        for (Cookie cookie : cookies) {
            writer.append(cookie.getName()).append(" : ").append(cookie.getValue());
            writer.append(" <a href=\"/removeCookie?cookiename=")
                    .append(cookie.getName())
                    .append("\">Usuń ciasteczko</a><br>");

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
