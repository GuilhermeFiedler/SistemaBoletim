package instituicaoEnsino.teste;

import instituicaoEnsino.config.DatabaseInitializer;
import instituicaoEnsino.dominio.Menu;
import instituicaoEnsino.service.SistemaAcademicoService;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        DatabaseInitializer.init();

        Scanner scanner = new Scanner(System.in);
        SistemaAcademicoService service = new SistemaAcademicoService();
        Menu menu = new Menu(scanner, service);

        int opcao;

        do {
            System.out.println("\n==============================");
            System.out.println(" SISTEMA ACADÊMICO ");
            System.out.println("==============================");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Matricular aluno");
            System.out.println("3 - Lançar nota");
            System.out.println("4 - Listar alunos");
            System.out.println("5 - Emitir boletim");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = scanner.nextInt();

            switch (opcao) {

                case 1:
                    menu.cadastrarAluno();
                    break;

                case 2:
                    menu.matricularAluno();
                    break;

                case 3:
                    menu.lancarNota();
                    break;

                case 4:
                    menu.listarAlunos();
                    break;

                case 5:
                    menu.emitirBoletim();
                    break;

            }

        } while (opcao != 0);
    }
}

