package com.simo333.learning.java.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Mvc12", value = "/mvc12")
public class Mvc12 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            int start = Integer.parseInt(request.getParameter("start")) + 10;
            int end = Integer.parseInt(request.getParameter("end")) + 10;
            request.setAttribute("start", start);
            request.setAttribute("end", end);
        } catch (NumberFormatException e) {
            request.setAttribute("message", "Brak parametrów lub podane parametry nie są liczbami.");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/jsp2.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
