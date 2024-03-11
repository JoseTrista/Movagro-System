/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.futuresoft.sistemamovagro_datos;

import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Proveedor;
import java.util.List;

/**
 *
 * @author jctri
 */
public interface IDatos {
    public List<Proveedor> recuperaProveedor();
    
    public List<Material> mostrarMaterial(Proveedor proveedor);
}
