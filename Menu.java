import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        final String url = "jdbc:mysql://localhost:3306/school";
        final String user = "root";
        final String password = "";
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
                        
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO Professor "
                            + "(Id, Nome, Departamento) VALUES "
                            + "('"+id+"', '"+nome+"', '"+departamento+"')");
                        if(!sql) {
                            System.out.println("");
                        }
                        con.close();
                    }
                } catch (Exception e) {
                    System.out.println("");
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
                        
                        Connection con = DriverManager.getConnection(url, user, password);
                        Statement stm = con.createStatement();
                        boolean sql = stm.execute("INSERT INTO Curso "
                            + "(Id, nome, cargaHoraria, idProfessor) VALUES "
                            + "('"+id+"','"+nome+"', '"+cargaHoraria+"', '"+idProfessor+"')");
                        if(!sql) {
                            System.out.println("");
                        }
                        con.close();
                    }
                } catch (Exception e) {
                    System.out.println("");
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

                            Connection con = DriverManager.getConnection(url, user, password);
                            Statement stm = con.createStatement();
                            boolean sql = stm.execute("INSERT INTO Aluno "
                                + "(Id, Nome, DataNascimento, CPF, IdCurso) VALUES "
                                + "('"+id+"', '"+nome+"', '"+dataNascimento+"', '"+cpf+"', '"+idCurso+"')");
                            if(!sql) {
                                System.out.println("");
                            }
                            con.close();
                        }
                    }
                } catch (Exception e) {
                    System.out.println("");
                }
                break;

                case 4:
                System.out.println("\n Listar Professores");
                System.out.println("==================");
                try {
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement stm = con.createStatement();
                    ResultSet sql = stm.executeQuery("SELECT * FROM Professor;");
                    while(sql.next()) {
                        System.out.println(new Professor(
                            sql.getInt("Id"),
                            sql.getString("Nome"),
                            sql.getString("Departamento")
                        ));
                    }
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

                case 5:
                System.out.println("\n Listar Cursos");
                System.out.println("==================");
                try {
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement stm = con.createStatement();
                    ResultSet sql = stm.executeQuery("SELECT * FROM Curso;");
                    while(sql.next()) {
                        System.out.println(new Curso(
                            sql.getInt("Id"),
                            sql.getString("Nome"),
                            sql.getInt("CargaHoraria"), 
                            sql.getInt("IdProfessor")
                        ));
                    }
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
                break;

                case 6:
                System.out.println("\n Listar Alunos");
                System.out.println("==================");
                try {
                    Connection con = DriverManager.getConnection(url, user, password);
                    Statement stm = con.createStatement();
                    ResultSet sql = stm.executeQuery("SELECT * FROM Aluno;");
                    while(sql.next()) {
                        System.out.println(new Aluno(
                            sql.getInt("Id"),
                            sql.getString("Nome"),
                            sql.getString("DataNascimento"), 
                            sql.getString("CPF"),
                            sql.getInt("IdCurso")
                        ));
                    }
                    con.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
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
