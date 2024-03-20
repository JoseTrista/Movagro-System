/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
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
 * @author Equipo Movagro
 */
public interface INegocio {
    public List<Proveedor> recuperaProveedor();
    
    public List<Material> mostrarMaterial(Proveedor proveedor);
    
    public List<Compra> recuperaCompras();
    
    public Compra guardarCompra(Compra compra);
    
    public Compra editarCompra(Compra compra);
    
    public Compra eliminarCompra(int compraid);
    
    public Secretaria  recuperaSecretaria();
    
    public List<DetalleCompra> recuperaDetalleCompra(int compraId);
}
