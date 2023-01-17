package ifpi.miqueias.crudprofessores.utils;

import ifpi.miqueias.crudprofessores.models.Professor;
import ifpi.miqueias.crudprofessores.models.enums.Disciplina;
import ifpi.miqueias.crudprofessores.services.ProfessorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.sql.SQLException;
import java.util.List;

// Métodos usados nos controllers para popular as combobox
public class ControllerLoaders {

    public void disciplinas(List disciplinas, ObservableList obsDisciplinas, ComboBox cbbDisciplinas) {
        for(Disciplina d : Disciplina.values()) {
            disciplinas.add(d);
        }
        obsDisciplinas = FXCollections.observableArrayList(disciplinas);
        cbbDisciplinas.setItems(obsDisciplinas);
    }

    public void professores(List professores, ObservableList obsProfessores, ComboBox cbbProfessores) throws SQLException {
        ProfessorService service = new ProfessorService();
        ObservableList<Professor> lista = service.buscarTodos();

        if (professores != null && !professores.isEmpty()) {
            professores.clear();
        }
        if (obsProfessores != null) {
            obsProfessores.clear();
        }
        for(Professor p : lista) {
            professores.add(p);
        }
        obsProfessores = FXCollections.observableArrayList(professores);
        cbbProfessores.setItems(obsProfessores);
    }
}
