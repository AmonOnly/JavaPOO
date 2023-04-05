package dados;

import java.util.ArrayList;

public class Diciplina {
    private String nome;
    private int idDiciplina;
    private Professor professor;
    private ArrayList<Estudante> alunos;
    
    public Diciplina(String nome, int idDiciplina, Professor professor, ArrayList<Estudante> alunos) {
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
    public ArrayList<Estudante> getAlunos() {
        return alunos;
    }
    public void setAlunos(ArrayList<Estudante> alunos) {
        this.alunos = alunos;
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
