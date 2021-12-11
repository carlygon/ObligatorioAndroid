package com.example.obligatorioandroid.logica;

class LogicaEvento {

    private static LogicaEvento instancia;

    public static LogicaEvento getInstancia(){
        if(instancia == null){
            instancia = new LogicaEvento();
        }

        return  instancia;
    }
}
