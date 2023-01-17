module ifpi.miqueias.crudprofessores {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.kordamp.ikonli.javafx;

    opens ifpi.miqueias.crudprofessores to javafx.fxml;
    opens ifpi.miqueias.crudprofessores.models to javafx.base;
    exports ifpi.miqueias.crudprofessores;
}