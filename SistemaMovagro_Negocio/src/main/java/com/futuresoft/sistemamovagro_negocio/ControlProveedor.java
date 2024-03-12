/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_negocio;

import com.futuresoft.sistemamovagro_datos.IDatos;
import com.futuresoft.sistemamovagro_datos.ProveedorDAO;
import com.futuresoft.sistemamovagro_dominio.Compra;
import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Proveedor;
import java.util.List;

/**
 *
 * @author jctri
 */
public class ControlProveedor implements INegocio{
    public IDatos datos;

    public ControlProveedor() {
        this.datos = new ProveedorDAO();
    }

    
    @Override
    public List<Proveedor> recuperaProveedor() {
      return datos.recuperaProveedor();
    }

    @Override
    public List<Material> mostrarMaterial(Proveedor proveedor) {
        return datos.mostrarMaterial(proveedor);
    }

    @Override
    public Compra guardarCompra(Compra compra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
