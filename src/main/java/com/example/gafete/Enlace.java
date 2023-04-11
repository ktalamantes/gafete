package com.example.gafete;


import java.sql.Connection;
import java.sql.DriverManager;


public class Enlace {
    private static Connection c;

    public static Connection getConexion(){
        try {
            if (c==null) {
                String url = "jdbc:mysql://localhost:3306/matriculadb";
                c = DriverManager.getConnection(url, "root", "");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }



}
