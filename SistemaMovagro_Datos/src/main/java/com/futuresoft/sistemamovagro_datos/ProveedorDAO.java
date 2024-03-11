/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_datos;

import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Proveedor;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;


/**
 *
 * @author jctri
 */
public class ProveedorDAO implements IDatos{

    private Conexion conexion;

    public ProveedorDAO() {
        this.conexion = new Conexion("com.FutureSoft_SistemaMovagro_Dominio_jar_1.0-SNAPSHOTPU");
    }
    
    
    @Override
    public List<Proveedor> recuperaProveedor() {
        EntityManager em = conexion.getEM();
        try {
            List<Proveedor> listaProveedores = em.createQuery("SELECT p FROM Proveedor p", Proveedor.class).getResultList();
            return listaProveedores;
        } catch (Exception e) {
            e.printStackTrace();
            return null; 
        }
    }
    
  
    @Override
    public List<Material> mostrarMaterial(Proveedor proveedor) {
        
       EntityManager em = conexion.getEM();
    try {
        // Asumiendo que existe una relación entre Proveedor y Material llamada "materiales"
        List<Material> listaMateriales = em.createQuery("SELECT m FROM Material m WHERE m.proveedor = :proveedor", Material.class)
                .setParameter("proveedor", proveedor)
                .getResultList();
        return listaMateriales;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }

    }
    
}
