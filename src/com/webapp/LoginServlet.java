package com.webapp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.AbstractDocument;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
//
//            DB_Connector db = new DB_Connector();
//            Connection conn = db.getConn();
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
            out.println(username + password + LangOne + LangTwo + LangThree);
            out.println(ps);
            out.println(ps2);
            if (rs.getString("username").equals(username) && rs.getString("password").equals(password)){
                int i = ps2.executeUpdate();
                if (i > 0) {
                    out.print("You've successfully edited your Language Preferences.");
                } else {
                    out.println("Error");
                }
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
