/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_datos;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Sistema Movagro
 */
public class Conexion implements IConexion{
    
    private EntityManager entityManager;
    private String nombrePersistencia;

    public Conexion(String nombrePersistencia) {
        this.nombrePersistencia = nombrePersistencia;
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(nombrePersistencia);
        entityManager = entityManagerFactory.createEntityManager();
    }
    
    @Override
    public EntityManager getEM() {
        return entityManager;
    }
}
