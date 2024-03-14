/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_negocio;

import com.futuresoft.sistemamovagro_datos.FachadaDatos;
import com.futuresoft.sistemamovagro_datos.IDatos;
import com.futuresoft.sistemamovagro_dominio.Compra;
import com.futuresoft.sistemamovagro_dominio.Secretaria;

/**
 *
 * @author jctri
 */
public class ControlCompra {

    public IDatos datos;

    public ControlCompra() {
        this.datos = new FachadaDatos();
    }
  
    public Compra guardarCompra(Compra compra) {
          return datos.guardarCompra(compra);
    }

    public Secretaria  recuperaSecretaria() {
       return datos.recuperaSecretaria();
    }
    
    public Compra editarCompra(Compra compra){
        return datos.editarCompra(compra);
    }
    
    public Compra eliminarCompra(int compraid){
        return datos.eliminarCompra(compraid);
    }

}
