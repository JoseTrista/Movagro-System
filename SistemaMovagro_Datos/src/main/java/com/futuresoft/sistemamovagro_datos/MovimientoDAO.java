/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_datos;

import com.futuresoft.sistemamovagro_dominio.Movimiento;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author IVAN
 */
public class MovimientoDAO {

    private Conexion conexion;

    public MovimientoDAO() {
        conexion = new Conexion("com.FutureSoft_SistemaMovagro_Dominio_jar_1.0-SNAPSHOTPU");
    }

    public Movimiento guardarMovimiento(Movimiento movimiento) {
        EntityManager em = conexion.getEM();
        try {
            em.getTransaction().begin();
            em.persist(movimiento);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
        return movimiento;
    }

    public List<Movimiento> consultarMovimientos() {
        EntityManager em = conexion.getEM();
        try {
            List<Movimiento> listaMovimientos = em.createQuery("SELECT m FROM Movimiento m", Movimiento.class).getResultList();
            return listaMovimientos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Movimiento actualizarMovimiento(Movimiento movimiento) {
        EntityManager em = conexion.getEM();
        try {
            em.getTransaction().begin();
            movimiento = em.merge(movimiento);
            em.getTransaction().commit();
            return movimiento;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return null;
        }
    }

}
