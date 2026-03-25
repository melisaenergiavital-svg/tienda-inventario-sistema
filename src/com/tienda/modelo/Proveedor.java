package com.tienda.modelo;

public class Proveedor {
    private int idProveedor;
    private String nombreProveedor;
    private String telefonoProveedor;
    private String emailProveedor;
    private boolean estado;

    public Proveedor() { }

    public Proveedor(int idProveedor, String nombreProveedor, String telefonoProveedor, String emailProveedor, boolean estado) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.emailProveedor = emailProveedor;
        this.estado = estado;
    }

    public Proveedor(String nombreProveedor, String telefonoProveedor, String emailProveedor) {
        this.nombreProveedor = nombreProveedor;
        this.telefonoProveedor = telefonoProveedor;
        this.emailProveedor = emailProveedor;
        this.estado = true;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getTelefonoProveedor() {
        return telefonoProveedor;
    }

    public void setTelefonoProveedor(String telefonoProveedor) {
        this.telefonoProveedor = telefonoProveedor;
    }

    public String getEmailProveedor() {
        return emailProveedor;
    }

    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "idProveedor=" + idProveedor +
                ", nombreProveedor='" + nombreProveedor + '\'' +
                ", telefonoProveedor='" + telefonoProveedor + '\'' +
                ", emailProveedor='" + emailProveedor + '\'' +
                ", estado=" + estado +
                '}';
    }
}