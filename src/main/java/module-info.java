module ifpi.miqueias.crudprofessores {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.ikonli.javafx;

    opens com.saurs.teacherscrud to javafx.fxml;
    opens com.saurs.teacherscrud.models to javafx.base;
    exports com.saurs.teacherscrud;
}