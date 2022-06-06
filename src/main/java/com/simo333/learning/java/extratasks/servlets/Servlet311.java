package com.simo333.learning.java.extratasks.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Servlet311", value = "/servlet311")
public class Servlet311 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> lang = new HashMap<>();
        lang.put("en", "Hello");
        lang.put("pl", "Cześć");
        lang.put("de", "Hallo");
        lang.put("es", "Hola");
        lang.put("fr", "Salut");

        Cookie[] cookies = request.getCookies();
        Cookie cookieLang = Arrays.stream(cookies).filter(cookie ->
                        cookie.getName().equals("lang"))
                .findFirst()
                .orElse(null);

        if (cookieLang == null) {
            request.setAttribute("msg", "Cześć!");
        }
        if (cookieLang != null) {
            cookieLang.setValue(lang.get(cookieLang.getValue()) + "!");
            cookieLang.setMaxAge(60 * 60 * 24 * 30);
            response.addCookie(cookieLang);
        }
        getServletContext().getRequestDispatcher("/WEB-INF/page311.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
