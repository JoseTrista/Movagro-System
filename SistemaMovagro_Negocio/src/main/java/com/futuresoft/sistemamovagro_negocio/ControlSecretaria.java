/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.futuresoft.sistemamovagro_negocio;

import com.futuresoft.sistemamovagro_datos.FachadaDatos;
import com.futuresoft.sistemamovagro_datos.IDatos;
import com.futuresoft.sistemamovagro_datos.SecretariaDAO;
import com.futuresoft.sistemamovagro_dominio.Compra;
import com.futuresoft.sistemamovagro_dominio.Material;
import com.futuresoft.sistemamovagro_dominio.Proveedor;
import com.futuresoft.sistemamovagro_dominio.Secretaria;
import java.util.List;

/**
 *
 * @author jctri
 */
public class ControlSecretaria {

    public IDatos datos;

    public ControlSecretaria() {
       this.datos = new FachadaDatos();
    }

    public Secretaria recuperaSecretaria() {
        return datos.recuperaSecretaria();
    }
    
}
