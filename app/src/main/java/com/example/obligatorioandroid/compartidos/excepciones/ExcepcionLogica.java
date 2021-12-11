package com.example.obligatorioandroid.compartidos.excepciones;

public class ExcepcionLogica extends ExcepcionPersonalizada{

    public ExcepcionLogica(){

    }

    public ExcepcionLogica(String mensaje){
        super(mensaje);
    }

    public ExcepcionLogica(String mensaje, Exception excepcionInterna){
        super(mensaje,excepcionInterna);
    }

}
