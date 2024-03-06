/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

import java.util.Date;

/**
 *
 * @author Equipo Movagro
 */
public class Movimiento {
    private int cantidad;
    private Date fecha;
    private String tipoMovimiento;

    public Movimiento(int cantidad, Date fecha, String tipoMovimiento) {
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.tipoMovimiento = tipoMovimiento;
    }

    public Movimiento() {
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    @Override
    public String toString() {
        return "Movimiento{" + "cantidad=" + cantidad + ", fecha=" + fecha + ", tipoMovimiento=" + tipoMovimiento + '}';
    }
    
    
}
