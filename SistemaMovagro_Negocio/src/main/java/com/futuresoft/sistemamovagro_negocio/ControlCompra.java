/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_negocio;

import com.futuresoft.sistemamovagro_datos.IDatos;
import com.futuresoft.sistemamovagro_dominio.Compra;
import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Proveedor;
import java.util.List;

/**
 *
 * @author jctri
 */
public class ControlCompra implements INegocio {

    public IDatos datos;

    @Override
    public List<Proveedor> recuperaProveedor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Material> mostrarMaterial(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Compra guardarCompra(Compra compra) {
          return datos.guardarCompra(compra);
    }

}
