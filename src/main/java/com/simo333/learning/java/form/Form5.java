package com.simo333.learning.java.form;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;

@WebServlet(name = "Form5", value = "/post5")
public class Form5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        try {
            String conversionType = request.getParameter("conversionType");
            double degrees = Double.parseDouble(request.getParameter("degrees"));
            if(conversionType.equals("celcToFahr")) {
                BigDecimal degreesF = BigDecimal.valueOf(2 * (degrees - 0.1 * degrees) + 32)
                        .setScale(2, RoundingMode.HALF_UP);
                writer.println(degrees + " stopni Celsjusza to " + degreesF + " stopni Fahrenheita.");
            }
            if(conversionType.equals("FahrToCelc")) {
                BigDecimal degreesC = BigDecimal.valueOf(((degrees - 32) / 2.0) * 1.1)
                        .setScale(2, RoundingMode.HALF_UP);
                writer.println(degrees + " stopni Fahrenheita to " + degreesC + " stopni Celsjusza.");
            }
        } catch (NumberFormatException e) {
            writer.println("Nie wprowadzono liczby jako wartość temperatury.");
        }
    }
}
