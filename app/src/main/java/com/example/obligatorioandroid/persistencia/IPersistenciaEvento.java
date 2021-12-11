package com.example.obligatorioandroid.persistencia;

import com.example.obligatorioandroid.compartidos.datatypes.DTEvento;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersonalizada;

import java.util.List;

public interface IPersistenciaEvento {


    List<DTEvento> listarEventos() throws ExcepcionPersonalizada;
    void agregarEvento(DTEvento Evento) throws ExcepcionPersonalizada;
    void modificarEvento(DTEvento Evento) throws ExcepcionPersonalizada;
    void eliminarEvento(long nro_evento) throws  ExcepcionPersonalizada;

}
