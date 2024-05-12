/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_negocio;

import com.futuresoft.sistemamovagro_datos.FachadaDatos;
import com.futuresoft.sistemamovagro_datos.IDatos;
import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Movimiento;
import java.util.List;

/**
 *
 * @author IVAN
 */
public class ControlMovimiento {
      public IDatos datos;
      
      public ControlMovimiento() {
        this.datos = new FachadaDatos();
    }

    public Movimiento guardarMovimiento(Movimiento movimiento) {
        return datos.añadirMovimiento(movimiento);
    }
    
    public List<Movimiento> consultarMovimientos(){
        return datos.consultarMovimientos();
    }

}
