package com.example.gafete;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Enlace {
    private static Connection c;

    public static Connection getConexion(){
        try {
            if (c==null) {
                String url = "jdbc:mysql://localhost:3306/gafete";
                //String url = "jdbc:mysql://65.99.252.253:3306/eduwitco_gafete";
                //c = DriverManager.getConnection(url, "eduwitco_gafete", "Gafete.098&");
                c = DriverManager.getConnection(url, "root", "");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }

    public static Connection closeConexion(){
        try {
            c.close();
        }catch (SQLException e){
            e.printStackTrace();
            System.out.println("Se ha cerrado la sesion. ");
        }
        return c;
    }





}
