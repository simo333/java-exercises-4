package com.simo333.learning.java.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Session4", value = "/session4")
public class Session4 extends HttpServlet {
    List<CartItem> cartItems = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        double sum = 0d;
        for (CartItem cartItem : cartItems) {
            writer.println(cartItem + "<br>");
            sum += cartItem.getPriceForQuantity();
        }
        writer.println("<br>");
        writer.println("SUMA: " + BigDecimal.valueOf(sum).setScale(2, RoundingMode.HALF_UP).doubleValue() + "zł");
        writer.println("<br>");
        writer.println("<a href='session4.html'>Dodaj kolejny przedmiot</a>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();

        try {
            String name = request.getParameter("name");
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            double price = Double.parseDouble(request.getParameter("price"));
            boolean isItemFound = false;
            CartItem item = new CartItem(name, quantity, price);
            for (CartItem cartItem : cartItems) {
                if (cartItem.equals(item)) {
                    cartItem.setPrice(item.getPrice());
                    cartItem.setQuantity(cartItem.getQuantity() + item.getQuantity());
                    isItemFound = true;
                }
            }
            if (!isItemFound) {
                cartItems.add(item);
            }
            session.setAttribute("cartitems", cartItems);
        } catch (NumberFormatException e) {
            writer.append("Błędne parametry");
        }

        doGet(request, response);
    }
}
