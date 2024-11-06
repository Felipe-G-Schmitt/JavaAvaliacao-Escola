import java.util.ArrayList;

public class Aluno {
    Number Id;
    String Nome;
    String DataNascimento;
    String CPF;
    Number IdCurso;

    static ArrayList<Aluno> alunos = new ArrayList<Aluno>();

    public Aluno(Number id, String nome, String dataNascimento, String cpf, Number idCurso) {
        Id = id;
        Nome = nome;
        DataNascimento = dataNascimento;
        CPF = cpf;
        IdCurso = idCurso;

        alunos.add(this);
    }

    // Verificar se o id ja existe
    public static boolean idExiste(Number id) {
        for (Aluno aluno : alunos) {
            if (aluno.Id.equals(id)) {
                return true; 
            }
        }
        return false;
    }

    // Validar CPF do aluno
    public static boolean validarCPF(String cpf) {
        if (cpf.length() != 11) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "ID: " + this.Id + " Nome: " + this.Nome + " Data de Nascimento: " + this.DataNascimento + " CPF: " + this.CPF + " ID Curso: " + this.IdCurso;
    }
}
