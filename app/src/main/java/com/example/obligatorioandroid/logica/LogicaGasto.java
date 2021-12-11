package com.example.obligatorioandroid.logica;

class LogicaGasto {

    private static LogicaGasto instancia;

    public static LogicaGasto getInstancia(){
        if(instancia == null){
            instancia = new LogicaGasto();
        }

        return  instancia;
    }
}
