/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Equipo Movagro
 */
@Entity
@Table(name="Orden Produccion")
public class OrdenProduccion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(name = "Precio_Total_Material")
    private float precioTM;
    
     @Column(name = "Precio_Total_Orden")
    private float precioTO;
     
     @Column(name = "cantidad")
    private short cantidad;

     
    @ManyToOne
    @JoinColumn(name = "material_id")
    private Material material;
    
    @ManyToOne
    @JoinColumn(name = "movimientoMaterial_id")
    private MovimientoMaterial movimientoMaterial;
    
    public OrdenProduccion() {
    }

    public OrdenProduccion(Long id, float precioTM, float precioTO, short cantidad) {
        this.id = id;
        this.precioTM = precioTM;
        this.precioTO = precioTO;
        this.cantidad = cantidad;
    }

    public OrdenProduccion(float precioTM, float precioTO, short cantidad) {
        this.precioTM = precioTM;
        this.precioTO = precioTO;
        this.cantidad = cantidad;
    }
     
     

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getPrecioTM() {
        return precioTM;
    }

    public void setPrecioTM(float precioTM) {
        this.precioTM = precioTM;
    }

    public float getPrecioTO() {
        return precioTO;
    }

    public void setPrecioTO(float precioTO) {
        this.precioTO = precioTO;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public MovimientoMaterial getMovimientoMaterial() {
        return movimientoMaterial;
    }

    public void setMovimientoMaterial(MovimientoMaterial movimientoMaterial) {
        this.movimientoMaterial = movimientoMaterial;
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
        if (!(object instanceof OrdenProduccion)) {
            return false;
        }
        OrdenProduccion other = (OrdenProduccion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futuresoft.sistemamovagro_dominio.OrdenProduccion[ id=" + id + " ]";
    }
    
}
