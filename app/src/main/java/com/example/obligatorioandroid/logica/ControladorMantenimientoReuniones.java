package com.example.obligatorioandroid.logica;

import android.content.Context;

import com.example.obligatorioandroid.compartidos.datatypes.DTReunion;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersonalizada;
import com.example.obligatorioandroid.persistencia.FabricaPersistencia;

import java.util.List;

public class ControladorMantenimientoReuniones implements IControladorMantenimientoReuniones{

    private static ControladorMantenimientoReuniones instancia;

    public static ControladorMantenimientoReuniones getInstancia(Context contexto){
        if(instancia == null){
            instancia = new ControladorMantenimientoReuniones(contexto);
        }

        return  instancia;
    }

    private Context contexto;

    private ControladorMantenimientoReuniones(Context contexto){
        this.contexto = contexto.getApplicationContext();
    }

    @Override
    public List<DTReunion> listadoReunion()
            throws ExcepcionPersonalizada {
        return FabricaPersistencia.getPersistenciaReunion(contexto).listado();
    }

    @Override
    public void agregarReunion(DTReunion reunion)
            throws ExcepcionPersonalizada {
        LogicaReunion.getInstancia().validarReunion(reunion);

        FabricaPersistencia.getPersistenciaReunion(contexto).agregar(reunion);
    }

    @Override
    public void modificarReunion(DTReunion reunion)
            throws ExcepcionPersonalizada {
        LogicaReunion.getInstancia().validarReunion(reunion);

        FabricaPersistencia.getPersistenciaReunion(contexto).modificar(reunion);
    }

    @Override
    public void eliminarReunion(int idR)
            throws ExcepcionPersonalizada {
        FabricaPersistencia.getPersistenciaReunion(contexto).eliminar(idR);
    }
}
