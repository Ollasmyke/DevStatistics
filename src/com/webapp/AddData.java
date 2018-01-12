package com.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet(name = "AddData")
public class AddData extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String LangOne = request.getParameter("language_one");
        String LangTwo = request.getParameter("language_two");
        String username = request.getParameter("username");

        if (username == null || username == ""){
            out.println();
        }

        try {
            Class.forName(Constants.DB_Class);

            Connection conn = DriverManager.getConnection(
                    Constants.DB_URL, Constants.DB_User, Constants.DB_Pass);

            PreparedStatement ps = conn.prepareStatement("update users SET language_one = ?, language_two = ? WHERE username like ?");

            ps.setString(1, LangOne);
            ps.setString(2, LangTwo);
            ps.setString(3, username);

            int i = ps.executeUpdate();
            if (i > 0)
                out.print("You are successfully added your LAnguages.");

        } catch (Exception e2) {
            System.out.println(e2);
        }

        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
