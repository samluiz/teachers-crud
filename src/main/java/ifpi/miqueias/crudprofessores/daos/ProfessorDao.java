package ifpi.miqueias.crudprofessores.daos;

import ifpi.miqueias.crudprofessores.models.Professor;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ProfessorDao {

    void inserir(Professor professor) throws SQLException;
    void modificar(Professor professor) throws SQLException;
    void remover(Integer id) throws SQLException;
    ObservableList<Professor> buscarTodos() throws SQLException;
}
