package com.simo333.learning.java.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie1Del", value = "/deleteCookie")
public class Cookie1Del extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        boolean found = false;
        for (int i = 0; i < cookies.length; i++) {
            if (cookies[i].getName().equals("User")) {
                cookies[i].setMaxAge(0);
                response.addCookie(cookies[i]);
                found = true;
            }
        }
        if (!found) {
            response.getWriter().println("BRAK");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
