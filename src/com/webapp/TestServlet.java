package com.webapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestServlet")
public class TestServlet extends HttpServlet {

//    protected void
    private void processRequest(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("DEER");
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
        PrintWriter out = response.getWriter();

        String LangTwo = "God";
        out.print(LangTwo);
        System.out.println(LangTwo);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/test.jsp");
        request.setAttribute("queryResults", out);
        dispatcher.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
