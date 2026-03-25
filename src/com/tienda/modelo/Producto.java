package com.tienda.modelo;

/**
 * Clase modelo que representa un Producto en la tienda
 * Contiene los atributos y métodos para gestionar productos
 */
public class Producto {
    private int idProducto;
    private String nombreProducto;
    private String descripcionProducto;
    private double precioProducto;
    private int cantidadStock;
    private int idCategoria;
    private int idProveedor;
    private boolean estado;
    
    /**
     * Constructor vacío
     */
    public Producto() { }
    
    /**
     * Constructor con todos los parámetros
     */
    public Producto(int idProducto, String nombreProducto, String descripcionProducto,
                    double precioProducto, int cantidadStock, int idCategoria,
                    int idProveedor, boolean estado) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.cantidadStock = cantidadStock;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
        this.estado = estado;
    }
    
    /**
     * Constructor sin ID (para inserciones)
     */
    public Producto(String nombreProducto, String descripcionProducto,
                    double precioProducto, int cantidadStock, int idCategoria,
                    int idProveedor) {
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.precioProducto = precioProducto;
        this.cantidadStock = cantidadStock;
        this.idCategoria = idCategoria;
        this.idProveedor = idProveedor;
        this.estado = true;
    }
    
    // Getters y Setters
    public int getIdProducto() {
        return idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public String getNombreProducto() {
        return nombreProducto;
    }
    
    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
    
    public String getDescripcionProducto() {
        return descripcionProducto;
    }
    
    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }
    
    public double getPrecioProducto() {
        return precioProducto;
    }
    
    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
    
    public int getCantidadStock() {
        return cantidadStock;
    }
    
    public void setCantidadStock(int cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
    
    public int getIdCategoria() {
        return idCategoria;
    }
    
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
    
    public int getIdProveedor() {
        return idProveedor;
    }
    
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    public boolean isEstado() {
        return estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    /**
     * Método toString para mostrar información del producto
     */
    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", descripcionProducto='" + descripcionProducto + '\'' +
                ", precioProducto=" + precioProducto +
                ", cantidadStock=" + cantidadStock +
                ", idCategoria=" + idCategoria +
                ", idProveedor=" + idProveedor +
                ", estado=" + estado +
                '}';
    }
}