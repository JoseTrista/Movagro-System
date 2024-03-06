/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Equipo Movagro 
 */
@Entity
@Table(name = "Material")
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Descripcion")
    private float descripcion;
    
    @Column(name = "Unidad_Medida")
    private float unidadMedida;
    
    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCompra> detallesCompra;
    
    @ManyToOne
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
    
    @ManyToMany(mappedBy = "materiales")
    private List<Producto> productos;
    
    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenProduccion> ordenesProduccion;

    public Material() {
    }

    public Material(Long id, String nombre, float descripcion, float unidadMedida, List<DetalleCompra> detallesCompra, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.detallesCompra = detallesCompra;
        this.proveedor = proveedor;
    }

    public Material(String nombre, float descripcion, float unidadMedida, List<DetalleCompra> detallesCompra, Proveedor proveedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.detallesCompra = detallesCompra;
        this.proveedor = proveedor;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(float descripcion) {
        this.descripcion = descripcion;
    }

    public float getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(float unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public List<DetalleCompra> getDetallesCompra() {
        return detallesCompra;
    }

    public void setDetallesCompra(List<DetalleCompra> detallesCompra) {
        this.detallesCompra = detallesCompra;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
 
    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<OrdenProduccion> getOrdenesProduccion() {
        return ordenesProduccion;
    }

    public void setOrdenesProduccion(List<OrdenProduccion> ordenesProduccion) {
        this.ordenesProduccion = ordenesProduccion;
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
        if (!(object instanceof Material)) {
            return false;
        }
        Material other = (Material) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futuresoft.sistemamovagro_dominio.Material[ id=" + id + " ]";
    }
   
}
