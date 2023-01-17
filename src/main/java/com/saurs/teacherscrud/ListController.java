package com.saurs.teacherscrud;

import com.saurs.teacherscrud.models.Teacher;
import com.saurs.teacherscrud.models.enums.Subject;
import com.saurs.teacherscrud.services.TeacherService;
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
    private TableColumn<Teacher, Subject> tableColumnSubject;

    @FXML
    private TableColumn<Teacher, Integer> tableColumnId;

    @FXML
    private TableColumn<Teacher, String> tableColumnEmployeeRn;

    @FXML
    private TableColumn<Teacher, String> tableColumnName;

    @FXML
    private TableView<Teacher> tableViewTeachers;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            initializeNodes();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initializeNodes() throws SQLException {
        TeacherService service = new TeacherService();
        ObservableList<Teacher> list = service.findAll();

        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tableColumnName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        tableColumnEmployeeRn.setCellValueFactory(new PropertyValueFactory<>("EmployeeRn"));
        tableColumnSubject.setCellValueFactory(new PropertyValueFactory<>("Subject"));

        tableViewTeachers.setItems(list);
    }
}
