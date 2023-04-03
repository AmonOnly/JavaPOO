package dados;

import java.util.LinkedList;

public class Diciplina {
    private String nome;
    private int idDiciplina;
    private LinkedList<Estudante> Alunos;
    
    public Diciplina(String nome, int idDiciplina, LinkedList<Estudante> alunos) {
        this.nome = nome;
        this.idDiciplina = idDiciplina;
        Alunos = alunos;
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
    public LinkedList<Estudante> getAlunos() {
        return Alunos;
    }
    public void setAlunos(LinkedList<Estudante> alunos) {
        Alunos = alunos;
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

    
}
