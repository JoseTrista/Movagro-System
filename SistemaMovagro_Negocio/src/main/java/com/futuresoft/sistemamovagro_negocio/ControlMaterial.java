/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_negocio;

import com.futuresoft.sistemamovagro_datos.FachadaDatos;
import com.futuresoft.sistemamovagro_datos.IDatos;
import com.futuresoft.sistemamovagro_dominio.Material;
import java.util.List;

/**
 *
 * @author jctri
 */
public class ControlMaterial {
    public IDatos datos;
    
    public ControlMaterial() {
        this.datos = new FachadaDatos();
    }
    
    public Material guardarMaterial(Material material) {
          return datos.guardarMaterial(material);
    }
    
    public List<Material> recuperaMaterial(){
        return datos.recuperaMaterial();
    }
    
    public Material eliminarMaterial(int materialID) {
          return datos.eliminarMaterial(materialID);
    }
    
    public Material editarMaterial(Material material) {
          return datos.editarMaterial(material);
    }
}
