package com.simo333.learning.java.session;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Session2", value = "/session2")
public class Session2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append("<form method='POST'>");
        writer.append("Ocena: ");
        writer.append("<input type='text' name='mark'>");
        writer.append("<br>");
        writer.append("<input type='submit'>");
        writer.append("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        doGet(request, response);
        
        HttpSession session = request.getSession();
        List<Double> marks = new ArrayList<>();

        if(session.getAttribute("marks") != null) {
            marks = (List<Double>) session.getAttribute("marks");
        }
        try {
            Double mark = Double.parseDouble(request.getParameter("mark"));
            marks.add(mark);
            session.setAttribute("marks", marks);
            Double sum = 0d;
            for (Double element : marks) {
                writer.append(String.valueOf(element)).append(", ");
                sum += element;
            }
            writer.append("<br>");
            writer.append("Średnia: ").append(String.valueOf(sum / marks.size()));
        } catch (NumberFormatException e) {
            writer.append("Podana ocena nie jest liczbą.");
        }
    }
}
