/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author oscar
 */
@Entity
@Table(name="Almacenista")
public class Almacenista implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Numero")
    private String numero;
    
    @Column(name = "Usuario")
    private String usuario;
    
    @Column(name = "Contraseña")
    private String contraseña;
    
    @Column(name = "Correo")
    private String correo;

    public Almacenista(Integer id, String nombre, String numero, String usuario, String contraseña, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.numero = numero;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
    }

    public Almacenista(String nombre, String numero, String usuario, String contraseña, String correo) {
        this.nombre = nombre;
        this.numero = numero;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.correo = correo;
    }

    public Almacenista() {
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
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Almacenista)) {
            return false;
        }
        Almacenista other = (Almacenista) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futuresoft.sistemamovagro_dominio.Almacenista[ id=" + id + " ]";
    }
    
}
