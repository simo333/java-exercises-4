package com.simo333.learning.java.servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet23", value = "/servlet23")
public class Servlet23 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> strings = readFromFile();
        for (String string : strings) {
            response.getWriter().println(string);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    List<String> readFromFile() {
        Path path = Paths.get("C:\\Users\\SimoPc\\IdeaProjects\\java-exercises-4\\src\\main\\java\\com\\simo333\\learning\\java\\servlets\\oop.txt");
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}
