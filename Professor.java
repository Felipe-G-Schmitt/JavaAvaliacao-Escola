import java.util.ArrayList;

public class Professor {
    Number Id;
    String Nome;
    String Departamento;

    static ArrayList<Professor> professores = new ArrayList<Professor>();

    public Professor(Number id, String nome, String departamento) {
        Id = id;
        Nome = nome;
        Departamento = departamento;

        professores.add(this);
    }

    // Verificar se o id ja existe
    public static boolean idExiste(Number id) {
        for (Professor professor : professores) {
            if (professor.Id.equals(id)) {
                return true; 
            }
        }
        return false;
    }
}