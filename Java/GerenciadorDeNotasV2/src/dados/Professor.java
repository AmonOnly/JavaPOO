package dados;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;

public class Professor {
    private String nome,cpf,login,senha;
    private int telefone;
    private List<Diciplina> diciplinas = new LinkedList<Diciplina>();
    public Professor(){}
    public Professor(String nome, String cpf, String login, String senha, int telefone,
            ArrayList<Diciplina> diciplinas) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
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
    public String getLogin() {
        return login;
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public int getTelefone() {
        return telefone;
    }
    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
    public List<Diciplina> getDiciplinas() {
        return diciplinas;
    }

    public void setDiciplinas(Diciplina diciplina){
        this.diciplinas.add(diciplina);
    }
    @Override
    public String toString() {
        return "Nome do professor: " + this.nome + "\n";
    }
    
}
