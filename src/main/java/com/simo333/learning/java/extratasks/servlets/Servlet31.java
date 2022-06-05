package com.simo333.learning.java.extratasks.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet31", value = "/servlet31")
public class Servlet31 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("exchange");
        String valueString = request.getParameter("value");
        System.out.println(parameter);

        PrintWriter writer = response.getWriter();
        try {
            double value = Double.parseDouble(valueString);
            if (value <= 0) {
                throw new IllegalArgumentException("Nie podano dodatniej wartości.");
            }
            if("eurpln".equals(parameter)) {
                writer.println(value + " EUR to " + value * 4.64 + " PLN");
            }
              if("plneur".equals(parameter)) {
                writer.println(value + " PlN to " + value / 4.64 + " EUR");
            }

        } catch (NumberFormatException e) {
            writer.println("Podano nieprawidłową wartość");
        } catch (IllegalArgumentException e) {
            writer.println(e.getMessage());
        }
    }
}
