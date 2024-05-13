/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_datos;

import com.futuresoft.sistemamovagro_dominio.Material;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author jctri
 */
public class MaterialDAO {
    private Conexion conexion;
    
    public MaterialDAO() {
        conexion = new Conexion("com.FutureSoft_SistemaMovagro_Dominio_jar_1.0-SNAPSHOTPU");
    }
    
    public Material guardarMaterial(Material material) {
        EntityManager em = conexion.getEM();
        try {
            em.getTransaction().begin(); 
            em.persist(material); 
            em.getTransaction().commit(); 
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); 
            }
            return null;
        }
        return material; 
    }
    
    public List<Material> recuperaMaterial() {
        EntityManager em = conexion.getEM();
        try {
            List<Material> listaMateriales = em.createQuery("SELECT p FROM Material p", Material.class).getResultList();
            return listaMateriales;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
    
    public Material editarMaterial(Material material) {
        EntityManager em = conexion.getEM();
        Material materialEditado = null;
        try {
            em.getTransaction().begin();
            materialEditado = em.merge(material); 
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null; 
        }
        return materialEditado;
    }
    
    public Material eliminarMaterial(int materialID) {
        EntityManager em = conexion.getEM();
        Material material = null;
        try {
            em.getTransaction().begin();
            material = em.find(Material.class, materialID); 
            if (material != null) {
                em.remove(material); 
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null; 
        }
        return material; 
    }
    
    public Material actualizarCantidadMaterial(int materialId, int cantidadAdicional) {
        EntityManager em = conexion.getEM();
        Material material = null;
        try {
            em.getTransaction().begin();
            material = em.find(Material.class, materialId); // Buscar el material por ID
            if (material != null) {
                material.setCantidad(material.getCantidad() + cantidadAdicional); // Actualizar la cantidad
                em.merge(material); // Guardar los cambios
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
        return material;
    }
    
    
      
    public Material actualizarCantidadMaterialMovimiento(int materialId, int cantidadNueva) {
        EntityManager em = conexion.getEM();
        Material material = null;
        try {
            em.getTransaction().begin();
            material = em.find(Material.class, materialId); 
            if (material != null) {
                material.setCantidad(cantidadNueva); 
                em.merge(material); 
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
        return material;
    }
}
