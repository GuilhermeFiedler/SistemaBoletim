package instituicaoEnsino.dominio.aluno;

import java.util.List;
import java.util.ArrayList;


public class Aluno {

    private int id;
    private String nome;

    public Aluno(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public int getId() { return id; }

    public String getNome() { return nome; }

}
