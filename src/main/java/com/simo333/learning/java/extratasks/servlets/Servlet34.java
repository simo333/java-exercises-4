package com.simo333.learning.java.extratasks.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet(name = "Servlet34", value = "/servlet34")
public class Servlet34 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Cookie visitCookie;
        visitCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("visited"))
                .findFirst()
                .orElse(new Cookie("visited", "0"));
        visitCookie.setMaxAge(60 * 60 * 24 * 365);
        if (Integer.parseInt(visitCookie.getValue()) > 0) {
            visitCookie.setValue(String.valueOf((Integer.parseInt(visitCookie.getValue()) + 1)));
            response.getWriter().println("Witaj, odwiedziłeś nas już " + visitCookie.getValue() + " razy.");
        }
        if (Integer.parseInt(visitCookie.getValue()) == 0) {
            response.getWriter().println("Witaj pierwszy raz na naszej stronie.");
            visitCookie.setValue("1");
        }
        response.addCookie(visitCookie);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
