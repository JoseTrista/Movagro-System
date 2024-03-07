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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Equipo Movagro
 */
@Entity
@Table(name = "Producto")
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
     
    @Column(name = "Nombre_Producto")
    private String nombreP;
      
    @Column(name = "Costo_Producto")
    private String costoP;

    @ManyToMany
    @JoinTable(
        name = "producto_material", 
        joinColumns = @JoinColumn(name = "producto_id"), 
        inverseJoinColumns = @JoinColumn(name = "material_id")
    )
    private List<Material> materiales;
    
    @OneToMany(mappedBy = "producto")
    private List<DetalleProducto> detalleProductos;
    
    public Producto() {
    }

    public Producto(Long id, List<Material> nateriales, String nombreP, String costoP) {
        this.id = id;
        this.materiales = nateriales;
        this.nombreP = nombreP;
        this.costoP = costoP;
    }

    public Producto(List<Material> nateriales, String nombreP, String costoP) {
        this.materiales = nateriales;
        this.nombreP = nombreP;
        this.costoP = costoP;
    }
      
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Material> getNateriales() {
        return materiales;
    }

    public void setNateriales(List<Material> nateriales) {
        this.materiales = nateriales;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getCostoP() {
        return costoP;
    }

    public void setCostoP(String costoP) {
        this.costoP = costoP;
    }
    
    public List<Material> getMateriales() {
        return materiales;
    }

    public void setMateriales(List<Material> materiales) {
        this.materiales = materiales;
    }

    public List<DetalleProducto> getDetalleProductos() {
        return detalleProductos;
    }

    public void setDetalleProductos(List<DetalleProducto> detalleProductos) {
        this.detalleProductos = detalleProductos;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futuresoft.sistemamovagro_dominio.Producto[ id=" + id + " ]";
    }
    
}
