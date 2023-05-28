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
    private Map<Diciplina,Double> mediaDiciplina = new HashMap<Diciplina,Double>();
    public Estudante(){}
    public Estudante(String nome, String cpf, String email, String curso, String status,
            LinkedList<Diciplina> matriculadas) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.curso = curso;
        this.status = status;
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
    
    public Map<Diciplina, Double> getMediaDiciplina() {
        return mediaDiciplina;
    }
    public void setMediaDiciplina(Diciplina diciplina, double media) {
        mediaDiciplina.put(diciplina, media);
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
        return "Nome Aluno: " + this.nome + " Curso: " + this.curso + " Status: " + this.status;
    }
    public Map<Diciplina, List<Avaliacao>> getNotaDiciplina() {
        return notaDiciplina;
    }

    public String exibirNotasDiciplina(Diciplina diciplina){
        String string = "";
        string += "Nome Diciplina: " + diciplina.getNome() + " Notas: ";
        for(int i = 0; i < notaDiciplina.get(diciplina).size();i++){
            string += notaDiciplina.get(diciplina).get(i);
        }
        return string;
    }

    public String toStringComNotas(){
        String string = "";
        string += "Nome Aluno: " + this.nome + " CPF: " + this.cpf +  " Curso: " + this.curso + " Status: " + this.status + "\n";
        for(int i = 0; i < notaDiciplina.size();i++){
           string += exibirNotasDiciplina(matriculadas.get(i));
        }
        return string;
    }
}
