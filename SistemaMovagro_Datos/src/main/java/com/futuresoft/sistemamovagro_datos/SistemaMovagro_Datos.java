/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.futuresoft.sistemamovagro_datos;

import com.futuresoft.sistemamovagro_dominio.Almacenista;

/**
 *
 * @author Equipo Movagro
 */
public class SistemaMovagro_Datos {

    public static void main(String[] args) {
        Conexion conexionBD = new Conexion("com.FutureSoft_SistemaMovagro_Dominio_jar_1.0-SNAPSHOTPU");
        
        conexionBD.getEM().getTransaction().begin();
        conexionBD.getEM().persist(new Almacenista( "Ivan", "644523256", "IvanB", "1234", "IvanB@gmail.com"));
        conexionBD.getEM().getTransaction().commit();
    }
}
