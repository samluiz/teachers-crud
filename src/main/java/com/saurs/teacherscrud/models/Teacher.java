package com.saurs.teacherscrud.models;

import com.saurs.teacherscrud.models.enums.Subject;

// Entidade professor no banco de dados
public class Teacher {

    private Integer id;
    private String name;
    private String employeeRn;
    private Subject subject;

    public Teacher() {
    }

    public Teacher(Integer id, String name, String employeeRn, Subject subject) {
        this.id = id;
        this.name = name;
        this.employeeRn = employeeRn;
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployeeRn() {
        return employeeRn;
    }

    public void setEmployeeRn(String employeeRn) {
        this.employeeRn = employeeRn;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return  "ID: " + id +
                " - Nome: " + name +
                " - Matricula: " + employeeRn;
    }
}
