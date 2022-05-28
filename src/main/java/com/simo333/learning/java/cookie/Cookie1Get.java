package com.simo333.learning.java.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Cookie1Get", value = "/showCookie")
public class Cookie1Get extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        PrintWriter writer = response.getWriter();
        boolean isExist = false;
        for (Cookie cookie : cookies) {
            if ("User".equals(cookie.getName())) {
                isExist = true;
                writer.append(cookie.getValue());
            }
        }
        if (!isExist) {
            writer.append("Nie znaleziono ciasteczka");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
