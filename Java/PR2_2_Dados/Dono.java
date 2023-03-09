package PR2_2_Dados;

public class Dono {
    private String nome,cpf;
    private Endereco endereco;
    public Dono(){

    }
    public String getnome(){
        return this.nome;
    }
    public void setnome(String nome){
        this.nome = nome;
    }
    public String getcpf(){
        return this.cpf;
    }
    public void setcpf(String cpf){
        this.cpf = cpf;
    }
    public Endereco getendereco(){
        return this.endereco;
    }
    public void setendereco(Endereco endereco){
        this.endereco = endereco;
    }
    public String toString(){
        String donoString = "";
        donoString += "Nome: "+this.nome+"\nCpf: "+this.cpf+"\nEndereco"+this.endereco.toString();
        return donoString;
    }
}

