package com.example.obligatorioandroid.persistencia;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class BDHelper extends SQLiteOpenHelper {

    private Context contexto;

    public BDHelper(Context contexto){
        super(contexto, BD.NOMBRE_BASE_DATOS, null, BD.VERSION_BD);
        this.contexto = contexto;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //creamos las tablas

        db.execSQL(BD.Clientes.SQL_CREAR_TABLA);
        db.execSQL(BD.Comerciales.SQL_CREAR_TABLA);
        db.execSQL(BD.Particulares.SQL_CREAR_TABLA);
        db.execSQL(BD.Eventos.SQL_CREAR_TABLA);
        db.execSQL(BD.Tareas.SQL_CREAR_TABLA);
        db.execSQL(BD.Gastos.SQL_CREAR_TABLA);
        db.execSQL(BD.Reuniones.SQL_CREAR_TABLA);


        //DATOS DE PRUEBA
        String cliente1 = new StringBuilder("INSERT INTO ").append(BD.CLIENTES).append(" VALUES(NULL, '18 DE JULIO 2550', '22011010', 'alfred@gmail.com');").toString();
        String cliente2 = new StringBuilder("INSERT INTO ").append(BD.CLIENTES).append(" VALUES(NULL, 'Rmbla REP. DE PERU 3035', '25054646', 'giules.esteban@hotmail.com');").toString();
        String cliente3 = new StringBuilder("INSERT INTO ").append(BD.CLIENTES).append(" VALUES(NULL, 'CALLE 36 S 15 M 20', '26137998', 'enriqueta.perez@gmail.com');").toString();

        db.execSQL(cliente1);
        db.execSQL(cliente2);
        db.execSQL(cliente3);

        db.execSQL(new StringBuilder("INSERT INTO ").append(BD.COMERCIALES).append(" VALUES(2, '213540021511', 'AZUCARLITO S.A');").toString());
        db.execSQL(new StringBuilder("INSERT INTO ").append(BD.PARTICULARES).append(" VALUES(1, 12345678, 'Alfred Dimitri');").toString());
        db.execSQL(new StringBuilder("INSERT INTO ").append(BD.PARTICULARES).append(" VALUES(3, 30098872, 'Enriqueta Perez');").toString());

        String evento1 = new StringBuilder("INSERT INTO ").append(BD.EVENTOS).append(" VALUES(NULL, '2021-12-10 21:30:00', 240, 'Despedida de Soltero', 'Social', 10, 2);").toString();
        String evento2 = new StringBuilder("INSERT INTO ").append(BD.EVENTOS).append(" VALUES(NULL, '2021-12-30 21:00:00', 120, 'Comida fin de curso', 'Social', 10, 3);").toString();
        String evento3 = new StringBuilder("INSERT INTO ").append(BD.EVENTOS).append(" VALUES(NULL, '2022-01-12 21:30:00', 300, 'Fiesta de 15', 'Familiar', 10, 1);").toString();

        db.execSQL(evento1);
        db.execSQL(evento2);
        db.execSQL(evento3);

        String tarea1 = new StringBuilder("INSERT INTO ").append(BD.TAREAS).append(" VALUES(NULL, 2, 'Realizar presupuesto de alimentos', '2021-12-27 00:00:00', 0);").toString();
        String tarea2 = new StringBuilder("INSERT INTO ").append(BD.TAREAS).append(" VALUES(NULL, 2, 'Comprobar la correcta colocacion de los item', '2021-12-27 10:00:00', 0);").toString();
        String tarea3 = new StringBuilder("INSERT INTO ").append(BD.TAREAS).append(" VALUES(NULL, 1, 'Buscar manteles relacionados la color solicitado', '2022-01-08 08:30:00', 0);").toString();


        db.execSQL(tarea1);
        db.execSQL(tarea2);
        db.execSQL(tarea3);

        String gasto1 = new StringBuilder("INSERT INTO ").append(BD.GASTOS).append(" VALUES(NULL, 2, 'Pago servicio de limpieza', 1200,00);").toString();
        String gasto2 = new StringBuilder("INSERT INTO ").append(BD.GASTOS).append(" VALUES(NULL, 1, 'Traslado de mercaderia', 500,00);").toString();
        String gasto3 = new StringBuilder("INSERT INTO ").append(BD.GASTOS).append(" VALUES(NULL, 3, 'Encerado', 4200,00);").toString();

        db.execSQL(gasto1);
        db.execSQL(gasto2);
        db.execSQL(gasto3);

        String reunion1 = new StringBuilder("INSERT INTO ").append(BD.REUNIONES).append(" VALUES(NULL, 1, 'Pactar la cantidad de integrantes', 'Obtener la cantidad de integrantes', '2021-12-08 14:00:00', 'Salon', '0');").toString();
        String reunion2 = new StringBuilder("INSERT INTO ").append(BD.REUNIONES).append(" VALUES(NULL, 2, 'Comida', 'Pactar la comida a brindar', '2021-12-28 15:00:00', 'Domicilio', '1');").toString();
        String reunion3 = new StringBuilder("INSERT INTO ").append(BD.REUNIONES).append(" VALUES(NULL, 3, 'Sistema de audio', 'Confirmar la discoteca', '2021-12-20 14:45:00', 'Salon', '1');").toString();


        db.execSQL(reunion1);
        db.execSQL(reunion2);
        db.execSQL(reunion3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(BD.Clientes.SQL_ELIMINAR_TABLA);
        db.execSQL(BD.Comerciales.SQL_ELIMINAR_TABLA);
        db.execSQL(BD.Particulares.SQL_ELIMINAR_TABLA);
        db.execSQL(BD.Eventos.SQL_ELIMINAR_TABLA);
        db.execSQL(BD.Tareas.SQL_ELIMINAR_TABLA);
        db.execSQL(BD.Gastos.SQL_ELIMINAR_TABLA);
        db.execSQL(BD.Reuniones.SQL_ELIMINAR_TABLA);

        onCreate(db);

    }
}
