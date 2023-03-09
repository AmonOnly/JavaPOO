package PR2_2_Dados;

public class Veterinario {
    private String nome;
    private double salario;
    private Endereco endereco;
    private Animais[] animais = new Animais[50];
    private int quantidadeAnimais = 0;
    public Veterinario(){

    }
    
    public String getnome(){
        return this.nome;
    }
    public void setnome(String nome){
        this.nome = nome;
    }
    public double getsalario(){
        return this.salario;
    }
    public void setsalario(double salario){
        this.salario = salario;
    }
    public Endereco getendereco(){
        return this.endereco;
    }
    public void setendereco(Endereco endereco){
        this.endereco = endereco;
    }
    public Animais[] getanimais(){
        return this.animais;
    }
    public void setanimais(Animais a){
        if(this.quantidadeAnimais<50){
            animais[this.quantidadeAnimais] = a;
            this.quantidadeAnimais++;
        }
    }
    public String toString(){
        String veterinarioString = "";
        veterinarioString += "Nome: "+this.nome+"\nSalário: "+this.salario;
        if(this.endereco != null)
            veterinarioString += "\nEndereço: "+this.endereco.toString();
        return veterinarioString;
    }
    public int getQuatidadeAnimais(){
        return this.quantidadeAnimais;
    }
    public void setQuantidadeAnimais(int quantidadeAnimais){
        this.quantidadeAnimais = quantidadeAnimais;
    }

}