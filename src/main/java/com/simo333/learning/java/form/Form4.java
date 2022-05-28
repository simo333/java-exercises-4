package com.simo333.learning.java.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Form4", value = "/post4")
public class Form4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            double a = Double.parseDouble(request.getParameter("a"));
            double b = Double.parseDouble(request.getParameter("b"));
            double c = Double.parseDouble(request.getParameter("c"));
            double delta = Math.pow(b, 2) - 4 * (a * c);
            if (delta < 0) {
                writer.println("Delta jest ujemna. Brak miejsc zerowych");
            }
            if (delta == 0) {
                double x0 = -b / (2 * a);
                writer.println("Delta jest równa zero. Miejsce zerowe równa się: " + x0);
            }
            if (delta > 0) {
                double x1 = (-b - Math.sqrt(delta)) / 2 * a;
                double x2 = (-b + Math.sqrt(delta)) / 2 * a;
                writer.println("Delta jest większa od zera. Miejsca zerowe to: " + x1 + " oraz " + x2);
            }
        } catch (NumberFormatException e) {
            writer.println("Nie wprowadzono liczby.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
