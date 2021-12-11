package com.example.obligatorioandroid.persistencia;

import android.content.Context;

public class FabricaPersistencia {

    public static IPersistenciaReunion getPersistenciaReunion(Context contexto){
        return PersistenciaReunion.getInstancia(contexto);
    }

    public static IPersistenciaTarea getPersistenciaTarea(Context contexto){
        return PersistenciaTarea.getInstancia(contexto);
    }
}
