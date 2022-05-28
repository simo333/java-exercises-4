package com.simo333.learning.java.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "Cookie51", value = "/cookie51")
public class Cookie51 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String msg = request.getParameter("msg");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        if(msg != null) {
            writer.append(msg).append("<br>");
        }
        String dateTime = ZonedDateTime.now(ZoneId.systemDefault()).format(DateTimeFormatter.ofPattern("dd.MM.yyyy'+'HH:mm:ss'+'z"));
        System.out.println(dateTime);
        Cookie cookie = new Cookie("lastvisited", dateTime);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
        writer.append("<a href=\"/cookie52\">Przejdź do strony</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
