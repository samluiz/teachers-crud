package com.saurs.teacherscrud.daos.impl;

import com.saurs.teacherscrud.daos.TeacherDao;
import com.saurs.teacherscrud.db.Db;
import com.saurs.teacherscrud.models.Teacher;
import com.saurs.teacherscrud.models.enums.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherDaoImpl implements TeacherDao {

    private Connection connection;
    public TeacherDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Teacher teacher) throws SQLException {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(
                    "INSERT INTO teacher " +
                            "(name, employee_rn, subject) " +
                            "VALUES " +
                            "(?, ?, ?);"
            );
            st.setString(1, teacher.getName());
            st.setString(2, teacher.getEmployeeRn());
            st.setString(3, teacher.getSubject().toString());

            int columns = st.executeUpdate();

            if (columns > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    teacher.setId(id);
                }
                Db.closeResultSet(rs);
            }
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public void update(Teacher teacher) throws SQLException {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(
                    "UPDATE teacher " +
                            "SET name = coalesce(NULLIF(?, ''), name), " +
            "employee_rn = coalesce(NULLIF(?, ''), employee_rn), " +
                    "subject = coalesce(NULLIF(?, ''), subject) " +
                            "WHERE id = ?;"
            );
            st.setString(1, teacher.getName());
            st.setString(2, teacher.getEmployeeRn());
            st.setString(3, teacher.getSubject() == null ? null : teacher.getSubject().toString());
            st.setInt(4, teacher.getId());

            st.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            Db.closeStatement(st);
        }
    }

    public void delete(Integer id) throws SQLException {
        PreparedStatement st = null;
        try {
            st = connection.prepareStatement(
                    "DELETE FROM teacher WHERE id = ?;"
            );
            st.setInt(1, id);
            st.executeUpdate();
        } catch (SQLException e) {
            throw new SQLException();
        } finally {
            Db.closeStatement(st);
        }
    }

    @Override
    public ObservableList<Teacher> read() throws SQLException {
        ObservableList<Teacher> teachersList = FXCollections.observableArrayList();
        PreparedStatement st;
        ResultSet rs;
        st = connection.prepareStatement("SELECT * FROM teacher;");
        rs = st.executeQuery();
        Teacher teacher;
        while(rs.next()) {
            teacher = new Teacher(rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("employee_rn"),
                    Subject.valueOf(rs.getString("subject")));
            teachersList.add(teacher);
        }
        Db.closeStatement(st);
        Db.closeResultSet(rs);
        return teachersList;
    }
}
