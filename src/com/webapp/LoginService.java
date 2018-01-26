package com.webapp;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginService")
public class LoginService extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("username"); // USERNAME from the login form
        String password = request.getParameter("password"); // password from login form
        String LangOne = request.getParameter("one");       //
        String LangTwo = request.getParameter("two");       //
        String LangThree = request.getParameter("three");

        try {
            Class.forName(Constants.DB_Class);
            Connection conn = DriverManager.getConnection(
                    Constants.DB_URL, Constants.DB_User, Constants.DB_Pass);

            PreparedStatement ps, ps2;

            ps = conn.prepareStatement("select username,password from users where username=? and password=?"); // user_name
            ps.setString(1, username);
            ps.setString(2, password);

            ps2 = conn.prepareStatement("update users SET language_one = ?, language_two = ?, language_three = ? WHERE username like ?");
            ps2.setString(1, LangOne);
            ps2.setString(2, LangTwo);
            ps2.setString(3, LangThree);
            ps2.setString(4, username);

            ResultSet rs = ps.executeQuery();
            rs.next();
            if (rs.getString("username").equals(username) && rs.getString("password").equals(password)){
                int i = ps2.executeUpdate();
                if (i > 0)
                    out.print("You've successfully edited your Language Preferences.");
            } else {
                out.print("Invalid Login Credentials");
            }
            out.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}