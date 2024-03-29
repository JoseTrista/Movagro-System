/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author oscar
 */
@Entity
public class DetalleCompra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "Costo_Unitario")
    private float costoUnitario;
    
    @Column(name = "Cantidad")
    private short cantidad;
    
    @Column(name = "Unidad_Medida")
    private String unidadMedida;
    
    @ManyToOne
    @JoinColumn(name = "compra_id", nullable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "material_id", nullable = false)
    private Material material;

    public DetalleCompra() {
    }

    public DetalleCompra(float costoUnitario, short cantidad, String unidadMedida, Material material) {
        this.costoUnitario = costoUnitario;
        this.cantidad = cantidad;
        this.unidadMedida = unidadMedida;
        this.material = material;
    }
    
    public DetalleCompra(Integer id, float costoUnitario, short cantidad) {
        this.id = id;
        this.costoUnitario = costoUnitario;
        this.cantidad = cantidad;
    }

    public DetalleCompra(float costoUnitario, short cantidad) {
        this.costoUnitario = costoUnitario;
        this.cantidad = cantidad;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(float costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public short getCantidad() {
        return cantidad;
    }

    public void setCantidad(short cantidad) {
        this.cantidad = cantidad;
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
        if (!(object instanceof DetalleCompra)) {
            return false;
        }
        DetalleCompra other = (DetalleCompra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futuresoft.sistemamovagro_dominio.DetalleCompra[ id=" + id + " ]";
    }
    
}
