package com.simo333.learning.java.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;

@WebServlet(name = "Servlet25", value = "/servlet25")
public class Servlet25 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Integer> ints = randomNumbers();
        List<Integer> sortedInts = sortedIntegerList(ints);
        PrintWriter writer = response.getWriter();
        for (Integer anInt : ints) {
            writer.println(anInt);
        }

        writer.println();

        for (Integer sortedInt : sortedInts) {
            writer.println(sortedInt);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    List<Integer> randomNumbers() {
        return new Random().ints(10, 1, 101)
                .boxed().toList();
    }

    List<Integer> sortedIntegerList(List<Integer> list) {
        return list.stream().sorted().toList();
    }
}
