package com.example.obligatorioandroid.persistencia;

import android.provider.BaseColumns;

final class BD {

    public static final String NOMBRE_BASE_DATOS = "ObligatorioAndroid.sqlite3";
    public static final int VERSION_BD = 1;

//TABLAS

    public static final String CLIENTES = "Clientes";
    public static final String COMERCIALES = "Comerciales";
    public static final String PARTICULARES = "Particulares";
    public static final String EVENTOS = "Eventos";
    public static final String TAREAS = "Tareas";
    public static final String GASTOS = "Gastos";
    public static final String REUNIONES = "Reuniones";


    //CONSTRUCTOR PRIVADO

    private BD(){}


    public static abstract class Clientes implements BaseColumns{
        //CAMPOS
        //public static final String ID_CLIENTE = "Id_cliente";
        public static final String DIRECCION = "Direccion";
        public static final String TELEFONO = "Telefono";
        public static final String CORREO = "Correo";

        public static final String[] COLUMNAS ={_ID, DIRECCION, TELEFONO, CORREO};


        //CREAMOS LA TABLA

        public static final String SQL_CREAR_TABLA = new StringBuilder("CREATE TABLE ").append(CLIENTES)
                .append(" (").append(_ID).append(" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ")
                .append(DIRECCION).append(" TEXT NOT NULL, ")
                .append(TELEFONO).append(" TEXT NOT NULL, ")
                .append(CORREO).append(" TEXT NOT NULL)").toString();

        public static final String SQL_ELIMINAR_TABLA = new StringBuilder("DROP TABLE IF EXISTS ")
                .append(CLIENTES).append(";").toString();



    }

    public static abstract class Comerciales implements BaseColumns{
        //campos

        public static final String ID_CLIENTE = "Id_cliente";
        public static final String RUT = "Rut";
        public static final String RAZON_SOCIAL = "Razon_social";

        public static final String[] COLUMNAS = {ID_CLIENTE, RUT, RAZON_SOCIAL};

        public static final String SQL_CREAR_TABLA = new StringBuilder("CREATE TABLE ").append(COMERCIALES)
                .append(" (").append(ID_CLIENTE).append(" INTEGER NOT NULL PRIMARY KEY FOREIGN KEY REFERENCES ").append(CLIENTES).append("(_id), ")
                .append(RUT).append(" INTEGER NOT NULL, ")
                .append(RAZON_SOCIAL).append(" TEXT NOT NULL)").toString();

        public static final String SQL_ELIMINAR_TABLA = new StringBuilder("DROP TABLE IF EXISTS ")
                .append(COMERCIALES).toString();

    }

    public static abstract class Particulares implements BaseColumns{

        //CAMPOS
        public static final String ID_CLIENTE = "Id_cliente";
        public static final String CEDULA = "Cedula";
        public static final String N_COMPLETO = "N_completo";

        public static final String[] COLUMNAS = {ID_CLIENTE, CEDULA, N_COMPLETO};

        public static final String SQL_CREAR_TABLA = new StringBuilder("CREATE TABLE ").append(PARTICULARES)
                .append(" (").append(ID_CLIENTE).append(" INTEGER NOT NULL PRIMARY KEY FOREIGN KEY REFERENCES ").append(CLIENTES).append("(_id), ")
                .append(CEDULA).append(" INTEGER NOT NULL, ")
                .append(N_COMPLETO).append(" TEXT NOT NULL)").toString();

        public static final String SQL_ELIMINAR_TABLA = new StringBuilder("DROP TABLE IF EXISTS ").append(PARTICULARES).toString();
    }

    public static abstract class Eventos implements BaseColumns{

        //CAMPOS

        public static final String NRO_EVENTO = "Nro_evento";
        public static final String FECHA_Y_HORA = "Fyh";
        public static final String DURACION = "Duracion";
        public static final String TITULO = "Titulo";
        public static final String CANTIDAD = "CantidadA";
        public static final String ID_CLIENTE = "Id_cliente";

        public static final String[] COLUMNAS = {NRO_EVENTO, FECHA_Y_HORA, DURACION, TITULO, CANTIDAD, ID_CLIENTE};

        public static final String SQL_CREAR_TABLA = new StringBuilder("CREATE TABLE ").append(EVENTOS).append(" (")
                .append(NRO_EVENTO).append(" INTEGER PRIMARY KEY, ")
                .append(FECHA_Y_HORA).append(" TEXT NOT NULL, ")
                .append(DURACION).append(" INTEGER NOT NULL, ")
                .append(TITULO).append(" TEXT NOT NULL, ")
                .append(CANTIDAD).append(" INTEGER NOT NULL, ")
                .append(ID_CLIENTE).append(" INTEGER NOT NULL FOREIGN KEY REFERENCES ").append(CLIENTES).append("(_id))").toString();

