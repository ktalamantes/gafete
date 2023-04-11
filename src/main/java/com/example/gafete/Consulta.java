package com.example.gafete;

public class Consulta {
    private int id;
    private String nombre;
    private String marca;
    private String modelo;
    private String matricula;
    private String puesto;

    public Consulta(int id, String nombre, String matricula, String marca, String modelo, String puesto) {
        this.id = id;
        this.nombre = nombre;
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.puesto = puesto;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
