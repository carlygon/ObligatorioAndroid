package com.example.obligatorioandroid.persistencia;

import com.example.obligatorioandroid.compartidos.datatypes.DTReunion;
import com.example.obligatorioandroid.compartidos.datatypes.DTTarea;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersonalizada;

import java.util.List;

public interface IPersistenciaTarea {

    List<DTTarea> listado() throws ExcepcionPersonalizada;
    DTTarea obtener(int idT) throws ExcepcionPersonalizada;
    void agregar(DTTarea tarea) throws ExcepcionPersonalizada;
    void modificar(DTTarea tarea) throws ExcepcionPersonalizada;
    void eliminar(int idT) throws ExcepcionPersonalizada;
}
