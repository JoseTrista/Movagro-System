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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "Nombre")
    private String nombre;
    
    @Column(name = "Descripcion")
    private String descripcion;
    
    @Column(name = "Unidad_Medida")
    private String unidadMedida;
    
    @Column(name = "Cantidad")
    private int cantidad;
    
    @OneToMany(mappedBy = "material")
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

    public Material(Integer id, String nombre, String descripcion, String unidadMedida, Proveedor proveedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.proveedor = proveedor;
    }

    public Material(Integer id, String nombre, String descripcion, String unidadMedida, int cantidad, List<DetalleCompra> detallesCompra, Proveedor proveedor, List<Producto> productos, List<OrdenProduccion> ordenesProduccion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.cantidad = cantidad;
        this.detallesCompra = detallesCompra;
        this.proveedor = proveedor;
        this.productos = productos;
        this.ordenesProduccion = ordenesProduccion;
    }

    

    public Material(String nombre, String descripcion, String unidadMedida, List<DetalleCompra> detallesCompra, Proveedor proveedor) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.detallesCompra = detallesCompra;
        this.proveedor = proveedor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    
    
    

    @Override
    public String toString() {
        return nombre;
    }
    
}
