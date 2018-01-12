package com.webapp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String LangOne = request.getParameter("one");
        String LangTwo = request.getParameter("two");
        String LangThree = request.getParameter("three");


        try {
            Class.forName(Constants.DB_Class);
            Connection conn = DriverManager.getConnection(
                    Constants.DB_URL, Constants.DB_User, Constants.DB_Pass);

            PreparedStatement ps, ps2;
            ps = conn.prepareStatement("insert into users values(?,?,?,?,?,?,?)");

            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, username);
            ps.setString(4, password);
            ps.setString(5, LangOne);
            ps.setString(6, LangTwo);
            ps.setString(7, LangThree);

            ps2 = conn.prepareStatement("select username from users where username=?");
            ps2.setString(1, username);

            ResultSet rs = ps2.executeQuery();
            rs.next();

            if (rs.getString("username").equals(username)){
                out.println("Username taken! Register with another username.");

            } else {
                int i = ps.executeUpdate();
            if (i > 0) {
                response.getWriter().write("You've successfully registered and posted a count.");
            }

        }
        }
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

//        out.close();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
