package com.example.obligatorioandroid.compartidos.datatypes;

import java.io.Serializable;
import java.util.Date;

public class DTReunion implements Serializable {


    private int idReunion;
    private String lugar;
    private boolean notificado;
    private String descripcion;
    private String objetivo;
    private Date fechaYHoraReunion;

    public int getIdReunion() {

        return idReunion;
    }

    public void setIdReunion(int idReunion) {

        this.idReunion = idReunion;
    }

    public String getLugar() {

        return lugar;
    }

    public void setLugar(String lugar) {

        this.lugar = lugar;
    }

    public boolean isNotificado() {

        return notificado;
    }

    public void setNotificado(boolean notificado) {

        this.notificado = notificado;
    }

    public String getDescripcion() {

        return descripcion;
    }

    public void setDescripcion(String descripcion) {

        this.descripcion = descripcion;
    }

    public String getObjetivo() {

        return objetivo;
    }

    public void setObjetivo(String objetivo) {

        this.objetivo = objetivo;
    }

    public Date getFechaYHoraReunion() {

        return fechaYHoraReunion;
    }

    public void setFechaYHoraReunion(Date fechaYHoraReunion) {
        this.fechaYHoraReunion = fechaYHoraReunion;
    }

    public DTReunion() {

        this(1, "N/D", false, "N/D", "N/D", null);
    }

    public  DTReunion(int idR, String lugar, boolean notificado, String descripcion, String objetivo, Date fechaYHoraReunion){
        this.idReunion = idR;
        this.lugar = lugar;
        this.notificado = notificado;
        this.descripcion = descripcion;
        this.objetivo = objetivo;
        this.fechaYHoraReunion = fechaYHoraReunion;
    }
}
