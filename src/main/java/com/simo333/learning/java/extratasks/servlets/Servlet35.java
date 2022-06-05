package com.simo333.learning.java.extratasks.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

@WebServlet(name = "Servlet35", value = "/servlet35")
public class Servlet35 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        try {
            double num1 = Double.parseDouble(request.getParameter("num1"));
            double num2 = Double.parseDouble(request.getParameter("num2"));
            double num3 = Double.parseDouble(request.getParameter("num3"));
            double num4 = Double.parseDouble(request.getParameter("num4"));
            writer.println("Średnia: " + avg(num1, num2, num3, num4) + "<br>");
            writer.println("Suma: " + sum(num1, num2, num3, num4) + "<br>");
            writer.println("Iloczyn: " + multiply(num1, num2, num3, num4) + "<br>");
        } catch (NumberFormatException e) {
            writer.println("Podano nieprawidłowe dane");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    private double sum(double... nums) {
        return Arrays.stream(nums).sum();
    }

    private double multiply(double... nums) {
        return Arrays.stream(nums).reduce((a, b) -> a * b).orElse(0);
    }

    private double avg(double... nums) {
        return Arrays.stream(nums).average().orElse(0);
    }
}
