package dados;

import java.util.ArrayList;

public class Professor {
    private String nome,cpf,login,senha;
    private int telefone;
    private ArrayList<Diciplina> diciplinas;
    public Professor(String nome, String cpf, String login, String senha, int telefone,
            ArrayList<Diciplina> diciplinas) {
        this.nome = nome;
        this.cpf = cpf;
        this.login = login;
        this.senha = senha;
        this.telefone = telefone;
        this.diciplinas = diciplinas;
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
    public ArrayList<Diciplina> getDiciplinas() {
        return diciplinas;
    }
    public void setDiciplinas(ArrayList<Diciplina> diciplinas) {
        this.diciplinas = diciplinas;
    }

    
}
