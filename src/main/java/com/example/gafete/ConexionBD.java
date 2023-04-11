package com.example.gafete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConexionBD {

    private  static Connection c;

    public static Connection getConexion(){
        try {
            if (c==null) {
                String url = "jdbc:mysql://localhost:3306/matricula";
                //Paso 1 = Crear una conexion;
                c = DriverManager.getConnection(url, "root", "");
            }
        }catch (Exception e){
            System.out.println("No se pudo conectar ala BD");
            e.printStackTrace();

        }
        return c;
    }
}