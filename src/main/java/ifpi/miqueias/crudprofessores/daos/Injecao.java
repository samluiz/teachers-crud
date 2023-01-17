package ifpi.miqueias.crudprofessores.daos;

import ifpi.miqueias.crudprofessores.daos.impl.ProfessorDaoImpl;
import ifpi.miqueias.crudprofessores.db.Db;

import java.sql.SQLException;

public class Injecao {

    public static ProfessorDao novaProfessorDao() throws SQLException {
        return new ProfessorDaoImpl(Db.conectar());
    }
}
