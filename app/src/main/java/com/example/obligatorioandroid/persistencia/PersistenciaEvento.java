package com.example.obligatorioandroid.persistencia;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.obligatorioandroid.compartidos.datatypes.DTEvento;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersonalizada;

import java.util.ArrayList;
import java.util.List;

class PersistenciaEvento implements IPersistenciaEvento{

    //SINGLETON
    private Context contexto;

    private PersistenciaEvento(Context contexto){this.contexto = contexto;}

    private static PersistenciaEvento instancia;

    public static PersistenciaEvento getInstancia(Context contexto){
        if(instancia == null){
            instancia = new PersistenciaEvento(contexto);
        }

        return instancia;
    }


    @Override
    public List<DTEvento> listarEventos() throws ExcepcionPersonalizada {

        //OBJETOS

        BDHelper bdHelper = null;
        SQLiteDatabase baseDatos = null;
        Cursor cursor = null;

        try {
            bdHelper = new BDHelper(contexto);
            baseDatos = bdHelper.getReadableDatabase();
            cursor = baseDatos.query(BD.EVENTOS, BD.Eventos.COLUMNAS, null, null, null, null, BD.Eventos.NRO_EVENTO);

            List<DTEvento> listaEventos = new ArrayList<DTEvento>();

            while(cursor.moveToNext()){

                DTEvento evento = instanciarEvento(cursor);
                listaEventos.add(evento);
            }

            return listaEventos;

        }catch (Exception ex){
            throw new ExcepcionPersonalizada("No se pudo listar los eventos. Compruebe");
        }finally {

            if(cursor != null) cursor.close();
            if(baseDatos != null) baseDatos.close();
            if(bdHelper != null) bdHelper.close();

        }



    }

    @Override
    public void agregarEvento(DTEvento Evento) throws ExcepcionPersonalizada {

        BDHelper bdHelper = null;
        SQLiteDatabase baseDatos = null;

        try {

            bdHelper = new BDHelper(contexto);
            baseDatos = bdHelper.getReadableDatabase();
            ContentValues valoresEvento = new ContentValues();

            valoresEvento.put(BD.Eventos.CANTIDAD, Evento.getCantidad());
            valoresEvento.put(BD.Eventos.DURACION, Evento.getDuracion());
            valoresEvento.put(BD.Eventos.FECHA_Y_HORA, Evento.getFecha_y_hora());
            valoresEvento.put(BD.Eventos.ID_CLIENTE, Evento.getId_cliente());
            valoresEvento.put(BD.Eventos.TITULO, Evento.getTitulo());

            //INSERTAMOS
            baseDatos.insertOrThrow(BD.EVENTOS, null, valoresEvento);



        }catch (Exception ex){

            throw new ExcepcionPersonalizada("No se pudo agregar el evento");

        }finally {

            if(baseDatos != null) baseDatos.close();
            if(bdHelper != null) bdHelper.close();

        }

    }

    @Override
    public void modificarEvento(DTEvento Evento) throws ExcepcionPersonalizada {

        BDHelper bdHelper = null;
        SQLiteDatabase baseDatos = null;

        try {

            bdHelper = new BDHelper(contexto);
            baseDatos = bdHelper.getReadableDatabase();
            ContentValues valoresEvento = new ContentValues();

            valoresEvento.put(BD.Eventos.CANTIDAD, Evento.getCantidad());
            valoresEvento.put(BD.Eventos.DURACION, Evento.getDuracion());
            valoresEvento.put(BD.Eventos.FECHA_Y_HORA, Evento.getFecha_y_hora());
            valoresEvento.put(BD.Eventos.ID_CLIENTE, Evento.getId_cliente());
            valoresEvento.put(BD.Eventos.TITULO, Evento.getTitulo());

            //MODIFICAMOS

            int filasAfectadas = baseDatos.update(BD.EVENTOS, valoresEvento, BD.Eventos.NRO_EVENTO + " = ?", new String[]{String.valueOf(Evento.getNro_evento())});

            if(filasAfectadas < 1){
                throw new ExcepcionPersonalizada("Ocurrio un error al intentar modificar el Evento.");
            }



        }catch (ExcepcionPersonalizada ex){
            throw ex;
        }
        catch (Exception ex){

            throw new ExcepcionPersonalizada("No se pudo modificar el evento. Verifique.");

        }finally {

            if(baseDatos != null) baseDatos.close();
            if(bdHelper != null) bdHelper.close();

        }

    }

    @Override
    public void eliminarEvento(long nro_evento) throws ExcepcionPersonalizada {

        BDHelper bdHelper = null;
        SQLiteDatabase baseDatos = null;

        try {

            bdHelper = new BDHelper(contexto);
            baseDatos = bdHelper.getReadableDatabase();


            //ELIMINAMOS
            int filasAfectadas = baseDatos.delete(BD.EVENTOS, BD.Eventos.NRO_EVENTO + " = ?", new String[]{String.valueOf(nro_evento)});

            if(filasAfectadas < 1){
                throw new ExcepcionPersonalizada("Ocurrio un problema al querer eliminar el evento " + nro_evento);
            }


        }catch (ExcepcionPersonalizada ex){
            throw ex;
        }
        catch (Exception ex){

            throw new ExcepcionPersonalizada("No se pudo eliminar el evento");

        }finally {

            if(baseDatos != null) baseDatos.close();
            if(bdHelper != null) bdHelper.close();

        }

    }



    public DTEvento instanciarEvento(Cursor cursor){

        int columnaNro = cursor.getColumnIndex(BD.Eventos.NRO_EVENTO);
        int columnaFecha = cursor.getColumnIndex(BD.Eventos.FECHA_Y_HORA);
        int columnaDuracion = cursor.getColumnIndex(BD.Eventos.DURACION);
        int columnaTitulo = cursor.getColumnIndex(BD.Eventos.TITULO);
        int columnaCantidad = cursor.getColumnIndex(BD.Eventos.CANTIDAD);
        int columnaNroCliente = cursor.getColumnIndex(BD.Eventos.ID_CLIENTE);

        DTEvento evento = new DTEvento(cursor.getLong(columnaNro), cursor.getString(columnaFecha), cursor.getInt(columnaDuracion), cursor.getString(columnaTitulo), cursor.getInt(columnaCantidad), cursor.getLong(columnaNroCliente));

        return evento;
    }
}
