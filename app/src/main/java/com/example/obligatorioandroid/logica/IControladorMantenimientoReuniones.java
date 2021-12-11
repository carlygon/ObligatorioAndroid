package com.example.obligatorioandroid.logica;

import com.example.obligatorioandroid.compartidos.datatypes.DTReunion;
import com.example.obligatorioandroid.compartidos.excepciones.ExcepcionPersonalizada;

import java.util.List;

public interface IControladorMantenimientoReuniones {

    List<DTReunion> listadoReunion() throws ExcepcionPersonalizada;
    void agregarReunion(DTReunion reunion) throws ExcepcionPersonalizada;
    void modificarReunion(DTReunion reunion) throws ExcepcionPersonalizada;
    void eliminarReunion(int idR) throws ExcepcionPersonalizada;
}
