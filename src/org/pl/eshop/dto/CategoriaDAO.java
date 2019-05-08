package org.pl.eshop.dto;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.pl.eshop.bd.Conexion;

public interface CategoriaDAO {

    public void agregar(Categoria c) throws Exception;

    public void modificar(Categoria c) throws Exception;

    public void eliminar(Categoria c) throws Exception;

    public List<Categoria> obtenerTodas() throws Exception;

    public Categoria obtenerPorId(Integer id) throws Exception;
}
