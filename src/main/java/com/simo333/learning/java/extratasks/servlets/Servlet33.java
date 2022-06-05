package com.simo333.learning.java.extratasks.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Servlet33", value = "/servlet33")
public class Servlet33 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();
        HttpSession session = request.getSession();
        writer.println("<form action='/servlet33' method='post'>");
        String message;
        message = session.getAttribute("field1") == null ? "" : (String) session.getAttribute("field1");
        writer.println("<input type='text' name='field1' value='" + message + "'/><br>");
        message = session.getAttribute("field2") == null ? "" : (String) session.getAttribute("field2");
        writer.println("<input type='text' name='field2' value='" + message + "'/><br>");
        message = session.getAttribute("field3") == null ? "" : (String) session.getAttribute("field3");
        writer.println("<input type='text' name='field3' value='" + message + "'/><br>");
        message = session.getAttribute("field4") == null ? "" : (String) session.getAttribute("field4");
        writer.println("<input type='text' name='field4' value='" + message + "'/><br>");
        message = session.getAttribute("field5") == null ? "" : (String) session.getAttribute("field5");
        writer.println("<input type='text' name='field5' value='" + message + "'/><br>");
        writer.println("<input type='submit'/>");
        writer.println("</form>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String field1 = request.getParameter("field1");
        String field2 = request.getParameter("field2");
        String field3 = request.getParameter("field3");
        String field4 = request.getParameter("field4");
        String field5 = request.getParameter("field5");
        HttpSession session = request.getSession();
        session.setAttribute("field1", field1);
        session.setAttribute("field2", field2);
        session.setAttribute("field3", field3);
        session.setAttribute("field4", field4);
        session.setAttribute("field5", field5);

        doGet(request, response);
    }
}
