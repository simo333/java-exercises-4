package com.simo333.learning.java.cookie;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "Cookie52", value = "/cookie52")
public class Cookie52 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        boolean cookieExist = false;
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("lastvisited")) {
                response.getWriter().append("Witamy na stronie Cookie52");
                cookie.setMaxAge(0);
                cookieExist = true;
            }
        }
        if(!cookieExist) {
            String message = "Nie odwiedziłeś jeszcze tej strony";
            response.sendRedirect("cookie51?msg=" + URLEncoder.encode(message, StandardCharsets.UTF_8));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
