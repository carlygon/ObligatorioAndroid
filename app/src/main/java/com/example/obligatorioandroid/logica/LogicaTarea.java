package com.example.obligatorioandroid.logica;

import com.example.obligatorioandroid.compartidos.datatypes.DTReunion;
import com.example.obligatorioandroid.compartidos.datatypes.DTTarea;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionLogica;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersonalizada;

class LogicaTarea {

    private static LogicaTarea instancia;

    public static LogicaTarea getInstancia(){
        if(instancia == null){
            instancia = new LogicaTarea();
        }

        return  instancia;
    }

    private LogicaTarea(){}

    public void validarTarea(DTTarea tarea)
            throws ExcepcionPersonalizada {
        if (tarea == null) {
            throw new ExcepcionLogica("La tarea es nula.");
        }

        if (tarea.getIdTarea() < 1) {
            throw new ExcepcionLogica("El Id de la tarea debe ser mayor a 1.");
        }

        if (tarea.getDescripcion() == null || tarea.getDescripcion().trim().isEmpty()) {
            throw new ExcepcionLogica("La descripción de la tarea no puede quedar vacia.");
        }

        if (tarea.getDescripcion().length() > 100 || tarea.getDescripcion().trim().isEmpty()) {
            throw new ExcepcionLogica("La descripción no puede tener más de 100 catacteres.");
        }

        /*if (tarea.getFechaLimite().before()) {
            throw new ExcepcionLogica("La fecha límite no puede ........");
        }*/

    }
}
