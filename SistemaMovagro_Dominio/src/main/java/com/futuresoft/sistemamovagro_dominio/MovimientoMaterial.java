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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Equipo Movagro
 */
@Entity
@Table(name = "Movimiento Material")
public class MovimientoMaterial implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Long getId() {
        return id;
    }
    
    @OneToMany(mappedBy = "movimientoMaterial", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrdenProduccion> ordenesProduccion;
    
    public MovimientoMaterial() {
    }

    
    
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    public List<OrdenProduccion> getOrdenProduccion() {
        return ordenesProduccion;
    }

    public void setOrdenProduccion(List<OrdenProduccion> ordenProduccion) {
        this.ordenesProduccion = ordenProduccion;
    }
    
    

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MovimientoMaterial)) {
            return false;
        }
        MovimientoMaterial other = (MovimientoMaterial) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futuresoft.sistemamovagro_dominio.MovimientoMaterial[ id=" + id + " ]";
    }
    
}
