package ifpi.miqueias.crudprofessores;

import ifpi.miqueias.crudprofessores.models.Professor;
import ifpi.miqueias.crudprofessores.models.enums.Disciplina;
import ifpi.miqueias.crudprofessores.services.ProfessorService;
import ifpi.miqueias.crudprofessores.utils.ControllerLoaders;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AddController implements Initializable {

    @FXML
    private ComboBox<Disciplina> cbbDisciplinas;

    @FXML
    private Button insertButton;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtNome;

    @FXML
    void onInsertButton(ActionEvent event) {
        String nome = txtNome.getText();
        String matricula = txtMatricula.getText();
        Disciplina disciplina = cbbDisciplinas.getSelectionModel().getSelectedItem();
        Professor professor = new Professor(null, nome, matricula, disciplina);
        ProfessorService service = new ProfessorService();
        try {
            service.inserir(professor);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        txtNome.setText("");
        txtMatricula.setText("");
        cbbDisciplinas.setValue(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loader.disciplinas(disciplinas, obsDisciplinas, cbbDisciplinas);
    }

    ControllerLoaders loader = new ControllerLoaders();
    private List<Disciplina> disciplinas = new ArrayList<>();
    private ObservableList<Disciplina> obsDisciplinas;
}
