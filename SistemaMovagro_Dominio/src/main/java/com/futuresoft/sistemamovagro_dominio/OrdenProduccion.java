/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

/**
 *
 * @author Equipo Movagros
 */
public class OrdenProduccion {
    private Material material;
    private float precioTotalMaterial;
    private float precioTotalOrden;
    private short cantidad;

    public OrdenProduccion(Material material, float precioTotalMaterial, float precioTotalOrden, short cantidad) {
        this.material = material;
        this.precioTotalMaterial = precioTotalMaterial;
        this.precioTotalOrden = precioTotalOrden;
        this.cantidad = cantidad;
    }

    public OrdenProduccion() {
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public float getPrecioTotalMaterial() {
        return precioTotalMaterial;
    }

    public void setPrecioTotalMaterial(float precioTotalMaterial) {
        this.precioTotalMaterial = precioTotalMaterial;
    }

    public float getPrecioTotalOrden() {
        return precioTotalOrden;
    }

    public void setPrecioTotalOrden(float precioTotalOrden) {
        this.precioTotalOrden = precioTotalOrden;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "OrdenProduccion{" + "material=" + material + ", precioTotalMaterial=" + precioTotalMaterial + ", precioTotalOrden=" + precioTotalOrden + ", cantidad=" + cantidad + '}';
    }
    
    
}
