package com.example.obligatorioandroid.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.obligatorioandroid.compartidos.datatypes.DTReunion;
import com.example.obligatorioandroid.compartidos.datatypes.DTTarea;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersistencia;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersonalizada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class PersistenciaReunion implements IPersistenciaReunion{

    private static PersistenciaReunion instancia;

    public static PersistenciaReunion getInstancia(Context contexto){
        if(instancia == null){
            instancia = new PersistenciaReunion(contexto);
        }

        return instancia;
    }
//COMENTARIO NEW MODIFY
    //NEW ******************
    private Context contexto;

    private PersistenciaReunion(Context contexto){
        this.contexto = contexto.getApplicationContext();
    }

    @Override
    public List<DTReunion> listado() throws ExcepcionPersonalizada {
        BDHelper bdHelper = null;
        SQLiteDatabase bd = null;
        Cursor datos = null;

        try {
            bdHelper = new BDHelper(contexto);
            bd = bdHelper.getReadableDatabase();
            datos = bd.query(BD.REUNIONES, BD.Reuniones.COLUMNAS, null, null,
                    null, null, null);

            List<DTReunion> reuniones = new ArrayList<DTReunion>();

            while(datos.moveToNext()){
               DTReunion reunion = instanciaReunion(datos);
                reuniones.add(reunion);
            }
            return reuniones;

        }catch (Exception ex){
            throw  new ExcepcionPersistencia("No se pudo listar las reuniones.");
        }finally {
            if(datos != null) datos.close();
            if(bd != null) bd.close();
            if(bdHelper != null) bdHelper.close();
        }
    }

    @Override
    public DTReunion obtener(int idR)
            throws ExcepcionPersonalizada {
        BDHelper bdHelper = null;
        SQLiteDatabase bd = null;
        Cursor datos = null;

        try {
            bdHelper = new BDHelper(contexto);
            bd = bdHelper.getReadableDatabase();
            datos = bd.query(BD.REUNIONES, BD.Reuniones.COLUMNAS, BD.Reuniones._ID + " = ?", new String[] {String.valueOf(idR)},
                    null, null, null);

            DTReunion reunion = null;

            if(datos.moveToNext()){
                reunion = instanciaReunion(datos);
            }
            return reunion;

        }catch (Exception ex){
            throw  new ExcepcionPersistencia("No se pudo obtener la reunión.");
        }finally {
            if(datos != null) datos.close();
            if(bd != null) bd.close();
            if(bdHelper != null) bdHelper.close();
        }
    }

    @Override
    public void agregar(DTReunion reunion)
            throws ExcepcionPersonalizada {
        BDHelper bdHelper = null;
        SQLiteDatabase bd = null;

        try {
            bdHelper = new BDHelper(contexto);
            bd = bdHelper.getWritableDatabase();

            if(obtener(reunion.getIdReunion()) != null){
                throw  new ExcepcionPersistencia("La reunión ya existe.");
            }

            ContentValues valores = new ContentValues();
            valores.put(BD.Reuniones._ID, reunion.getIdReunion());
            valores.put(BD.Reuniones._LUGAR, reunion.getLugar());
            valores.put(BD.Reuniones._NOTIFICADO, reunion.getNotificado());
            valores.put(BD.Reuniones._DESCRIPCION, reunion.getDescripcion());
            valores.put(BD.Reuniones._OBJETIVO, reunion.getObjetivo());
            valores.put(BD.Reuniones._FECHA_Y_HORA, reunion.getFechaYHoraReunion());

            bd.insertOrThrow(BD.REUNIONES, null, valores);

        }catch (ExcepcionPersistencia ex){
            throw ex;
        }catch (Exception ex){
            throw  new ExcepcionPersistencia("No se pudo agregar la reunión.");
        }finally {
            if(bd != null) bd.close();
            if(bdHelper != null) bdHelper.close();
        }
    }

    @Override
    public void modificar(DTReunion reunion) throws ExcepcionPersonalizada {
        BDHelper bdHelper = null;
        SQLiteDatabase bd = null;

        try {
            bdHelper = new BDHelper(contexto);
            bd = bdHelper.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put(BD.Reuniones._ID, reunion.getIdReunion());
            valores.put(BD.Reuniones._LUGAR, reunion.getLugar());
            valores.put(BD.Reuniones._NOTIFICADO, reunion.getNotificado());
            valores.put(BD.Reuniones._DESCRIPCION, reunion.getDescripcion());
            valores.put(BD.Reuniones._OBJETIVO, reunion.getObjetivo());
            valores.put(BD.Reuniones._FECHA_Y_HORA, reunion.getFechaYHoraReunion());

            int filasAfectadas = bd.update(BD.REUNIONES, valores, BD.REUNIONES.ID + " = ?",
                    new String[] { String.valueOf(reunion.getIdReunion())});

            if(filasAfectadas < 1){
                throw new ExcepcionPersistencia("La reunión no existe.");
            }

        }catch (ExcepcionPersistencia ex){
            throw ex;
        }catch (Exception ex){
            throw  new ExcepcionPersistencia("No se pudo modificar la reunión.");
        }finally {
            if(bd != null) bd.close();
            if(bdHelper != null) bdHelper.close();
        }
    }

    @Override
    public void eliminar(int idR) throws ExcepcionPersonalizada {
        BDHelper bdHelper = null;
        SQLiteDatabase bd = null;

        try {
            bdHelper = new BDHelper(contexto);
            bd = bdHelper.getWritableDatabase();

            int filasAfectadas = bd.update(BD.REUNIONES, BD.REUNIONES.ID + " = ?",
                    new String[] { String.valueOf(idR)});

            if(filasAfectadas < 1){
                throw new ExcepcionPersistencia("La reunión no existe.");
            }

        }catch (ExcepcionPersistencia ex){
            throw ex;
        }catch (Exception ex){
            throw  new ExcepcionPersistencia("No se pudo eliminar la reunión.");
        }finally {
            if(bd != null) bd.close();
            if(bdHelper != null) bdHelper.close();
        }
    }

    public DTReunion instanciaReunion(Cursor datos){
        int columnaIdR = datos.getColumnIndex(BD.Reuniones._ID);
        int columnaLugar = datos.getColumnIndex(BD.Reuniones._LUGAR);
        int columnaNotificado = datos.getColumnIndex(BD.Reuniones._NOTIFICADO);
        int columnaDescripcion = datos.getColumnIndex(BD.Reuniones._DESCRIPCION);
        int columnaObjetivo = datos.getColumnIndex(BD.Reuniones._OBJETIVO);
        int columnaFechaYHora = datos.getColumnIndex(BD.Reuniones._FECHA_Y_HORA);

        DTReunion reunion = new DTReunion(datos.getInt(columnaIdR), datos.getString(columnaLugar),
                datos.getInt(columnaNotificado), datos.getString(columnaDescripcion), datos.getString(columnaObjetivo),
                datos.getData(columnaFechaYHora));

        return reunion;
    }
}
