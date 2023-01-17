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

public class EditController implements Initializable {

    @FXML
    private ComboBox<Subject> cbbDisciplinas;

    @FXML
    private ComboBox<Teacher> cbbProfessores;

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
        Subject subject = cbbDisciplinas.getSelectionModel().getSelectedItem();
        Teacher teacher = new Teacher(id, nome, matricula, subject);
        TeacherService service = new TeacherService();
        try {
            service.update(teacher);
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
        loader.disciplinas(subjects, obsSubjects, cbbDisciplinas);
        try {
            loader.professores(professores, obsProfessores, cbbProfessores);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ControllerLoaders loader = new ControllerLoaders();
    private List<Subject> subjects = new ArrayList<>();
    private ObservableList<Subject> obsSubjects;
    private List<Teacher> professores = new ArrayList<>();
    private ObservableList<Teacher> obsProfessores;

}
