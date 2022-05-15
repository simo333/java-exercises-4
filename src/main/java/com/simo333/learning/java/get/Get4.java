package com.simo333.learning.java.get;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get4", value = "/get4")
public class Get4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String companyParam = request.getParameter("company");
        String[] learnParam = request.getParameterValues("learn");
        writer.println("company:");
        writer.println(" - " + companyParam);
        writer.println("learn:");
        for (String param : learnParam) {
            writer.println(" - " + param);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
