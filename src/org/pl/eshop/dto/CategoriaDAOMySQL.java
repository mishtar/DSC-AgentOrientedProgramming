package org.pl.eshop.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.pl.eshop.bd.Conexion;

public class CategoriaDAOMySQL implements CategoriaDAO {

    Statement st = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;
    Conexion conexion = null;

    @Override
    public void agregar(Categoria c) throws SQLException {
        conn = Conexion.getConexion();
        String query = "INSERT INTO categoria (nombre, descripcion) values(?, ?)";
 ps = conn.prepareStatement(query);
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getDescripcion());
        ps.executeUpdate();
        conn.close();
    }

    @Override
    public void modificar(Categoria c) throws SQLException {
        conn = Conexion.getConexion();
        String query = "UPDATE categoria SET nombre=?, descripcion=? WHERE id =  ?";
 ps = conn.prepareStatement(query);
        ps.setString(1, c.getNombre());
        ps.setString(2, c.getDescripcion());
        ps.setInt(3, c.getId());
        ps.executeUpdate();
        conn.close();
    }

    @Override
    public void eliminar(Categoria c) throws SQLException {
        conn = Conexion.getConexion();
        String query = "DELETE FROM categoria WHERE id=?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, c.getId());
        ps.executeUpdate();
        conn.close();
    }

    @Override
    public List<Categoria> obtenerTodas() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        conn = Conexion.getConexion();
        String s = "SELECT * FROM categoria";
        st = conn.createStatement();
        rs = st.executeQuery(s);
        while (rs.next()) {
            categorias.add(new Categoria(rs.getInt("id"),
                    rs.getString("nombre"), rs.getString("descripcion")));
        }
        conn.close();
        return categorias;
    }

    @Override
    public Categoria obtenerPorId(Integer id) throws SQLException {
        Categoria categoria = null;
        conn = Conexion.getConexion();
        String query = "SELECT * FROM categoria WHERE id=?";
        ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        if (rs.next()) {
            categoria = new Categoria(rs.getInt("id"),
                    rs.getString("nombre"), rs.getString("descripcion"));
        }
        conn.close();
        return categoria;
    }
}
