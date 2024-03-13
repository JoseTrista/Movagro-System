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
public class SecretariaDAO {

    private Conexion conexion;

    public SecretariaDAO() {
        this.conexion = new Conexion("com.FutureSoft_SistemaMovagro_Dominio_jar_1.0-SNAPSHOTPU");
    }
    
    public Secretaria  recuperaSecretaria() {
        EntityManager em = conexion.getEM();
        try {
            return em.createQuery("SELECT s FROM Secretaria s", Secretaria.class)
                    .setMaxResults(1)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
