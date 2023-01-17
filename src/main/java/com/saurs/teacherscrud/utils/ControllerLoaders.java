package com.saurs.teacherscrud.utils;

import com.saurs.teacherscrud.models.Teacher;
import com.saurs.teacherscrud.models.enums.Subject;
import com.saurs.teacherscrud.services.TeacherService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;

import java.sql.SQLException;
import java.util.List;

// Métodos usados nos controllers para popular as combobox
public class ControllerLoaders {

    public void disciplinas(List disciplinas, ObservableList obsDisciplinas, ComboBox cbbDisciplinas) {
        for(Subject d : Subject.values()) {
            disciplinas.add(d);
        }
        obsDisciplinas = FXCollections.observableArrayList(disciplinas);
        cbbDisciplinas.setItems(obsDisciplinas);
    }

    public void professores(List professores, ObservableList obsProfessores, ComboBox cbbProfessores) throws SQLException {
        TeacherService service = new TeacherService();
        ObservableList<Teacher> lista = service.findAll();

        if (professores != null && !professores.isEmpty()) {
            professores.clear();
        }
        if (obsProfessores != null) {
            obsProfessores.clear();
        }
        for(Teacher p : lista) {
            professores.add(p);
        }
        obsProfessores = FXCollections.observableArrayList(professores);
        cbbProfessores.setItems(obsProfessores);
    }
}
