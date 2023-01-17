package com.saurs.teacherscrud.db;

import java.sql.*;

// Classe que se conecta ao banco de dados via JDBC
public class Db {

    private static String url = "jdbc:postgresql://localhost:5432/";
    private static String user = "postgres";
    private static String password = "";

    private static Connection conn = null;

    public static Connection connect() throws SQLException {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, password);
            } catch (SQLException e) {
                throw new SQLException("Erro: " + e.getMessage());
            }
        }
        return conn;
    }

    public static void closeStatement(Statement st) throws SQLException {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new SQLException();
            }
        }
    }

    public static void closeResultSet(ResultSet rs) throws SQLException {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new SQLException();
            }
        }
    }
}
