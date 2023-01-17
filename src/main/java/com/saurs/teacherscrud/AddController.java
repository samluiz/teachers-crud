package com.saurs.teacherscrud;

import com.saurs.teacherscrud.models.Teacher;
import com.saurs.teacherscrud.models.enums.Subject;
import com.saurs.teacherscrud.utils.ControllerLoaders;
import com.saurs.teacherscrud.services.TeacherService;
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

public class AddController implements Initializable {

    @FXML
    private ComboBox<Subject> cbbDisciplinas;

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
        Subject subject = cbbDisciplinas.getSelectionModel().getSelectedItem();
        Teacher teacher = new Teacher(null, nome, matricula, subject);
        TeacherService service = new TeacherService();
        try {
            service.insert(teacher);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        txtNome.setText("");
        txtMatricula.setText("");
        cbbDisciplinas.setValue(null);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loader.disciplinas(subjects, obsSubjects, cbbDisciplinas);
    }

    ControllerLoaders loader = new ControllerLoaders();
    private List<Subject> subjects = new ArrayList<>();
    private ObservableList<Subject> obsSubjects;
}
