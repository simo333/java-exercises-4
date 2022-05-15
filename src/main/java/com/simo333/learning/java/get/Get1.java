package com.simo333.learning.java.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Get1", value = "/get1")
public class Get1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        String startString = request.getParameter("start");
        String endString = request.getParameter("end");

        if (startString == null || endString == null) {
            writer.append("BRAK");
        } else {
            try {
                int start = Integer.parseInt(request.getParameter("start"));
                int end = Integer.parseInt(request.getParameter("end"));
                if (start < 0 || end < 0 || start > end) {
                    throw new IllegalArgumentException();
                }
                for (int i = start; i <= end; i++) {
                    writer.println(i);
                }
            } catch (IllegalArgumentException e) {
                writer.println("Podano złe parametry.");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
