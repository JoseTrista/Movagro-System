/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sistema Movagro
 */
public class Conexion {
    
    final String CADENA_CONEXION ="jdbc:mysql://127.0.0.1:3306/Movagro";
    final String USUARIO = "root";
    final String CONTRASEÑA ="Movagro123.,";
    
    public Connection crearConexion() throws SQLException {
       Connection conexion =DriverManager.getConnection(CADENA_CONEXION, USUARIO, CONTRASEÑA);
       return conexion;
    }
}
