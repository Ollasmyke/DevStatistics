package com.webapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB_Connector {
    Connection conn;

    public Connection getConn() {
        try {
                Class.forName(Constants.DB_Class);
                DriverManager.getConnection(Constants.DB_URL, Constants.DB_User, Constants.DB_Pass);
            }
            catch (SQLException  ex) {
                ex.printStackTrace();
            }
            catch (ClassNotFoundException ex){
                ex.printStackTrace();
            }

        return conn;
    }
}
