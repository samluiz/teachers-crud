package ifpi.miqueias.crudprofessores.services;

import ifpi.miqueias.crudprofessores.daos.Injecao;
import ifpi.miqueias.crudprofessores.daos.ProfessorDao;
import ifpi.miqueias.crudprofessores.models.Professor;
import javafx.collections.ObservableList;

import java.sql.SQLException;


// Service do professor que abstrai os métodos implementados no DAO
public class ProfessorService {
    private ProfessorDao dao;

    {
        try {
            dao = Injecao.novaProfessorDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Professor> buscarTodos() throws SQLException {
        return dao.buscarTodos();
    }

    public void inserir(Professor professor) throws SQLException {
        dao.inserir(professor);
    }

    public void modificar(Professor professor) throws SQLException {
        dao.modificar(professor);
    }

    public void remover(Integer id) throws SQLException {
        dao.remover(id);
    }
}
