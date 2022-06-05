package com.simo333.learning.java.extratasks.servlets;

import org.apache.commons.lang3.ArrayUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Servlet32", value = "/servlet32")
public class Servlet32 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        try {
            String stringValue = request.getParameter("value");
            char[] charArray = stringValue.toCharArray();
            int[] digits = new int[charArray.length];
            for (int i = 0; i < digits.length; i++) {
                digits[i] = Character.getNumericValue(charArray[i]);
                if (digits[i] != 0 && digits[i] != 1) {
                    throw new IllegalArgumentException();
                }
            }
            writer.println("Wynik to " + countBinaryToDecimal(digits));

        } catch (IllegalArgumentException e) {
            writer.println("Nieprawidłowa wartość.");
        }
    }

    private int countBinaryToDecimal(int[] digits) {
        int decimal = 0;
        ArrayUtils.reverse(digits);
        for (int i = 0; i < digits.length; i++) {
            decimal += digits[i] * Math.pow(2, i);
        }
        return decimal;
    }
}
