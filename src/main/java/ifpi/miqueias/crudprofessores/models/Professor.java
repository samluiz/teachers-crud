package ifpi.miqueias.crudprofessores.models;

import ifpi.miqueias.crudprofessores.models.enums.Disciplina;

// Entidade professor no banco de dados
public class Professor {

    private Integer id;
    private String nome;
    private String matricula;
    private Disciplina disciplina;

    public Professor() {
    }

    public Professor(Integer id, String nome, String matricula, Disciplina disciplina) {
        this.id = id;
        this.nome = nome;
        this.matricula = matricula;
        this.disciplina = disciplina;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return  "ID: " + id +
                " - Nome: " + nome +
                " - Matricula: " + matricula;
    }
}
