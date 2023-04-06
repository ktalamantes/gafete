package com.example.gafete;

import java.sql.Date;
import java.time.Year;

public class automovil {

    private int id;
    private String matricula;
    private String marca;
    private String color;
    private Year año;

    public automovil(int id, String matricula, String marca, String color, Year año) {
        this.id = id;
        this.matricula = matricula;
        this.marca = marca;
        this.color = color;
        this.año = año;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Year getAño() {
        return año;
    }

    public void setAño(Year año) {
        this.año = año;
    }
}