        public static final String SQL_ELIMINAR_TABLA = new StringBuilder("DROP TABLE IF EXISTS ").append(EVENTOS).toString();

    }

    public static abstract class Tareas implements BaseColumns{

        //CAMPOS

        public static final String ID_TAREA = "Id_tarea";
        public static final String NRO_EVENTO = "Nro_evento";
        public static final String DESCRIPCION = "Descripcion";
        public static final String FECHA_LIM = "Fecha_lim";
        public static final String REALIZADA = "Realizada";

        public static final String[] COLUMNAS = {ID_TAREA,NRO_EVENTO,DESCRIPCION,FECHA_LIM,REALIZADA};

        public static final String SQL_CREAR_TABLA = new StringBuilder("CREATE TABLE ").append(TAREAS).append(" (")
                .append(ID_TAREA).append(" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ")
                .append(NRO_EVENTO).append(" INTEGER FOREIGN KEY REFERENCES ").append(EVENTOS).append("(Nro_evento), ")
                .append(DESCRIPCION).append(" TEXT NOT NULL, ")
                .append(FECHA_LIM).append(" TEXT NOT NULL, ")
                .append(REALIZADA).append(" TEXT NOT NULL DEFAULT('0'))").toString();

        public static final String SQL_ELIMINAR_TABLA = new StringBuilder("DROP TABLE IF EXISTS ").append(TAREAS).toString();


    }

    public static abstract class Gastos implements BaseColumns{
        //CAMPOS

        public static final String ID_GASTO = "Id_gasto";
        public static final String NRO_EVENTO = "Nro_evento";
        public static final String DESCRIPCION = "Descripcion";
        public static final String NOMBRE = "Nombre";
        public static final String MONTO = "Monto";

        public static final String[] COLUMNAS = {ID_GASTO, NRO_EVENTO, DESCRIPCION, NOMBRE, MONTO};

        public static final String SQL_CREAR_TABLA = new StringBuilder("CREATE TABLE ").append(GASTOS).append(" (")
                .append(ID_GASTO).append(" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENTS, ")
                .append(NRO_EVENTO).append(" INTEGER FOREIGN KEY REFERENCES ").append(EVENTOS).append("(Nro_evento), ")
                .append(DESCRIPCION).append(" TEXT NOT NULL, ")
                .append(NOMBRE).append(" TEXT NOT NULL, ")
                .append(MONTO).append(" DOUBLE NOT NULL)").toString();

        public static final String SQL_ELIMINAR_TABLA = new StringBuilder("DROP TABLE IF EXISTS ").append(GASTOS).toString();


    }

    public static abstract class Reuniones implements BaseColumns{

        //campos

        public static final String ID_REUNION = "Id_Reunion";
        public static final String NRO_EVENTO = "Nro_evento";
        public static final String DESCRIPCION = "Descripcion";
        public static final String OBJETIVO = "Objetivo";
        public static final String FECHA_Y_HORA = "FyH";
        public static final String LUGAR = "Lugar";
        public static final String NOTIFICADO = "Notificado";

        public static final String[] COLUMNAS = {ID_REUNION, NRO_EVENTO, DESCRIPCION, OBJETIVO, FECHA_Y_HORA, LUGAR, NOTIFICADO};

        public static final String SQL_CREAR_TABLA = new StringBuilder("CREATE TABLE ").append(REUNIONES).append(" (")
                .append(ID_REUNION).append(" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, ")
                .append(NRO_EVENTO).append(" INTEGER NOT NULL FOREIGN KEY REFERENCES ").append(EVENTOS).append(" (Nro_evento), ")
                .append(DESCRIPCION).append(" TEXT NOT NULL, ")
                .append(OBJETIVO).append(" TEXT NOT NULL, ")
                .append(FECHA_Y_HORA).append(" TEXT NOT NULL, ")
                .append(LUGAR).append(" TEXT NOT NULL, ")
                .append(NOTIFICADO).append(" TEXT NOT NULL DEFAULT('0'))").toString();

        public static final String SQL_ELIMINAR_TABLA = new StringBuilder("DROP TABLE IF EXISTS ").append(REUNIONES).toString();
    }



}
