package com.simo333.learning.java.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Session3Add", value = "/addToSession")
public class Session3Add extends HttpServlet {
    List<String> sessionKeys = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append("""
                <form action="" method="POST">
                    <label>
                        Klucz:
                        <input type="text" name="key">
                    </label>
                    <label>
                        Wartość:
                        <input type="text" name="value">
                    </label>
                    <input type="submit">
                </form>""");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        session.setAttribute(key, value);
        sessionKeys.add(key);
        session.setAttribute("sessionkeys", sessionKeys);
        doGet(request, response);
    }
}
