/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Equipo Movagro
 */
public class MovimientoMaterial extends Movimiento{
    private List<OrdenProduccion> ordenProduccion;
    private Almacenista almacenista;

    public MovimientoMaterial(List<OrdenProduccion> ordenProduccion, Almacenista almacenista, int cantidad, Date fecha, String tipoMovimiento) {
        super(cantidad, fecha, tipoMovimiento);
        this.ordenProduccion = ordenProduccion;
        this.almacenista = almacenista;
    }

    public MovimientoMaterial(List<OrdenProduccion> ordenProduccion, Almacenista almacenista) {
        this.ordenProduccion = ordenProduccion;
        this.almacenista = almacenista;
    }

    public MovimientoMaterial() {
    }

    public List<OrdenProduccion> getOrdenProduccion() {
        return ordenProduccion;
    }

    public void setOrdenProduccion(List<OrdenProduccion> ordenProduccion) {
        this.ordenProduccion = ordenProduccion;
    }

    public Almacenista getAlmacenista() {
        return almacenista;
    }

    public void setAlmacenista(Almacenista almacenista) {
        this.almacenista = almacenista;
    }

    @Override
    public String toString() {
        return "MovimientoMaterial{" + "ordenProduccion=" + ordenProduccion + ", almacenista=" + almacenista + '}';
    }
    
    
}
