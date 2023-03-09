package PR2_1_Dados;

public class Grupo {
    private Pessoa[] pessoas = new Pessoa[5];
    private int numeroPessoas = 0;
    public Grupo(){

    }
    public void setPessoa(Pessoa p){
        if(this.numeroPessoas<5){
            pessoas[this.numeroPessoas] = p;
            this.numeroPessoas++;
        }
    }
    public Pessoa[] getPessoas(){
        return pessoas;
    } 
    public void ordena() {
        for(int i =0;i<5;i++){
            for(int in = i;in < 5;in++){
                if(this.pessoas[i].calculaimc() < this.pessoas[in].calculaimc()){
                    Pessoa aux = this.pessoas[in];
                    this.pessoas[in] = this.pessoas[i];
                    this.pessoas[i] = aux;
                }
            }
        }
    }
}
