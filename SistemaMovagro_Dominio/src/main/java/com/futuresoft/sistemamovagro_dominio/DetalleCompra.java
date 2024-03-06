/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

/**
 *
 * @author Equipo Movagro
 */
public class DetalleCompra {
    private Material materiales;
    private float costoUnitario;
    private short cantidad;

    public DetalleCompra(Material materiales, float costoUnitario, short cantidad) {
        this.materiales = materiales;
        this.costoUnitario = costoUnitario;
        this.cantidad = cantidad;
    }

    public DetalleCompra() {
    }

    public Material getMateriales() {
        return materiales;
    }

    public void setMateriales(Material materiales) {
        this.materiales = materiales;
    }

    public float getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(float costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "DetalleCompra{" + "materiales=" + materiales + ", costoUnitario=" + costoUnitario + ", cantidad=" + cantidad + '}';
    }
}
