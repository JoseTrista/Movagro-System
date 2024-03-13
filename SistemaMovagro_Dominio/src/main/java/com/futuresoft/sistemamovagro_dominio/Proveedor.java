/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Equipo Movagro 
 */
@Entity
@Table(name = "Proveedor")
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
    
    @OneToMany(mappedBy = "proveedor")
    private List<Material> materiales;

    @OneToMany(mappedBy = "proveedor", cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<Compra> compras;

    public Proveedor() {
    }

    public Proveedor(Long id, String rfc, String tekefono, String direccion, String nombre, List<Material> materiales, List<Compra> compras) {
        this.id = id;
        this.rfc = rfc;
        this.tekefono = tekefono;
        this.direccion = direccion;
        this.nombre = nombre;
        this.materiales = materiales;
        this.compras = compras;
    }

    
    public Proveedor(String rfc, String tekefono, String direccion, String nombre) {
        this.rfc = rfc;
        this.tekefono = tekefono;
        this.direccion = direccion;
        this.nombre = nombre;
    }

    public Proveedor(String rfc, String tekefono, String direccion, String nombre, List<Material> materiales, List<Compra> compras) {
        this.rfc = rfc;
        this.tekefono = tekefono;
        this.direccion = direccion;
        this.nombre = nombre;
        this.materiales = materiales;
        this.compras = compras;
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

    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.rfc);
        hash = 79 * hash + Objects.hashCode(this.tekefono);
        hash = 79 * hash + Objects.hashCode(this.direccion);
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.materiales);
        hash = 79 * hash + Objects.hashCode(this.compras);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Proveedor other = (Proveedor) obj;
        if (!Objects.equals(this.rfc, other.rfc)) {
            return false;
        }
        if (!Objects.equals(this.tekefono, other.tekefono)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.materiales, other.materiales)) {
            return false;
        }
        return Objects.equals(this.compras, other.compras);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
