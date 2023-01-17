package ifpi.miqueias.crudprofessores;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button addButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editButton;

    @FXML
    private Button listButton;

    @FXML
    void onAdd(ActionEvent event) throws IOException {
        clickShow(event, "Add.fxml", "Adicionar Professor");
    }

    @FXML
    void onDeleteButton(ActionEvent event) throws IOException {
        clickShow(event, "Delete.fxml", "Deletar professor");    }

    @FXML
    void onEditButton(ActionEvent event) throws IOException {
        clickShow(event, "Edit.fxml", "Editar professores");    }

    @FXML
    void onListButton(ActionEvent event) throws IOException {
        clickShow(event, "List.fxml", "Ver professores");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    private void clickShow(ActionEvent event, String path, String title) throws IOException {
        Stage stage = new Stage();
        URL fxmlLocation = getClass().getResource(path);
        FXMLLoader loader = new FXMLLoader(fxmlLocation);
        Parent root = loader.load();
        stage.setScene(new Scene(root));
        stage.setTitle(title);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(
                ((Node)event.getSource()).getScene().getWindow());
        stage.show();
    }
}