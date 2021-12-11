package com.example.obligatorioandroid.logica;

import android.content.Context;

import com.example.obligatorioandroid.compartidos.datatypes.DTTarea;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersonalizada;
import com.example.obligatorioandroid.persistencia.FabricaPersistencia;

import java.util.List;

public class ControladorMantenimientoTareas implements IControladorMantenimientoTareas{

    private static ControladorMantenimientoTareas instancia;

    public static ControladorMantenimientoTareas getInstancia(Context contexto){
        if(instancia == null){
            instancia = new ControladorMantenimientoTareas(contexto);
        }

        return  instancia;
    }

    private Context contexto;

    private ControladorMantenimientoTareas(Context contexto){
        this.contexto = contexto.getApplicationContext();
    }

    @Override
    public List<DTTarea> listadoTarea()
            throws ExcepcionPersonalizada {
        return FabricaPersistencia.getPersistenciaTarea(contexto).listado();
    }

    @Override
    public void agregarTarea(DTTarea tarea)
            throws ExcepcionPersonalizada {
        LogicaTarea.getInstancia().validarTarea(tarea);

        FabricaPersistencia.getPersistenciaTarea(contexto).agregar(tarea);
    }

    @Override
    public void modificarTarea(DTTarea tarea)
            throws ExcepcionPersonalizada {
        LogicaTarea.getInstancia().validarTarea(tarea);

        FabricaPersistencia.getPersistenciaTarea(contexto).modificar(tarea);
    }

    @Override
    public void eliminarTarea(int idT)
            throws ExcepcionPersonalizada {
        FabricaPersistencia.getPersistenciaTarea(contexto).eliminar(idT);
    }
}
