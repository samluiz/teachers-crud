package ifpi.miqueias.crudprofessores;

import ifpi.miqueias.crudprofessores.models.Professor;
import ifpi.miqueias.crudprofessores.models.enums.Disciplina;
import ifpi.miqueias.crudprofessores.services.ProfessorService;
import ifpi.miqueias.crudprofessores.utils.ControllerLoaders;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EditController implements Initializable {

    @FXML
    private ComboBox<Disciplina> cbbDisciplinas;

    @FXML
    private ComboBox<Professor> cbbProfessores;

    @FXML
    private Button editButton;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtNome;

    @FXML
    void onEditButton(ActionEvent event) {
        Integer id = cbbProfessores.getSelectionModel().getSelectedItem().getId();
        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        Disciplina disciplina = cbbDisciplinas.getSelectionModel().getSelectedItem();
        Professor professor = new Professor(id, nome, matricula, disciplina);
        ProfessorService service = new ProfessorService();
        try {
            service.modificar(professor);
        } catch (SQLException e) {
            e.getMessage();
        }
        txtNome.setText("");
        txtMatricula.setText("");
        cbbDisciplinas.setValue(null);
        cbbProfessores.setValue(null);
        load();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
    }

    public void load() {
        loader.disciplinas(disciplinas, obsDisciplinas, cbbDisciplinas);
        try {
            loader.professores(professores, obsProfessores, cbbProfessores);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ControllerLoaders loader = new ControllerLoaders();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private ObservableList<Disciplina> obsDisciplinas;
    private List<Professor> professores = new ArrayList<>();
    private ObservableList<Professor> obsProfessores;

}
