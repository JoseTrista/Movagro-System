/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PDF;

/**
 *
 * @author jctri
 */
public class PdfReporte {
    private String Material;

    private String Proveedor;

    private String Precio;

    private String Ejemplares;

    private String UnidadMedida;

    public PdfReporte() {
    }

    public PdfReporte(String Material, String Proveedor, String Precio, String Ejemplares, String UnidadMedida) {
        this.Material = Material;
        this.Proveedor = Proveedor;
        this.Precio = Precio;
        this.Ejemplares = Ejemplares;
        this.UnidadMedida = UnidadMedida;
    }

    public String getMaterial() {
        return Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public String getPrecio() {
        return Precio;
    }

    public void setPrecio(String Precio) {
        this.Precio = Precio;
    }

    public String getEjemplares() {
        return Ejemplares;
    }

    public void setEjemplares(String Ejemplares) {
        this.Ejemplares = Ejemplares;
    }

    public String getUnidadMedida() {
        return UnidadMedida;
    }

    public void setUnidadMedida(String UnidadMedida) {
        this.UnidadMedida = UnidadMedida;
    }
    
    
}
