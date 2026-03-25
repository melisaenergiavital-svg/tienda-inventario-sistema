package com.tienda.conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Clase para gestionar la conexión a la base de datos MySQL
 * Utiliza el patrón Singleton para garantizar una única instancia
 */
public class ConexionBaseDatos {
    private static final String URL = "jdbc:mysql://localhost:3306/InventoryDB";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static ConexionBaseDatos instancia;
    private Connection conexion;
    /**
     * Constructor privado para implementar Singleton
     */
    private ConexionBaseDatos() { }
    /**
     * Obtiene la instancia única de ConexionBaseDatos
     */
    public static ConexionBaseDatos obtenerInstancia() {
        if (instancia == null) {
            instancia = new ConexionBaseDatos();
        }
        return instancia;
    }
    /**
     * Establece la conexión con la base de datos
     */
    public Connection conectar() {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println("✓ Conexión exitosa a la base de datos");
            return conexion;
        } catch (ClassNotFoundException e) {
            System.out.println("✗ Error: Driver JDBC no encontrado");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.out.println("✗ Error: No se pudo conectar a la base de datos");
            e.printStackTrace();
            return null;
        }
    }
    /**
     * Obtiene la conexión actual
     */
    public Connection obtenerConexion() {
        if (conexion == null) {
            conectar();
        }
        return conexion;
    }
    /**
     * Cierra la conexión con la base de datos
     */
    public void desconectar() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
                System.out.println("✓ Conexión cerrada");
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al cerrar la conexión");
            e.printStackTrace();
        }
    }
}