package com.example.obligatorioandroid.logica;

import com.example.obligatorioandroid.compartidos.datatypes.DTTarea;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersonalizada;

import java.util.List;

public interface IControladorMantenimientoTareas {

    List<DTTarea> listadoTarea() throws ExcepcionPersonalizada;
    void agregarTarea(DTTarea tarea) throws ExcepcionPersonalizada;
    void modificarTarea(DTTarea tarea) throws ExcepcionPersonalizada;
    void eliminarTarea(int idT) throws ExcepcionPersonalizada;
}
