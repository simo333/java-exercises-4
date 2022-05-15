package com.simo333.learning.java.get;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "Get2", value = "/get2")
public class Get2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String param : parameterMap.keySet()) {
            System.out.println(param);
            System.out.println(Arrays.toString(parameterMap.get(param)));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
