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

/**
 *
 * @author oscar
 */
@Entity
public class Producto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
     @Column(name = "Materiales")
    private List<Material> nateriales;
     
      @Column(name = "Nombre_Producto")
    private String nombreP;
      
      @Column(name = "Costo_Producto")
    private String costoP;

    public Producto() {
    }

    public Producto(Long id, List<Material> nateriales, String nombreP, String costoP) {
        this.id = id;
        this.nateriales = nateriales;
        this.nombreP = nombreP;
        this.costoP = costoP;
    }

    public Producto(List<Material> nateriales, String nombreP, String costoP) {
        this.nateriales = nateriales;
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
        return nateriales;
    }

    public void setNateriales(List<Material> nateriales) {
        this.nateriales = nateriales;
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
