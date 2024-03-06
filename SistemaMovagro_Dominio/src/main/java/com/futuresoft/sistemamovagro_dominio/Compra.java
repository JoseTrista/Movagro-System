/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Equipo Movagro
 */
public class Compra {
    private Proveedor proveedor;
    private  Date fecha;
    private String condicion;
    private float costoTotal;
    private List<DetalleCompra> detalleCompra;

    public Compra() {
    }

    public Compra(Proveedor proveedor, Date fecha, String condicion, float costoTotal, List<DetalleCompra> detalleCompra) {
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.condicion = condicion;
        this.costoTotal = costoTotal;
        this.detalleCompra = detalleCompra;
    }

    public Compra(Proveedor proveedor, Date fecha, String condicion, float costoTotal) {
        this.proveedor = proveedor;
        this.fecha = fecha;
        this.condicion = condicion;
        this.costoTotal = costoTotal;
        this.detalleCompra = new ArrayList<>();
    }

    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public float getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(float costoTotal) {
        this.costoTotal = costoTotal;
    }

    public List<DetalleCompra> getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(List<DetalleCompra> detalleCompra) {
        this.detalleCompra = detalleCompra;
    }

    @Override
    public String toString() {
        return "Compra{" + "proveedor=" + proveedor + ", fecha=" + fecha + ", condicion=" + condicion + ", costoTotal=" + costoTotal + ", detalleCompra=" + detalleCompra + '}';
    } 
}
