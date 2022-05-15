package com.simo333.learning.java.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get3", value = "/get3")
public class Get3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String widthString = request.getParameter("width");
        String heightString = request.getParameter("height");
        int width;
        int height;

        if (widthString == null || heightString == null) {
            width = 5;
            height = 10;
        } else {
            try {
                width = Integer.parseInt(widthString);
                height = Integer.parseInt(heightString);
                if (height < 1 || width < 1) {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                width = 5;
                height = 10;
            }
        }

        writer.println("<table style=\"border: 5px solid\">");
        for (int i = 0; i <= width; i++) {
            writer.println("<tr>");
            for (int j = 0; j <= height; j++) {
                if (i == 0 && j == 0) {
                    writer.println("<th style=\"border: 1px solid; padding: 5px\"></th>");
                } else if (i == 0 || j == 0) {
                    writer.println("<th style=\"border: 1px solid; font-size: 20px; text-align:center; padding: 5px\">" + ((i + 1) * (j + 1) - 1) + "</th>");
                } else {
                    writer.println("<td style=\"border: 1px solid; font-size: 15px; text-align:center; padding: 5px\">" + i * j + "</td>");
                }
            }
            writer.println("</tr>");
        }
        writer.println("<table>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
