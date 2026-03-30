package instituicaoEnsino.dominio.aluno;

import instituicaoEnsino.dominio.Disciplinas;

import java.util.List;

import java.util.ArrayList;

public class Matricula {

    private Aluno aluno;
    private Disciplinas disciplina;

    public Matricula(Aluno aluno, Disciplinas disciplina) {
        this.aluno = aluno;
        this.disciplina = disciplina;
    }

    public Aluno getAluno() { return aluno; }

    public Disciplinas getDisciplina() { return disciplina; }

}
