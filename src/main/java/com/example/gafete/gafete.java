package com.example.gafete;

import java.sql.Date;

public class gafete {

    private int idautomovil;
    private Date fecha_emision;
    private Date fecha_vencimiento;

    public gafete(int idautomovil, Date fecha_emision, Date fecha_vencimiento) {
        this.idautomovil = idautomovil;
        this.fecha_emision = fecha_emision;
        this.fecha_vencimiento = fecha_vencimiento;
    }

    public int getIdautomovil() {
        return idautomovil;
    }

    public void setIdautomovil(int idautomovil) {
        this.idautomovil = idautomovil;
    }

    public Date getFecha_emision() {
        return fecha_emision;
    }

    public void setFecha_emision(Date fecha_emision) {
        this.fecha_emision = fecha_emision;
    }

    public Date getFecha_vencimiento() {
        return fecha_vencimiento;
    }

    public void setFecha_vencimiento(Date fecha_vencimiento) {
        this.fecha_vencimiento = fecha_vencimiento;
    }
}
