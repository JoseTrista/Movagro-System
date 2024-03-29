/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_negocio;

import com.futuresoft.sistemamovagro_dominio.Compra;
import com.futuresoft.sistemamovagro_dominio.DetalleCompra;
import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Proveedor;
import com.futuresoft.sistemamovagro_dominio.Secretaria;
import java.util.List;

/**
 *
 * @author jctri
 */
public class FachadaNegocio implements INegocio{
    ControlCompra com = new ControlCompra();
    ControlProveedor prov = new ControlProveedor();
    ControlSecretaria secretaria = new ControlSecretaria();
           
    @Override
    public List<Proveedor> recuperaProveedor() {
        return prov.recuperaProveedor();
    }

    @Override
    public List<Material> mostrarMaterial(Proveedor proveedor) {
        return prov.mostrarMaterial(proveedor);
    }

    @Override
    public Compra guardarCompra(Compra compra) {
        return com.guardarCompra(compra);
    }

    @Override
    public Secretaria recuperaSecretaria() {
        return secretaria.recuperaSecretaria();
    }

    @Override
    public Compra editarCompra(Compra compra) {
       return com.editarCompra(compra);
    }

    @Override
    public Compra eliminarCompra(int compraid) {
        return com.eliminarCompra(compraid);
    }

    @Override
    public List<Compra> recuperaCompras() {
      return com.recuperaCompras();
    }

    @Override
    public List<DetalleCompra> recuperaDetalleCompra(int compraId) {
       return com.recuperaDetalleCompra(compraId);
    }
    
}
