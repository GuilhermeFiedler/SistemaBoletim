package instituicaoEnsino.dominio;

import instituicaoEnsino.dominio.aluno.Aluno;
import instituicaoEnsino.dominio.aluno.Nota;
import instituicaoEnsino.exception.SistemaAcademicoException;
import instituicaoEnsino.service.SistemaAcademicoService;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private SistemaAcademicoService service;

    public Menu(Scanner scanner, SistemaAcademicoService service) {
        this.scanner = scanner;
        this.service = service;
    }

    public void cadastrarAluno() {
        scanner.nextLine();
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        service.cadastrarAluno(nome);
        System.out.println("Aluno cadastrado.");
    }

    public void matricularAluno() {
        System.out.print("ID do aluno: ");
        int alunoId = scanner.nextInt();

        Disciplinas disciplina = escolherDisciplina();

        service.matricularAluno(alunoId, disciplina);
        System.out.println("Aluno matriculado.");
    }

    public void lancarNota() {
        System.out.print("ID do aluno: ");
        int alunoId = scanner.nextInt();

        Disciplinas disciplina = escolherDisciplina();
        scanner.nextLine();

        System.out.print("Tipo da nota: ");
        String tipo = scanner.nextLine();

        System.out.print("Valor: ");
        double valor = scanner.nextDouble();

        System.out.print("Peso: ");
        double peso = scanner.nextDouble();

        service.lancarNota(alunoId, disciplina, tipo, valor, peso);
        System.out.println("Nota adicionada.");
    }

    public void listarAlunos() {
        for (Aluno a : service.listarAlunos()) {
            System.out.println(a.getId() + " - " + a.getNome());
        }
    }

    public void emitirBoletim() {
        System.out.print("ID do aluno: ");
        int alunoId = scanner.nextInt();

        Aluno aluno = service.buscarAluno(alunoId);

        System.out.println("\n==============================");
        System.out.println(" BOLETIM ");
        System.out.println("==============================");
        System.out.println("Aluno: " + aluno.getNome());

        for (Disciplinas d : Disciplinas.values()) {
            try {
                List<Nota> notas = service.buscarNotas(alunoId, d);
                if (notas.isEmpty()) continue;

                double soma = 0;
                double pesos = 0;

                System.out.println("\nDisciplina: " + d);
                for (Nota n : notas) {
                    System.out.println(" - " + n.getTipo() + ": " + n.getValor());
                    soma += n.getValor() * n.getPeso();
                    pesos += n.getPeso();
                }

                double media = soma / pesos;
                System.out.printf("Média: %.2f%n", media);

            } catch (SistemaAcademicoException e) {

            }
        }
    }

    private Disciplinas escolherDisciplina() {
        System.out.println("Disciplina:");
        for (Disciplinas d : Disciplinas.values()) {
            System.out.println(d.ordinal() + " - " + d);
        }
        int escolha = scanner.nextInt();
        return Disciplinas.values()[escolha];
    }
}
