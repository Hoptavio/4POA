package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    private static final String URL = "jdbc:mariadb://localhost:3306/faeterj_alerta";
    private static final String USER = "root"; 
    private static final String PASS = "1234"; 

    public static Connection conectar() throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver MariaDB não encontrado!", e);
        }
    }
}
