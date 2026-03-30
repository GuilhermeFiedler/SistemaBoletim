package instituicaoEnsino.service;

import instituicaoEnsino.dao.aluno.AlunoDAO;
import instituicaoEnsino.dao.aluno.MatriculaDAO;
import instituicaoEnsino.dao.aluno.NotaDAO;
import instituicaoEnsino.dominio.Disciplinas;
import instituicaoEnsino.dominio.aluno.Aluno;
import instituicaoEnsino.dominio.aluno.Matricula;
import instituicaoEnsino.dominio.aluno.Nota;

import java.util.List;

public class SistemaAcademicoService {

    private AlunoDAO alunoDAO;
    private MatriculaDAO matriculaDAO;
    private NotaDAO notaDAO;

    public SistemaAcademicoService() {
        this.alunoDAO = new AlunoDAO();
        this.matriculaDAO = new MatriculaDAO();
        this.notaDAO = new NotaDAO();
    }

    public void cadastrarAluno(String nome) {
        Aluno aluno = new Aluno(0, nome);
        alunoDAO.salvar(aluno);
    }

    public void matricularAluno(int alunoId, Disciplinas disciplina) {
        Aluno aluno = alunoDAO.buscarPorId(alunoId);
        Matricula matricula = new Matricula(aluno, disciplina);
        matriculaDAO.salvar(matricula);
    }

    public void lancarNota(int alunoId, Disciplinas disciplina,
                           String tipo, double valor, double peso) {

        int matriculaId = matriculaDAO.buscarIdMatricula(alunoId, disciplina);
        Nota nota = new Nota(tipo, valor, peso);
        notaDAO.salvar(matriculaId, nota);
    }

    public List<Aluno> listarAlunos() {
        return alunoDAO.listar();
    }

    public Aluno buscarAluno(int alunoId) {
        return alunoDAO.buscarPorId(alunoId);
    }

    public List<Nota> buscarNotas(int alunoId, Disciplinas disciplina) {
        int matriculaId = matriculaDAO.buscarIdMatricula(alunoId, disciplina);
        return notaDAO.listarPorMatricula(matriculaId);
    }
}