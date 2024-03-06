/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

/**
 *
 * @author Equipo Movagro
 */
public class DetalleProducto {
    private Producto producto;
    private int Cantidad;

    public DetalleProducto() {
    }

    public DetalleProducto(Producto producto, int Cantidad) {
        this.producto = producto;
        this.Cantidad = Cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    @Override
    public String toString() {
        return "DetalleProducto{" + "producto=" + producto + ", Cantidad=" + Cantidad + '}';
    }
    
    
}
