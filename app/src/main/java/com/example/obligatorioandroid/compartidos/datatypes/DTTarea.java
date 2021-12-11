package com.example.obligatorioandroid.compartidos.datatypes;

import java.io.Serializable;
import java.util.Date;

public class DTTarea implements Serializable {

    private int idTarea;
    private Date fechaLimite;
    private String descripcion;
    private boolean realizada;

    public int getIdTarea() {

        return idTarea;
    }

    public void setIdTarea(int idTarea) {

        this.idTarea = idTarea;
    }

    public Date getFechaLimite() {

        return fechaLimite;
    }

    public void setFechaLimite(Date fechaLimite) {

        this.fechaLimite = fechaLimite;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    public boolean isRealizada() {

        return realizada;
    }

    public void setRealizada(boolean realizada) {

        this.realizada = realizada;
    }

    public DTTarea(){

        this(1, null, "N/D", false);
    }

    public DTTarea(int idT, Date fechaLimite, String descripcion, boolean realizada){
        this.idTarea = idT;
        this.fechaLimite = fechaLimite;
        this.descripcion = descripcion;
        this.realizada = realizada;
    }
}
