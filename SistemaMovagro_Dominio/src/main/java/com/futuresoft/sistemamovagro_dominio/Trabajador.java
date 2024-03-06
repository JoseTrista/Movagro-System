/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

/**
 *
 * @author Equipo Movagro
 */
public class Trabajador {
    private String nombre;
    private String numero;
    private String usuario;
    private String contraseña;
    private String correo;

    public Trabajador(String nombre, String numero, String usuario, String contraseña, String correo) {
        this.nombre = nombre;
        this.numero = numero;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
    }

    public Trabajador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Trabajador{" + "nombre=" + nombre + ", numero=" + numero + ", usuario=" + usuario + ", contrase\u00f1a=" + contraseña + ", correo=" + correo + '}';
    }
    
    
}
