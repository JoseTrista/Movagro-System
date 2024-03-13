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

/**
 *
 * @author jctri
 */
public class FachadaDatos implements IDatos{
      private CompraDAO com = new CompraDAO();
      private ProveedorDAO  prov = new ProveedorDAO();
      private SecretariaDAO secretaria = new SecretariaDAO();
      
    @Override
    public List<Proveedor> recuperaProveedor() {
       return prov.recuperaProveedor();
    }

    @Override
    public List<Material> mostrarMaterial(Proveedor proveedor) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Compra guardarCompra(Compra compra) {
      return com.guardarCompra(compra);
    }

    @Override
    public Secretaria recuperaSecretaria() {
       return secretaria.recuperaSecretaria();
    }
    
}