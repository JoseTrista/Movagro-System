/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.futuresoft.sistemamovagro_datos;

/**
 *
 * @author Equipo Movagro
 */
public class SistemaMovagro_Datos {

    public static void main(String[] args) {
        Conexion conexionBD = new Conexion("Movagro");
        
        conexionBD.getEM().getTransaction().begin();
        //conexionBD.getEM().persist(new Material());
        conexionBD.getEM().getTransaction().commit();
    }
}
