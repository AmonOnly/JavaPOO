package dados;

import java.util.Random;

public class Sorteador {
   private Pessoa[] pessoas = new Pessoa[10];
   private int quantidadePessoas = 0;

   public Sorteador(){};

   public Sorteador(Pessoa[] pessoas, int quantidadePessoas) {
    this.pessoas = pessoas;
    this.quantidadePessoas = quantidadePessoas;
}
public void setQuantidadePessoas(int quantidadePessoas) {
       this.quantidadePessoas = quantidadePessoas;
   }
   public int getQuantidadePessoas() {
       return quantidadePessoas;
   }
   public void setPessoas(Pessoa pessoa) {
    if(this.quantidadePessoas < 10){
        this.pessoas[quantidadePessoas] = pessoa;
        this.quantidadePessoas +=1; 
    }
   }
   public Pessoa[] getPessoas() {
       return pessoas;
   }

   public Pessoa SorteadorPessoas(){
    Random random = new Random();
    int numeroSorteado = random.nextInt(0 + this.quantidadePessoas);
    Pessoa pessoaSorteada = pessoas[numeroSorteado];
    removerPessoa(numeroSorteado);
    return pessoaSorteada;
   }

   public void removerPessoa(int x){
    for(int i = x; i < this.quantidadePessoas;i++){
        if(this.pessoas[i+1] != null){
            this.pessoas[i] = pessoas[i+1];
        }
    }
    quantidadePessoas-=1;
   }
   @Override
   public String toString() {
        String pessoaString ="";
       for(int i=0;i<this.quantidadePessoas;i+=1){
        pessoaString += "Pessoas "+ i + " " + this.pessoas[i].toString() + "\n"; 
       }
       return pessoaString;
   }
}
