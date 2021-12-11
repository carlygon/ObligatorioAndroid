package com.example.obligatorioandroid.logica;

import com.example.obligatorioandroid.compartidos.datatypes.DTReunion;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionLogica;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersonalizada;

class LogicaReunion {

    private static LogicaReunion instancia;

    public static LogicaReunion getInstancia(){
        if(instancia == null){
            instancia = new LogicaReunion();
        }

        return  instancia;
    }

    private LogicaReunion(){}

    public void validarReunion(DTReunion reunion)
            throws ExcepcionPersonalizada {
        if(reunion == null){
            throw new ExcepcionLogica("La reunión es nula.");
        }

        if(reunion.getIdReunion() < 1){
            throw new ExcepcionLogica("El Id de la Reuníon debe ser mayor a 1.");
        }

        /*if(reunion.getFechaYHoraReunion() ){
            throw new ExcepcionLogica("La fecha y hora de la reunión no debe coincidir con......");
        }*/
    }
}
