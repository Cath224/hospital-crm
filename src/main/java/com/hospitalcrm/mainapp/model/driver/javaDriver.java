package com.hospitalcrm.mainapp.model.driver;

import java.sql.*;

public class javaDriver {
    public  static void main(String[] args) throws SQLException{
        final String user = "postgres";
        final String password = "postgres";
        final String url = "jdbc:postgresql://localhost:5432/hospital";


        final  Connection connection;

        try {
            connection =  DriverManager.getConnection(url,user,password);

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
