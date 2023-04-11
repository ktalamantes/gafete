package com.example.gafete;

import java.sql.Date;

public class autos {

    private int id;
    private String personal;
    private String automovil;

    public autos(int id, String personal, String automovil) {
        this.id = id;
        this.personal = personal;
        this.automovil = automovil;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }

    public String getAutomovil() {
        return automovil;
    }

    public void setAutomovil(String automovil) {
        this.automovil = automovil;
    }
}
