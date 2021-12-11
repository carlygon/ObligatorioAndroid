package com.example.obligatorioandroid.logica;

import android.content.Context;

public class FabricaLogica {

    public  static IControladorMantenimientoTareas getControladorMantenimientoTareas(Context contexto){
        return ControladorMantenimientoTareas.getInstancia(contexto);
    }

    public  static IControladorMantenimientoReuniones getControladorMantenimientoReuniones(Context contexto){
        return ControladorMantenimientoReuniones.getInstancia(contexto);
    }
}
