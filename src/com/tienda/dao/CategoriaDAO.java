package com.tienda.dao;

import com.tienda.conexion.ConexionBaseDatos;
import com.tienda.modelo.Categoria;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    private ConexionBaseDatos conexionBaseDatos;

    public CategoriaDAO() {
        this.conexionBaseDatos = ConexionBaseDatos.obtenerInstancia();
    }

    public boolean insertarCategoria(Categoria categoria) {
        String sql = "INSERT INTO categorias (nombre_categoria, descripcion_categoria, estado) VALUES (?, ?, ?)";
        try (Connection conexion = conexionBaseDatos.obtenerConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombreCategoria());
            ps.setString(2, categoria.getDescripcionCategoria());
            ps.setBoolean(3, categoria.isEstado());
            if (ps.executeUpdate() > 0) {
                System.out.println("✓ Categoría insertada correctamente");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al insertar categoría: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public List<Categoria> obtenerTodasCategorias() {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT * FROM categorias WHERE estado = true";
        try (Connection conexion = conexionBaseDatos.obtenerConexion(); Statement st = conexion.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Categoria categoria = new Categoria(
                    rs.getInt("id_categoria"),
                    rs.getString("nombre_categoria"),
                    rs.getString("descripcion_categoria"),
                    rs.getBoolean("estado")
                );
                categorias.add(categoria);
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al consultar categorías: " + e.getMessage());
            e.printStackTrace();
        }
        return categorias;
    }

    public Categoria obtenerCategoriaPorId(int idCategoria) {
        String sql = "SELECT * FROM categorias WHERE id_categoria = ? AND estado = true";
        try (Connection conexion = conexionBaseDatos.obtenerConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Categoria(
                        rs.getInt("id_categoria"),
                        rs.getString("nombre_categoria"),
                        rs.getString("descripcion_categoria"),
                        rs.getBoolean("estado")
                    );
                }
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al consultar categoría: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public boolean actualizarCategoria(Categoria categoria) {
        String sql = "UPDATE categorias SET nombre_categoria = ?, descripcion_categoria = ? WHERE id_categoria = ?";
        try (Connection conexion = conexionBaseDatos.obtenerConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, categoria.getNombreCategoria());
            ps.setString(2, categoria.getDescripcionCategoria());
            ps.setInt(3, categoria.getIdCategoria());
            if (ps.executeUpdate() > 0) {
                System.out.println("✓ Categoría actualizada correctamente");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al actualizar categoría: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }

    public boolean eliminarCategoria(int idCategoria) {
        String sql = "UPDATE categorias SET estado = false WHERE id_categoria = ?";
        try (Connection conexion = conexionBaseDatos.obtenerConexion(); PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setInt(1, idCategoria);
            if (ps.executeUpdate() > 0) {
                System.out.println("✓ Categoría eliminada correctamente");
                return true;
            }
        } catch (SQLException e) {
            System.out.println("✗ Error al eliminar categoría: " + e.getMessage());
            e.printStackTrace();
        }
        return false;
    }
}