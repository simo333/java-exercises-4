package com.simo333.learning.java.form;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Form3", value = "/getForm3")
public class Form3 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String parameter = request.getParameter("page");
        try {
            int number = Integer.parseInt(parameter);
            if (number <= 0) {
                throw new IllegalArgumentException("Liczba musi być dodatnia.");
            }
            List<Integer> dividers = new ArrayList<>();
            dividers.add(1);
            dividers.add(number);
            for (int i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    dividers.add(i);
                }
            }
            response.getWriter().append(dividers.toString());
        } catch (NumberFormatException e) {
            response.getWriter().println("Nie wprowadzono liczby.");
        } catch (IllegalArgumentException e) {
            response.getWriter().println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
