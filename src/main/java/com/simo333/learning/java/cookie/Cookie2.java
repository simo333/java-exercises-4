package com.simo333.learning.java.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Cookie2", value = "/addToCookies")
public class Cookie2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ZADANIE 4 JSP
        Cookie cookieFoo = new Cookie("foo", "bar");
        cookieFoo.setMaxAge(60*60);
        response.addCookie(cookieFoo);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");

        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(60 * 60 * 24);

        response.addCookie(cookie);
    }
}
