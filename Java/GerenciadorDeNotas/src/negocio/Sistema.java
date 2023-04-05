package negocio;
import java.util.LinkedList;
import java.util.List;

import dados.*;

public class Sistema {
    private List<Professor> professores = new LinkedList<Professor>();
    private List<Diciplina> diciplinas = new LinkedList<Diciplina>();
    private List<Estudante> estudantes = new LinkedList<Estudante>();
    public List<Professor> getProfessores() {
        return professores;
    }
    public void setProfessores(Professor professores) {
        this.professores.add(professores);
    }
    public List<Diciplina> getDiciplinas() {
        return diciplinas;
    }
    public void setDiciplinas(Diciplina diciplinas) {
        this.diciplinas.add(diciplinas);
    }
    public List<Estudante> getEstudantes() {
        return estudantes;
    }
    public void setEstudantes(Estudante estudantes) {
        this.estudantes.add(estudantes);
    }

    public void matricularEstudante(Estudante estudante, Diciplina diciplina, Professor professor){
        estudante.matriculas(diciplina);
        diciplina.adicionarAluno(estudante);
        professor.setDiciplinas(diciplina);
    }
    public void adicionarNotas(Estudante estudante, Diciplina diciplina, Avaliacao avaliacao){
        estudante.adicionarNotas(diciplina, avaliacao);
    }

    public void adicionarAluno(Estudante estudante){
        estudantes.add(estudante);
    }
    public void adicionarDiciplina(Diciplina diciplina){
        diciplinas.add(diciplina);
    }
    public void adicionarProfessor(Professor professor){
        professores.add(professor);
    }
    public void removerDiciplina(Diciplina diciplina){
        for(int i = 0; i < diciplina.getAlunos().size();i++){
            diciplina.getAlunos().get(i).getMatriculadas().remove(diciplina);
        }
        diciplina.getProfessor().getDiciplinas().remove(diciplina);
        diciplinas.remove(diciplina);
    }
    public void removerAlunotodas(Estudante aluno){
        for(int i = 0; i < aluno.getMatriculadas().size();i++){
            aluno.getMatriculadas().get(i).getAlunos().remove(aluno);
        }
        estudantes.remove(aluno);
    }
    public void removerAlunoUmm(Estudante aluno, Diciplina diciplina){
        aluno.getMatriculadas().remove(diciplina);
        diciplina.getAlunos().remove(aluno);
    }
}
