package com.simo333.learning.java.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "Mvc13", value = "/mvc13")
public class Mvc13 extends HttpServlet {
    Map<String, String> fieldsValidationErrors = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/jsp3.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        boolean validForm = true;
        if (title.equals("")) {
            fieldsValidationErrors.put("titleError", "Pole 'Title' nie może być puste.");
            validForm = false;
        } else {
            fieldsValidationErrors.put("titleError", null);
        }
        String author = request.getParameter("author");
        if (author.equals("")) {
            fieldsValidationErrors.put("authorError", "Pole 'Author' nie może być puste.");
            validForm = false;
        } else {
            fieldsValidationErrors.put("authorError", null);
        }
        String isbn = request.getParameter("isbn");
        if (isbn.equals("")) {
            fieldsValidationErrors.put("isbnError", "Pole 'ISBN' nie może być puste.");
            validForm = false;
        } else {
            fieldsValidationErrors.put("isbnError", null);
        }
        if (validForm) {
            Book newBook = new Book(title, author, isbn);
            request.setAttribute("book", newBook);

            getServletContext().getRequestDispatcher("/WEB-INF/jsp/result.jsp")
                    .forward(request, response);
        } else {
            request.setAttribute("titleField", title);
            request.setAttribute("authorField", author);
            request.setAttribute("isbnField", isbn);

            request.setAttribute("errors", fieldsValidationErrors);

            getServletContext().getRequestDispatcher("/WEB-INF/jsp/jsp3.jsp")
                    .forward(request, response);
        }
    }
}
