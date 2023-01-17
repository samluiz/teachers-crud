package ifpi.miqueias.crudprofessores.daos.impl;

import ifpi.miqueias.crudprofessores.daos.ProfessorDao;
import ifpi.miqueias.crudprofessores.db.Db;
import ifpi.miqueias.crudprofessores.models.Professor;
import ifpi.miqueias.crudprofessores.models.enums.Disciplina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfessorDaoImpl implements ProfessorDao {

    private Connection conexao;
    public ProfessorDaoImpl(Connection conexao) {
        this.conexao = conexao;
    }

    @Override
    public void inserir(Professor professor) throws SQLException {
        PreparedStatement st = null;
        try {
            st = conexao.prepareStatement(
                    "INSERT INTO professor " +
                            "(nome, matricula, disciplina) " +
                            "VALUES " +
                            "(?, ?, ?);"
            );
            st.setString(1, professor.getNome());
            st.setString(2, professor.getMatricula());
            st.setString(3, professor.getDisciplina().toString());

            int colunas = st.executeUpdate();

            if (colunas > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    professor.setId(id);
                }
                Db.fecharRs(rs);
            }
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            Db.fecharSt(st);
        }
    }

    @Override
    public void modificar(Professor professor) throws SQLException {
        PreparedStatement st = null;
        try {
            st = conexao.prepareStatement(
                    "UPDATE professor " +
                            "SET nome = coalesce(NULLIF(?, ''), nome), " +
            "matricula = coalesce(NULLIF(?, ''), matricula), " +
                    "disciplina = coalesce(NULLIF(?, ''), disciplina) " +
                            "WHERE id = ?;"
            );
            st.setString(1, professor.getNome());
            st.setString(2, professor.getMatricula());
            st.setString(3, professor.getDisciplina() == null ? null : professor.getDisciplina().toString());
            st.setInt(4, professor.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            Db.fecharSt(st);
        }
    }

    @Override
    public void remover(Integer id) throws SQLException {
        PreparedStatement st = null;
        try {
            st = conexao.prepareStatement(
                    "DELETE FROM professor WHERE id = ?;"
            );
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            Db.fecharSt(st);
        }
    }

    @Override
    public ObservableList<Professor> buscarTodos() throws SQLException {
        ObservableList<Professor> listaProfessores = FXCollections.observableArrayList();
        PreparedStatement st;
        ResultSet rs;
        st = conexao.prepareStatement("SELECT * FROM professor;");
        rs = st.executeQuery();
        Professor professor;
        while(rs.next()) {
            professor = new Professor(rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("matricula"),
                    Disciplina.valueOf(rs.getString("disciplina")));
            listaProfessores.add(professor);
        }
        Db.fecharSt(st);
        Db.fecharRs(rs);
        return listaProfessores;
    }
}
