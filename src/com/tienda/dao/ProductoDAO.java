package com.tienda.dao;

import com.tienda.conexion.ConexionBaseDatos;
import com.tienda.modelo.Producto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase DAO (Data Access Object) para Producto
 * Implementa operaciones CRUD (Create, Read, Update, Delete)
 */
public class ProductoDAO {
    private ConexionBaseDatos conexionBaseDatos;

    public ProductoDAO() {
        this.conexionBaseDatos = ConexionBaseDatos.obtenerInstancia();
    }

    /**
     * Inserta un nuevo producto en la base de datos
     */
    public boolean insertarProducto(Producto producto) {
        String sql = "INSERT INTO productos (nombre_producto, descripcion_producto, precio_producto, " +
                     "cantidad_stock, id_categoria, id_proveedor, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conexion = conexionBaseDatos.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcionProducto());
            ps.setDouble(3, producto.getPrecioProducto());
            ps.setInt(4, producto.getCantidadStock());
            ps.setInt(5, producto.getIdCategoria());
            ps.setInt(6, producto.getIdProveedor());
            ps.setBoolean(7, producto.isEstado());
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✓ Producto insertado correctamente");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al insertar producto: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Obtiene todos los productos de la base de datos
     */
    public List<Producto> obtenerTodosProductos() {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE estado = true";
        try (Connection conexion = conexionBaseDatos.obtenerConexion();
             Statement st = conexion.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Producto producto = new Producto(
                    rs.getInt("id_producto"),
                    rs.getString("nombre_producto"),
                    rs.getString("descripcion_producto"),
                    rs.getDouble("precio_producto"),
                    rs.getInt("cantidad_stock"),
                    rs.getInt("id_categoria"),
                    rs.getInt("id_proveedor"),
                    rs.getBoolean("estado")
                );
                productos.add(producto);
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al consultar productos: " + e.getMessage());
            e.printStackTrace();
        }
        return productos;
    }

    /**
     * Obtiene un producto por su ID
     */
    public Producto obtenerProductoPorId(int idProducto) {
        String sql = "SELECT * FROM productos WHERE id_producto = ? AND estado = true";
        try (Connection conexion = conexionBaseDatos.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre_producto"),
                        rs.getString("descripcion_producto"),
                        rs.getDouble("precio_producto"),
                        rs.getInt("cantidad_stock"),
                        rs.getInt("id_categoria"),
                        rs.getInt("id_proveedor"),
                        rs.getBoolean("estado")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al consultar producto: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Obtiene un producto por su nombre
     */
    public Producto obtenerProductoPorNombre(String nombreProducto) {
        String sql = "SELECT * FROM productos WHERE nombre_producto = ? AND estado = true";
        try (Connection conexion = conexionBaseDatos.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, nombreProducto);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre_producto"),
                        rs.getString("descripcion_producto"),
                        rs.getDouble("precio_producto"),
                        rs.getInt("cantidad_stock"),
                        rs.getInt("id_categoria"),
                        rs.getInt("id_proveedor"),
                        rs.getBoolean("estado")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al consultar producto: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Actualiza la información de un producto
     */
    public boolean actualizarProducto(Producto producto) {
        String sql = "UPDATE productos SET nombre_producto = ?, descripcion_producto = ?, " +
                     "precio_producto = ?, cantidad_stock = ?, id_categoria = ?, id_proveedor = ? " +
                     "WHERE id_producto = ?";
        try (Connection conexion = conexionBaseDatos.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcionProducto());
            ps.setDouble(3, producto.getPrecioProducto());
            ps.setInt(4, producto.getCantidadStock());
            ps.setInt(5, producto.getIdCategoria());
            ps.setInt(6, producto.getIdProveedor());
            ps.setInt(7, producto.getIdProducto());
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✓ Producto actualizado correctamente");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al actualizar producto: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Elimina un producto (cambio lógico de estado)
     */
    public boolean eliminarProducto(int idProducto) {
        String sql = "UPDATE productos SET estado = false WHERE id_producto = ?";
        try (Connection conexion = conexionBaseDatos.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idProducto);
            
            int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("✓ Producto eliminado correctamente");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al eliminar producto: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Obtiene productos por categoría
     */
    public List<Producto> obtenerProductosPorCategoria(int idCategoria) {
        List<Producto> productos = new ArrayList<>();
        String sql = "SELECT * FROM productos WHERE id_categoria = ? AND estado = true";
        try (Connection conexion = conexionBaseDatos.obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Producto producto = new Producto(
                        rs.getInt("id_producto"),
                        rs.getString("nombre_producto"),
                        rs.getString("descripcion_producto"),
                        rs.getDouble("precio_producto"),
                        rs.getInt("cantidad_stock"),
                        rs.getInt("id_categoria"),
                        rs.getInt("id_proveedor"),
                        rs.getBoolean("estado")
                    );
                    productos.add(producto);
                }
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al consultar productos: " + e.getMessage());
            e.printStackTrace();
        }
        return productos;
    }
}