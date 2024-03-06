/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

/**
 *
 * @author Equipo Movagro
 */
public class Proveedor {
    private String rfc;
    private int telefono;
    private String direccion;
    private String nombre;

    public Proveedor(String rfc, int telefono, String direccion, String nombre) {
        this.rfc = rfc;
        this.telefono = telefono;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public Proveedor() {
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "rfc=" + rfc + ", telefono=" + telefono + ", direccion=" + direccion + ", nombre=" + nombre + '}';
    }
}
