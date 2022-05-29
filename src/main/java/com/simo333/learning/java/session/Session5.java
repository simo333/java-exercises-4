package com.simo333.learning.java.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

@WebServlet(name = "Session5", value = "/session5")
public class Session5 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();

        int number1 = getRandomInt();
        int number2 = getRandomInt();
        session.setAttribute("number1", number1);
        session.setAttribute("number1", number2);
        session.setAttribute("captcha", number1 + number2);


        writer.append("<form method='POST'>");
        writer.append("Imię <input type='text' name='name'><br>");
        writer.append("Nazwisko <input type='text' name='lastname'><br>");
        writer.append("Email <input type='text' name='email'><br>");
        writer.append("Wpisz poniżej sumę liczb: " + number1 + " + " + number2 + "<br>");
        writer.append("Captcha <input type='number' step='1' name='captcha'><br>");
        writer.append("<input type='submit'>");
        writer.append("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        try {
            int captcha = Integer.parseInt(request.getParameter("captcha"));
            if (captcha == (int) session.getAttribute("captcha")) {
                String name = request.getParameter("name");
                String lastname = request.getParameter("lastname");
                String email = request.getParameter("email");
                writer.println("Witaj " + name + " " + lastname + "</br>");
                writer.println("email: " + email);
            } else {
                writer.println("Nieprawidłowa captcha.");
            }
        } catch (NumberFormatException e) {
            writer.println("Nieprawidłowa captcha");
        }
    }

    int getRandomInt() {
        return new Random().nextInt(0, 101);
    }
}
