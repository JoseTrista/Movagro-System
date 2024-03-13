/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_datos;

import com.futuresoft.sistemamovagro_dominio.Compra;
import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Proveedor;
import com.futuresoft.sistemamovagro_dominio.Secretaria;
import java.util.List;
import javax.persistence.EntityManager;

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
            em.getTransaction().begin(); // Iniciar la transacción
            em.persist(compra); // Guardar la compra
            em.getTransaction().commit(); // Comprometer la transacción
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback(); // Deshacer la transacción si hay error
            }
            return null;
        }
        return compra; // Devolver la compra guardada
    }
//
//    @Override
//    public Secretaria  recuperaSecretaria() {
//        EntityManager em = conexion.getEM();
//        try {
//            // Suponiendo que siempre habrá al menos una Secretaria, esta consulta te devolverá la primera.
//            return em.createQuery("SELECT s FROM Secretaria s", Secretaria.class)
//                    .setMaxResults(1)
//                    .getSingleResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
} 