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

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class DeleteController implements Initializable {

    @FXML
    private ComboBox<Professor> cbbProfessores;

    @FXML
    private Button deleteButton;

    @FXML
    void onDeleteButton(ActionEvent event) {
        Integer id = cbbProfessores.getSelectionModel().getSelectedItem().getId();
        ProfessorService service = new ProfessorService();
        try {
            service.remover(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        cbbProfessores.setValue(null);
        load();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
    }

    public void load() {
        try {
            loader.professores(professores, obsProfessores, cbbProfessores);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ControllerLoaders loader = new ControllerLoaders();
    private List<Professor> professores = new ArrayList<>();
    private ObservableList<Professor> obsProfessores;
}
