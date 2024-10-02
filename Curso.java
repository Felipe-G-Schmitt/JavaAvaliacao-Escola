import java.util.ArrayList;

public class Curso {
    Number Id;
    String Nome;
    Number CargaHoraria;
    Number IdProfessor;

    static ArrayList<Curso> cursos = new ArrayList<Curso>();

    public Curso(Number id, String nome, Number cargaHoraria, Number idProfessor) {
        Id = id;
        Nome = nome;
        CargaHoraria = cargaHoraria;
        IdProfessor = idProfessor;

        cursos.add(this);
    }

    // Verificar se o id ja existe
    public static boolean idExiste(Number id) {
        for (Curso curso : cursos) {
            if (curso.Id.equals(id)) {
                return true; 
            }
        }
        return false;
    }
}
