package com.saurs.teacherscrud;

import com.saurs.teacherscrud.models.Teacher;
import com.saurs.teacherscrud.utils.ControllerLoaders;
import com.saurs.teacherscrud.services.TeacherService;
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
    private ComboBox<Teacher> cbbProfessores;

    @FXML
    private Button deleteButton;

    @FXML
    void onDeleteButton(ActionEvent event) {
        Integer id = cbbProfessores.getSelectionModel().getSelectedItem().getId();
        TeacherService service = new TeacherService();
        try {
            service.delete(id);
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
    private List<Teacher> professores = new ArrayList<>();
    private ObservableList<Teacher> obsProfessores;
}
