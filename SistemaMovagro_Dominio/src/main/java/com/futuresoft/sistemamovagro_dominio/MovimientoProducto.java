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
public class MovimientoProducto extends Movimiento{
    private List<DetalleProducto> detalleproducto;
    private Almacenista almacenista;

    public MovimientoProducto(List<DetalleProducto> detalleproducto, Almacenista almacenista, int cantidad, Date fecha, String tipoMovimiento) {
        super(cantidad, fecha, tipoMovimiento);
        this.detalleproducto = detalleproducto;
        this.almacenista = almacenista;
    }

    public MovimientoProducto(List<DetalleProducto> detalleproducto, Almacenista almacenista) {
        this.detalleproducto = detalleproducto;
        this.almacenista = almacenista;
    }

    public MovimientoProducto() {
    }

    public List<DetalleProducto> getDetalleproducto() {
        return detalleproducto;
    }

    public void setDetalleproducto(List<DetalleProducto> detalleproducto) {
        this.detalleproducto = detalleproducto;
    }

    public Almacenista getAlmacenista() {
        return almacenista;
    }

    public void setAlmacenista(Almacenista almacenista) {
        this.almacenista = almacenista;
    }

    @Override
    public String toString() {
        return "MovimientoProducto{" + "detalleproducto=" + detalleproducto + ", almacenista=" + almacenista + '}';
    }
    
    
    
}
