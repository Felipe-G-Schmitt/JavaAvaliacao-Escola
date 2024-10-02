import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        System.out.println("Escola");
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("1 - Cadastrar Professor");
            System.out.println("2 - Cadastrar Curso");
            System.out.println("3 - Cadastrar Aluno");
            System.out.println("4 - Listar Professores");
            System.out.println("5 - Listar Cursos");
            System.out.println("6 - Listar Alunos");
            System.out.println("7 - Sair");
            System.out.print("Opção: ");
            
            try {
                opcao = scanner.nextInt();
            } catch (Exception e) {
                opcao = 0; // Se digitar algo que não seja um número, a opção será 0
            }

            switch (opcao) {
                case 1:
                try {
                    System.out.println("\n Cadastrar Professor");
                    System.out.print("Id do Professor: ");
                    Number id = scanner.nextInt(); // Le o id do professor
                    scanner.nextLine(); // Come a linha do \n

                    // Verifica se o ID já existe
                    if (Professor.idExiste(id)) {
                        System.out.println("Erro: ID do professor já existe. Tente outro.");
                        System.out.println("\n");
                    } else {
                        System.out.print("Nome do Professor: ");
                        String nome = scanner.nextLine();
                        System.out.print("Departamento do Professor: ");
                        String departamento = scanner.nextLine();
                        new Professor(id, nome, departamento); // Cria um novo objeto Professor
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao cadastrar o Professor");
                }
                break;

                case 2:
                try {
                    System.out.println("\n Cadastrar Curso");
                    System.out.print("Id do Curso: ");
                    Number id = scanner.nextInt(); // Lê o ID do curso
                    scanner.nextLine(); // Come a linha do \n

                    // Verifica se o ID já existe
                    if (Curso.idExiste(id)) {
                        System.out.println("Erro: ID do curso já existe. Tente outro.");
                        System.out.println("\n");
                    } else {
                        System.out.print("Nome do Curso: ");
                        String nome = scanner.nextLine();
                        System.out.print("Carga Horária do Curso: ");
                        Number cargaHoraria = scanner.nextInt();
                        System.out.print("Id do Professor responsável: ");
                        Number idProfessor = scanner.nextInt();
                        new Curso(id, nome, cargaHoraria, idProfessor); // Cria um novo objeto Curso
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao cadastrar o Curso");
                }
                break;

                case 3:
                try {
                    System.out.println("\n Cadastrar Aluno");
                    System.out.print("Id do Aluno: ");
                    Number id = scanner.nextInt(); // Lê o ID do aluno
                    scanner.nextLine(); // Come a linha do \n

                    // Verifica se o ID já existe
                    if (Aluno.idExiste(id)) {
                        System.out.println("Erro: ID do aluno já existe. Tente outro.");
                        System.out.println("\n");
                    } else {
                        System.out.print("Nome do Aluno: ");
                        String nome = scanner.nextLine();
                        System.out.print("Data de Nascimento do Aluno: ");
                        String dataNascimento = scanner.nextLine();
                        System.out.print("CPF do Aluno: ");
                        String cpf = scanner.nextLine();

                        // Valida o CPF do aluno
                        if (!Aluno.validarCPF(cpf)) {
                            System.out.println("Erro: CPF inválido. Tente outro.");
                            System.out.println("\n");
                            break;
                        } else {
                            System.out.print("Id do Curso do Aluno: ");
                            Number idCurso = scanner.nextInt();
                            new Aluno(id, nome, dataNascimento, cpf, idCurso); // Cria um novo objeto Aluno
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Erro ao cadastrar o Aluno");
                }
                break;

                case 4:
                System.out.println("\n Listar Professores");
                System.out.println("==================");
                Professor.professores.forEach(professor -> {
                    System.out.println("\nId: " + professor.Id + " \nNome: " + professor.Nome + " \nDepartamento: " + professor.Departamento);
                });
                System.out.println("\n ==================\n");
                break;

                case 5:
                System.out.println("\n Listar Cursos");
                System.out.println("==================");
                Curso.cursos.forEach(curso -> {
                    System.out.println("\nId: " + curso.Id + " \nNome: " + curso.Nome + " \nCarga Horária: " + curso.CargaHoraria + " \nId Professor: " + curso.IdProfessor);
                });
                System.out.println("\n ==================\n");
                break;

                case 6:
                System.out.println("\n Listar Alunos");
                System.out.println("==================");
                Aluno.alunos.forEach(aluno -> {
                    System.out.println("\nId: " + aluno.Id + " \nNome: " + aluno.Nome + " \nData de Nascimento: " + aluno.DataNascimento + " \nCPF: " + aluno.CPF + " \nId Curso: " + aluno.IdCurso);
                });
                System.out.println("\n ==================\n");
                break;

                case 7:
                    System.out.println("\nSaindo...");
                    break;

                default:
                    System.out.println("\nOpção inválida");
                    break;
            }
        } while (opcao != 7);
        scanner.close();
    }
}
