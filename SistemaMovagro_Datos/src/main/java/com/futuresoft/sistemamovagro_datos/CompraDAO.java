/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_datos;

import com.futuresoft.sistemamovagro_dominio.Compra;
import javax.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author jctri
 */
public class CompraDAO {

    private Conexion conexion;

    public CompraDAO() {
        conexion = new Conexion("com.FutureSoft_SistemaMovagro_Dominio_jar_1.0-SNAPSHOTPU");
    }
    
    public Compra guardarCompra(Compra compra) {
        EntityManager em = conexion.getEM();
        try {
            em.getTransaction().begin(); 
            em.persist(compra); 
            em.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); 
            }
            return null;
        }
        return compra; 
    }
    
    public Compra editarCompra(Compra compra) {
        EntityManager em = conexion.getEM();
        Compra compraEditada = null;
        try {
            em.getTransaction().begin();
            compraEditada = em.merge(compra); 
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null; 
        }
        return compraEditada;
    }

    public Compra eliminarCompra(int compraid) {
        EntityManager em = conexion.getEM();
        Compra compra = null;
        try {
            em.getTransaction().begin();
            compra = em.find(Compra.class, compraid); 
            if (compra != null) {
                compra.setEstado("Cancelada");
                em.merge(compra); 
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null; 
        }
        return compra; 
    }
    
    public List<Compra> obtenerComprasActivas() {
        EntityManager em = conexion.getEM();
        try {
            List<Compra> comprasActivas = em.createQuery("SELECT c FROM Compra c WHERE c.estado = :estado", Compra.class)
                    .setParameter("estado", "Activa")
                    .getResultList();
            return comprasActivas;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
} 