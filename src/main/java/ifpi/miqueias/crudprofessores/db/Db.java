package ifpi.miqueias.crudprofessores.db;

import java.sql.*;

// Classe que se conecta ao banco de dados via JDBC
public class Db {

    private static String url = "";
    private static String user = "";
    private static String password = "";

    private static Connection conn = null;

    public static Connection conectar() throws SQLException {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new SQLException("Erro: " + e.getMessage());
            }
        }
        return conn;
    }

    public static void fecharSt(Statement st) throws SQLException {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new SQLException();
            }
        }
    }

    public static void fecharRs(ResultSet rs) throws SQLException {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new SQLException();
            }
        }
    }
}
