package dados;

public class Pessoa {
    private String nomePessoa,cpf;

    public Pessoa(){};

    public Pessoa(String nomePessoa, String cpf) {
        this.nomePessoa = nomePessoa;
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Pessoa [nomePessoa=" + nomePessoa + ", cpf=" + cpf + "]";
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

}
