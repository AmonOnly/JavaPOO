package dados;

import java.util.*;

public class Diciplina {
    private String nome;
    private int idDiciplina;
    private Professor professor;
    private List<Estudante> alunos = new LinkedList<Estudante>();
    public Diciplina(){}
    public Diciplina(String nome, int idDiciplina, Professor professor, LinkedList<Estudante> alunos) {
        this.nome = nome;
        this.idDiciplina = idDiciplina;
        this.professor = professor;
        this.alunos = alunos;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdDiciplina() {
        return idDiciplina;
    }
    public void setIdDiciplina(int idDiciplina) {
        this.idDiciplina = idDiciplina;
    }
    public List<Estudante> getAlunos() {
        return alunos;
    }
    public void setAlunos(Estudante alunos) {
        this.alunos.add(alunos);
    }
    public void adicionarAluno(Estudante estudante){
        this.alunos.add(estudante);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Diciplina other = (Diciplina) obj;
        if (idDiciplina != other.idDiciplina)
            return false;
        return true;
    }
    public Professor getProfessor() {
        return professor;
    }
    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    @Override
    public String toString() {
        String diciplicaString = "";
        diciplicaString += "Materia: " + this.nome + "\n" + 
        "Professor: " + this.professor.getNome() + "\n";
        for(int i = 0; i < alunos.size();i++){
            diciplicaString += alunos.get(i).toString() + "\n";
        }
        return diciplicaString;

    }
}
