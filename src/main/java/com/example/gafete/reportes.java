package com.example.gafete;

public class reportes {
    private int id;
    private String matricula;
    private String nombre_reporta;
    private String descripcion;

    public reportes(int id, String matricula, String nombreR, String descripcion) {
        this.id = id;
        this.matricula = matricula;
        this.nombre_reporta = nombreR;
        this.descripcion = descripcion;
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

    public String getNombre_reporta() {
        return nombre_reporta;
    }

    public void setNombre_reporta(String nombre_reporta) {
        this.nombre_reporta = nombre_reporta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
