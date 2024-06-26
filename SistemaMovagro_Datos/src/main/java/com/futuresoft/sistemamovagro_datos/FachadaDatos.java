/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_datos;

import com.futuresoft.sistemamovagro_dominio.Compra;
import com.futuresoft.sistemamovagro_dominio.DetalleCompra;
import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Movimiento;
import com.futuresoft.sistemamovagro_dominio.Proveedor;
import com.futuresoft.sistemamovagro_dominio.Secretaria;
import java.util.List;

/**
 *
 * @author jctri
 */
public class FachadaDatos implements IDatos{
      private MaterialDAO mat = new MaterialDAO();
      private CompraDAO com = new CompraDAO();
      private ProveedorDAO  prov = new ProveedorDAO();
      private SecretariaDAO secretaria = new SecretariaDAO();
      private MovimientoDAO movi=new MovimientoDAO();
      
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
    public List<Compra> recuperarCompras() {
      return com.obtenerComprasActivas();
    }

    @Override
    public List<DetalleCompra> recuperaDetalleCompra(int compraId) {
        return com.recuperarDetallesPorCompraId(compraId);
    }

    @Override
    public Material guardarMaterial(Material material) {
       return mat.guardarMaterial(material);
    }

    @Override
    public List<Material> recuperaMaterial() {
       return mat.recuperaMaterial();
    }

    @Override
    public Material eliminarMaterial(int materialID) {
       return mat.eliminarMaterial(materialID);
    }

    @Override
    public Material editarMaterial(Material material) {
      return mat.editarMaterial(material);
    }

    @Override
    public Material actualizarCantidadMaterial(int materialId, int cantidadAdicional) {
        return mat.actualizarCantidadMaterial(materialId, cantidadAdicional);
    }

    @Override
    public Movimiento añadirMovimiento(Movimiento movimineto) {
      return movi.guardarMovimiento(movimineto);
    }

    @Override
    public List<Movimiento> consultarMovimientos() {
        return movi.consultarMovimientos();
    }

    @Override
    public Movimiento actualizarMovimiento(Movimiento movimiento) {
      return movi.actualizarMovimiento(movimiento);
    }

    @Override
    public Material actualizarCantidadMaterialMovimiento(int materialId, int cantidadNueva) {
    return mat.actualizarCantidadMaterialMovimiento(materialId, cantidadNueva);
    }

    @Override
    public Material actualizarMaterial(int materialId, String nuevoNombre, String nuevaDescripcion, String nuevaUnidadMedida) {
        return mat.actualizarMaterial(materialId, nuevoNombre, nuevaDescripcion, nuevaUnidadMedida);
    }
    
    
}
