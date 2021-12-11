package com.example.obligatorioandroid.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.obligatorioandroid.compartidos.datatypes.DTTarea;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersistencia;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersonalizada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class PersistenciaTarea implements IPersistenciaTarea{

    private static PersistenciaTarea instancia;

    public static PersistenciaTarea getInstancia(Context contexto){
        if(instancia == null){
            instancia = new PersistenciaTarea(contexto);
        }

        return instancia;
    }

    private Context contexto;

    private PersistenciaTarea(Context contexto){
        this.contexto = contexto.getApplicationContext();
    }

    @Override
    public List<DTTarea> listado()
            throws ExcepcionPersonalizada {
        BDHelper bdHelper = null;
        SQLiteDatabase bd = null;
        Cursor datos = null;

        try {
            bdHelper = new BDHelper(contexto);
            bd = bdHelper.getReadableDatabase();
            datos = bd.query(BD.TAREAS, BD.Tareas.COLUMNAS, null, null,
                    null, null, null);

            List<DTTarea> tareas = new ArrayList<DTTarea>();

            while(datos.moveToNext()){
                DTTarea tarea = instanciaTarea(datos);
                tareas.add(tarea);
            }
            return tareas;

        }catch (Exception ex){
            throw  new ExcepcionPersistencia("No se pudo listar las tareas.");
        }finally {
            if(datos != null) datos.close();
            if(bd != null) bd.close();
            if(bdHelper != null) bdHelper.close();
        }
    }

    @Override
    public DTTarea obtener(int idT)
            throws ExcepcionPersonalizada {
        BDHelper bdHelper = null;
        SQLiteDatabase bd = null;
        Cursor datos = null;

        try {
            bdHelper = new BDHelper(contexto);
            bd = bdHelper.getReadableDatabase();
            datos = bd.query(BD.TAREAS, BD.Tareas.COLUMNAS, BD.Tareas._ID + " = ?", new String[] {String.valueOf(idT)},
                    null, null, null);

            DTTarea tarea = null;

            if(datos.moveToNext()){
                tarea = instanciaTarea(datos);
            }
            return tarea;

        }catch (Exception ex){
            throw  new ExcepcionPersistencia("No se pudo obtener la tarea.");
        }finally {
            if(datos != null) datos.close();
            if(bd != null) bd.close();
            if(bdHelper != null) bdHelper.close();
        }
    }

    @Override
    public void agregar(DTTarea tarea)
            throws ExcepcionPersonalizada {
        BDHelper bdHelper = null;
        SQLiteDatabase bd = null;

        try {
            bdHelper = new BDHelper(contexto);
            bd = bdHelper.getWritableDatabase();

            if(obtener(tarea.getIdTarea()) != null){
                throw  new ExcepcionPersistencia("La tarea ya existe.");
            }

            ContentValues valores = new ContentValues();
            valores.put(BD.Tareas._ID, tarea.getIdTarea());
            valores.put(BD.Tareas._FECHA_LIMITE, tarea.getFechaLimite());
            valores.put(BD.Tareas._DESCRIPCION, tarea.getDescripcion());
            valores.put(BD.Tareas._REALIZADA, tarea.getRealizada());

            bd.insertOrThrow(BD.TAREAS, null, valores);

        }catch (ExcepcionPersistencia ex){
            throw ex;
        }catch (Exception ex){
            throw  new ExcepcionPersistencia("No se pudo agregar la tarea.");
        }finally {
            if(bd != null) bd.close();
            if(bdHelper != null) bdHelper.close();
        }
    }

    @Override
    public void modificar(DTTarea tarea)
            throws ExcepcionPersonalizada {
        BDHelper bdHelper = null;
        SQLiteDatabase bd = null;

        try {
            bdHelper = new BDHelper(contexto);
            bd = bdHelper.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put(BD.Tareas._ID, tarea.getIdTarea());
            valores.put(BD.Tareas._FECHA_LIMITE, tarea.getFechaLimite());
            valores.put(BD.Tareas._DESCRIPCION, tarea.getDescripcion());
            valores.put(BD.Tareas._REALIZADA, tarea.getRealizada());

            int filasAfectadas = bd.update(BD.TAREAS, valores, BD.TAREAS.ID + " = ?",
                    new String[] { String.valueOf(tarea.getIdTarea())});

            if(filasAfectadas < 1){
                throw new ExcepcionPersistencia("La tarea no existe.");
            }

        }catch (ExcepcionPersistencia ex){
            throw ex;
        }catch (Exception ex){
            throw  new ExcepcionPersistencia("No se pudo modificar la tarea.");
        }finally {
            if(bd != null) bd.close();
            if(bdHelper != null) bdHelper.close();
        }
    }

    @Override
    public void eliminar(int idT)
            throws ExcepcionPersonalizada {
        BDHelper bdHelper = null;
        SQLiteDatabase bd = null;

        try {
            bdHelper = new BDHelper(contexto);
            bd = bdHelper.getWritableDatabase();

            int filasAfectadas = bd.delete(BD.TAREAS, BD.TAREAS.ID + " = ?",
                    new String[] { String.valueOf(idT)});

            if(filasAfectadas < 1){
                throw new ExcepcionPersistencia("La tarea no existe.");
            }

        }catch (ExcepcionPersistencia ex){
            throw ex;
        }catch (Exception ex){
            throw  new ExcepcionPersistencia("No se pudo eliminar la tarea.");
        }finally {
            if(bd != null) bd.close();
            if(bdHelper != null) bdHelper.close();
        }
    }

    public DTTarea instanciaTarea(Cursor datos){
        int columnaIdT = datos.getColumnIndex(BD.Tareas._ID);
        int columnaFechaLimite = datos.getColumnIndex(BD.Tareas._FECHA_LIMITE);
        int columnaDescripcion = datos.getColumnIndex(BD.Tareas._DESCRIPCION);
        int columnaRealizada = datos.getColumnIndex(BD.Tareas._REALIZADA);

        DTTarea tarea = new DTTarea(datos.getInt(columnaIdT), datos.getDate(columnaFechaLimite),
                datos.getString(columnaDescripcion), datos.getInt(columnaRealizada));

        return tarea;
    }
}
