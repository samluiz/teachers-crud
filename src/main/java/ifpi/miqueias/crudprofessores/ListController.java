package ifpi.miqueias.crudprofessores;

import ifpi.miqueias.crudprofessores.models.Professor;
import ifpi.miqueias.crudprofessores.models.enums.Disciplina;
import ifpi.miqueias.crudprofessores.services.ProfessorService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ListController implements Initializable {

    @FXML
    private TableColumn<Professor, Disciplina> TableColumnDisciplina;

    @FXML
    private TableColumn<Professor, Integer> TableColumnId;

    @FXML
    private TableColumn<Professor, String> TableColumnMatricula;

    @FXML
    private TableColumn<Professor, String> TableColumnNome;

    @FXML
    private TableView<Professor> TableViewProfessores;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            fazerTabela();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void fazerTabela() throws SQLException {
        ProfessorService service = new ProfessorService();
        ObservableList<Professor> lista = service.buscarTodos();

        TableColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        TableColumnNome.setCellValueFactory(new PropertyValueFactory<>("Nome"));
        TableColumnMatricula.setCellValueFactory(new PropertyValueFactory<>("Matricula"));
        TableColumnDisciplina.setCellValueFactory(new PropertyValueFactory<>("Disciplina"));

        TableViewProfessores.setItems(lista);
    }
}
