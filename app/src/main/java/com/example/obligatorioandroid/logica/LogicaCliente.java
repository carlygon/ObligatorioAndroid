package com.example.obligatorioandroid.logica;

class LogicaCliente {

    private static LogicaCliente instancia;

    public static LogicaCliente getInstancia(){
        if(instancia == null){
            instancia = new LogicaCliente();
        }

        return  instancia;
    }
}
