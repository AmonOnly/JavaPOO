package dados;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Estudante {
    private String nome,cpf,email,curso,status;
    private int idAluno;
    private List<Diciplina> matriculadas = new LinkedList<Diciplina>();
    private Map<Diciplina,List<Avaliacao>> notaDiciplina = new HashMap<Diciplina,List<Avaliacao>>();
    public Estudante(String nome, String cpf, String email, String curso, String status, int idAluno,
            LinkedList<Diciplina> matriculadas) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.curso = curso;
        this.status = status;
        this.idAluno = idAluno;
        this.matriculadas = matriculadas;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCurso() {
        return curso;
    }
    public void setCurso(String curso) {
        this.curso = curso;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getIdAluno() {
        return idAluno;
    }
    public void setIdAluno(int idAluno) {
        this.idAluno = idAluno;
    }
    public List<Diciplina> getMatriculadas() {
        return matriculadas;
    }
    public void adicionarNotas(Diciplina diciplina, Avaliacao avaliacao){
        if(matriculadas.contains(diciplina)){
            notaDiciplina.get(diciplina).add(avaliacao);
        }
    }
    public void matriculas(Diciplina diciplina){
        List<Avaliacao> notinhas = new LinkedList<Avaliacao>();
        this.matriculadas.add(diciplina);
        this.notaDiciplina.put(diciplina, notinhas);
        };
    public double mediaNota(Diciplina diciplina){
        double media = 0;
        for(int i = 0;i < this.notaDiciplina.get(diciplina).size();i++){
            media += (this.notaDiciplina.get(diciplina).get(i).getNota() * this.notaDiciplina.get(diciplina).get(i).getPeso())/10;
        }
        return media;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Estudante other = (Estudante) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Nome Aluno: " + this.nome + " Curso: " + this.curso;
    }
}
