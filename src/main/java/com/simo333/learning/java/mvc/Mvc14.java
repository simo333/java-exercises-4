package com.simo333.learning.java.mvc;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Mvc14", value = "/mvc14")
public class Mvc14 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book1", "Author1", "isbn1"));
        books.add(new Book("Book2", "Author2", "isbn2"));
        books.add(new Book("Book3", "Author3", "isbn3"));
        books.add(new Book("Book4", "Author4", "isbn4"));
        books.add(new Book("Book5", "Author5", "isbn5"));

        request.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/WEB-INF/jsp/resultList.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
