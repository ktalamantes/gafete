package com.example.gafete;

import java.sql.Date;

public class personal {

    private int id;
    private String nombre;
    private String puesto;
    private String area;

    public personal(int id, String nombre, String puesto, String area) {
        this.id = id;
        this.nombre = nombre;
        this.puesto = puesto;
        this.area = area;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String toString(){
        return this.puesto;
    }

    public personal(String puesto) {
        this.puesto = puesto;
    }

}



