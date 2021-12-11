package com.example.obligatorioandroid.persistencia;

import com.example.obligatorioandroid.compartidos.datatypes.DTReunion;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersonalizada;

import java.util.List;

public interface IPersistenciaReunion {

    List<DTReunion> listado() throws ExcepcionPersonalizada;
    DTReunion obtener(int idR) throws ExcepcionPersonalizada;
    void agregar(DTReunion reunion) throws ExcepcionPersonalizada;
    void modificar(DTReunion reunion) throws ExcepcionPersonalizada;
    void eliminar(int idR) throws ExcepcionPersonalizada;
}
