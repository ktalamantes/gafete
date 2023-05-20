package com.example.gafete;

import java.sql.Date;

public class ConsultaFecha {
    private int id;
    private int id_persona;
    private Date fecha_vencimiento;

    public ConsultaFecha() {
    }

    public ConsultaFecha(int id, int id_persona, Date fecha_vencimiento) {
        this.id = id;
        this.id_persona = id_persona;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
}
