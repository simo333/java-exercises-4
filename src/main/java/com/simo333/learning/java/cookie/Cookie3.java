package com.simo333.learning.java.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie3", value = "/cookie3")
public class Cookie3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        int time = 0;
        try {
            time = Integer.parseInt(request.getParameter("time"));
            if (time < 0) {
                throw new IllegalArgumentException("Czas musi być wartością dodatnią.");
            }
        } catch (NumberFormatException e) {
            response.getWriter().println("Podano niepoprawną wartość czasu życia ciasteczka.");
        } catch (IllegalArgumentException e) {
            response.getWriter().println(e.getMessage());
        }

        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(60 * 60 * time);
        response.addCookie(cookie);
    }
}
