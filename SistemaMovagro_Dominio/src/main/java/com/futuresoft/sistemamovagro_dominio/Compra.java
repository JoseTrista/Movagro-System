/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_dominio;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Equipo Movagro 
 */
@Entity
@Table(name = "Compra")
public class Compra implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Temporal(TemporalType.DATE)
    @Column(name = "Fecha")
    private Date fecha;
    
    @Column(name = "Condicion")
    private String condicion;
    
    @Column(name = "Costo_total")
    private String costo;
        
    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DetalleCompra> detalleCompra;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "proveedor_id")
    private Proveedor proveedor;
    
    @ManyToOne
    @JoinColumn(name = "secretaria_id")
    private Secretaria secretaria;
    
    public Compra() {
    }

    public Compra(Integer id, Date fecha, String condicion, String costo, List<DetalleCompra> detalleCompra, Proveedor proveedor) {
        this.id = id;
        this.fecha = fecha;
        this.condicion = condicion;
        this.costo = costo;
        this.detalleCompra = detalleCompra;
        this.proveedor = proveedor;
    }

    public Compra(Date fecha, String condicion, String costo, List<DetalleCompra> detalleCompra, Proveedor proveedor) {
        this.fecha = fecha;
        this.condicion = condicion;
        this.costo = costo;
        this.detalleCompra = detalleCompra;
        this.proveedor = proveedor;
    }

    public Compra(Date fecha, String condicion, String costo, Proveedor proveedor, Secretaria secretaria) {
        this.fecha = fecha;
        this.condicion = condicion;
        this.costo = costo;
        this.proveedor = proveedor;
        this.secretaria = secretaria;
    }

    

    public Compra(Integer id, Date fecha, String condicion, String costo, List<DetalleCompra> detalleCompra, Proveedor proveedor, Secretaria secretaria) {
        this.id = id;
        this.fecha = fecha;
        this.condicion = condicion;
        this.costo = costo;
        this.detalleCompra = detalleCompra;
        this.proveedor = proveedor;
        this.secretaria = secretaria;
    }

    
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public List<DetalleCompra> getDetalleCompra() {
        return detalleCompra;
    }

    public void setDetalleCompra(List<DetalleCompra> detalleCompra) {
        this.detalleCompra = detalleCompra;
    }
    
    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
 
    public Secretaria getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(Secretaria secretaria) {
        this.secretaria = secretaria;
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
        if (!(object instanceof Compra)) {
            return false;
        }
        Compra other = (Compra) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.futuresoft.sistemamovagro_dominio.Compra[ id=" + id + " ]";
    }
    
}
