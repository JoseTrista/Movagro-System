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
    private String material;
    private String proveedor;
    private String precio;
    private String ejemplares;
    private String unidadmedida;
    
    public PdfReporte() {
    }

    public PdfReporte(String material, String proveedor, String precio, String ejemplares, String unidadmedida) {
        this.material = material;
        this.proveedor = proveedor;
        this.precio = precio;
        this.ejemplares = ejemplares;
        this.unidadmedida = unidadmedida;
    }

    

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String Material) {
        this.material = Material;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.proveedor = Proveedor;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String Precio) {
        this.precio = Precio;
    }

    public String getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(String Ejemplares) {
        this.ejemplares = Ejemplares;
    }

    

    @Override
    public String toString() {
        return "PdfReporte{" + "material=" + material + ", proveedor=" + proveedor + ", precio=" + precio + ", ejemplares=" + ejemplares + ", unidadmedida=" + unidadmedida + '}';
    }
    
    
    
    
}
