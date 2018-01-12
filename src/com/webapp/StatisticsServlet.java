package com.webapp;

import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

        @WebServlet(name = "StatisticsServlet")
        public class StatisticsServlet extends HttpServlet {
            protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                response.setContentType("text/plain");
                PrintWriter out = response.getWriter();

                String username = request.getParameter("username");
//                out.println(username);


        try {
            Class.forName(Constants.DB_Class);
            Connection conn = DriverManager.getConnection(Constants.DB_URL, Constants.DB_User, Constants.DB_Pass);

            PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) as 'count' FROM users GROUP BY language_one ORDER BY COUNT(*) DESC");

            PreparedStatement ps2 = conn.prepareStatement("SELECT language_one FROM users GROUP BY language_one ORDER BY COUNT(*) DESC");
            PreparedStatement ps3 = conn.prepareStatement("SELECT COUNT(*) as 'count2' FROM users GROUP BY language_two ORDER BY language_one DESC");
            PreparedStatement ps4 = conn.prepareStatement("SELECT COUNT(*) as 'count3' FROM users GROUP BY language_three ORDER BY COUNT(*) DESC");

            ResultSet rs = ps.executeQuery();
            ResultSet rs2 = ps2.executeQuery();
            ResultSet rs3 = ps3.executeQuery();
            ResultSet rs4 = ps4.executeQuery();

            List<String> countLang = new ArrayList<String>();
            while (rs2.next()) {
                String first_name = rs2.getString("language_one");
                countLang.add(first_name);
            }

            List<String> countLang1 = new ArrayList<String>();
            while (rs.next()) {
                String count = rs.getString("count");
                countLang1.add(count);
            }




            List<String> countLang2 = new ArrayList<String>();
            while (rs3.next()) {
                String second_name = rs3.getString("count2");
                countLang2.add(second_name);
            }


            List<String> countLang3 = new ArrayList<String>();
            while (rs4.next()) {
                String third_name = rs4.getString("count3");
                countLang3.add(third_name);
            }

//            while (rs.next()) {
//                String count = rs.getString(1);
//               String lid = rs.getString(2);
//             }


//            int i = rs.getInt(1);
//            int i = ps2.executeUpdate();
//            if (i > 0){
//

//            }
//            List<String> countLang = new ArrayList<String>();
//            while(rs.next())
//                countLang.add(rs2.getString(1));

            Gson gson = new Gson();

            String jsonCountLang = gson.toJson(countLang);
//            out.println(jsonCountLangOne);
            String jsonCountLang1 = gson.toJson(countLang1);
//            out.println(jsonCountLang);
            String jsonCountLang2 = gson.toJson(countLang2);
//            out.println(jsonCountLang2);
            String jsonCountLang3 = gson.toJson(countLang3);
//            out.println(jsonCountLang3);

            response.setContentType("application/json");
            response.setCharacterEncoding("UTF-8");
            out.println(jsonCountLang);
//            out.println(jsonCountLang1);


        } catch (SQLException | ClassNotFoundException e) {
           e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
