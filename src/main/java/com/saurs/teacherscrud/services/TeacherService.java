package com.saurs.teacherscrud.services;

import com.saurs.teacherscrud.daos.TeacherDao;
import com.saurs.teacherscrud.models.Teacher;
import com.saurs.teacherscrud.daos.DaoFactory;
import javafx.collections.ObservableList;

import java.sql.SQLException;


// Service do professor que abstrai os métodos implementados no DAO
public class TeacherService {
    private TeacherDao dao;

    {
        try {
            dao = DaoFactory.novaProfessorDao();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ObservableList<Teacher> findAll() throws SQLException {
        return dao.read();
    }

    public void insert(Teacher teacher) throws SQLException {
        dao.create(teacher);
    }

    public void update(Teacher teacher) throws SQLException {
        dao.update(teacher);
    }

    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
