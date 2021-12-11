package com.example.obligatorioandroid.persistencia;

import android.provider.BaseColumns;

final class BD {

    public static final String NOMBRE_BASE_DATOS = "ObligatorioAndroid.sql";
    public static final int VERSION_BASE_DATOS = 1;

    public static final String TAREAS = "Tareas";
    public static final String REUNIONES = "Reuniones";

    private BD(){}

    public static abstract class Tareas implements BaseColumns{

    }

    public static abstract class Reuniones implements BaseColumns{

    }
}
