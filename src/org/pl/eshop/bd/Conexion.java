package org.pl.eshop.bd;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;
import org.pl.eshop.general.Config;

public class Conexion {

    private static final String SERVIDOR = Config.SERVIDOR;
    private static final int PUERTO = Config.PUERTO;
    private static final String BD = Config.BD;
    private static final String NOMBRE_USUARIO = Config.NOMBRE_USUARIO;
    private static final String CONTRASENA_USUARIO
            = Config.CONTRASENA_USUARIO;

    public static Connection getConexion() throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setServerName(SERVIDOR);
        ds.setPortNumber(PUERTO);
        ds.setDatabaseName(BD);
        ds.setUser(NOMBRE_USUARIO);
        ds.setPassword(CONTRASENA_USUARIO);
        ds.setUseSSL(false);
        return ds.getConnection();
    }
}
