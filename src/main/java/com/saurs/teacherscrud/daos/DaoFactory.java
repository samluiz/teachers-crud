package com.saurs.teacherscrud.daos;

import com.saurs.teacherscrud.daos.impl.TeacherDaoImpl;
import com.saurs.teacherscrud.db.Db;

import java.sql.SQLException;

public class DaoFactory {

    public static TeacherDao novaProfessorDao() throws SQLException {
        return new TeacherDaoImpl(Db.connect());
    }
}
