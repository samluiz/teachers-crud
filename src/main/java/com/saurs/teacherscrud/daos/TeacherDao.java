package com.saurs.teacherscrud.daos;

import com.saurs.teacherscrud.models.Teacher;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface TeacherDao {

    void create(Teacher teacher) throws SQLException;
    void update(Teacher teacher) throws SQLException;
    void delete(Integer id) throws SQLException;
    ObservableList<Teacher> read() throws SQLException;
}
