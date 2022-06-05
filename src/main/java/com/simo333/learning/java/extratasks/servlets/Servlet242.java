package com.simo333.learning.java.extratasks.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet242", value = "/Servlet242")
public class Servlet242 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] products = {
                "Asus Transformer;2999.99",
                "iPhone 6';3499.18",
                "Converse Sneakers;125.00",
                "LG OLED55B6P OLED TV;6493.91",
                "Samsung HT-J4100;800.99",
                "Alpine Swiss Dress Belt;99.08",
                "60 Watt LED;1.50",
                "Arduino Nano;3.26",
        };
        List<List<String>> listOfProduct = new ArrayList<>();
        for (String product : products) {
            listOfProduct.add(List.of(product.split(";")));
        }
        int idParam = -1;
        try {
            idParam = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.getWriter().println("Wrong parameter. " + e.getMessage());
        }
        if(idParam >= 0 && idParam < 8) {
            response.getWriter().println(listOfProduct.get(idParam).get(0) + " - "
                    + listOfProduct.get(idParam).get(1) + "zł");
        } else {
            response.getWriter().println("Product not found.");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
