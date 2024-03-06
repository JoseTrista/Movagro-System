/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

import java.util.List;

/**
 *
 * @author Equipo Movagro
 */
public class Producto {
    private List<Material> materiales;
    private String nombreProducto;
    private int costoProducto;

    public Producto() {
    }

    public Producto(List<Material> materiales, String nombreProducto, int costoProducto) {
        this.materiales = materiales;
        this.nombreProducto = nombreProducto;
        this.costoProducto = costoProducto;
    }

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCostoProducto() {
        return costoProducto;
    }

    public void setCostoProducto(int costoProducto) {
        this.costoProducto = costoProducto;
    }

    @Override
    public String toString() {
        return "Producto{" + "materiales=" + materiales + ", nombreProducto=" + nombreProducto + ", costoProducto=" + costoProducto + '}';
    }
    
    
}
