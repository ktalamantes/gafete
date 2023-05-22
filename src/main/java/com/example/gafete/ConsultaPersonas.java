package com.example.gafete;

public class ConsultaPersonas {
    private int id;
    private String nombre;
    private String matricula;

    public ConsultaPersonas(int id, String nombre, String matricula) {
        this.id = id;
        this.nombre = nombre;
        this.matricula = matricula;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
