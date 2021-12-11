package com.example.obligatorioandroid.compartidos.excepciones;

public class ExcepcionPersistencia extends ExcepcionPersonalizada{

    public ExcepcionPersistencia(){

    }

    public ExcepcionPersistencia(String mensaje){
        super(mensaje);
    }

    public ExcepcionPersistencia(String mensaje, Exception excepcionInterna){
        super(mensaje,excepcionInterna);
    }

}
