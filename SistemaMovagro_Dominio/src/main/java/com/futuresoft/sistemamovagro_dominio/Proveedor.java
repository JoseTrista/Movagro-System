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

/**
 *
 * @author oscar
 */
@Entity
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "RFC")
    private String rfc;
    
    @Column(name = "Telefono")
    private String tekefono;
    
    @Column(name = "Direccion")
    private String direccion;
    
    @Column(name = "Nombre")
    private String nombre;

    public Proveedor() {
    }

    public Proveedor(Long id, String rfc, String tekefono, String direccion, String nombre) {
        this.id = id;
        this.rfc = rfc;
        this.tekefono = tekefono;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public Proveedor(String rfc, String tekefono, String direccion, String nombre) {
        this.rfc = rfc;
        this.tekefono = tekefono;
        this.direccion = direccion;
        this.nombre = nombre;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getTekefono() {
        return tekefono;
    }

    public void setTekefono(String tekefono) {
        this.tekefono = tekefono;
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
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futuresoft.sistemamovagro_dominio.Proveedo[ id=" + id + " ]";
    }
    
}
