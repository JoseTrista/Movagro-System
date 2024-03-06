/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.futuresoft.sistemamovagro_datos;

import javax.persistence.EntityManager;

/**
 *
 * @author Equipo Movagro
 */
public interface IConexion {
    /**
     * Método para obtener el EntityManager de la conexión.
     *
     * @return EntityManager de la conexión.
     */
    public EntityManager getEM();
}
