package negocios;
import dados.*;

public class Zoologico {
    private Animal[] animais = new Animal[100];
    private Viveiro[] viveiros = new Viveiro[100];
    private int quantidadeAnimais = 0;
    private int quantidadeViveiros = 0;
    
    public Zoologico(){}

    public int getQuantidadeAnimais() {
        return quantidadeAnimais;
    }
    public void setQuantidadeAnimais(int quantidadeAnimais) {
        this.quantidadeAnimais = quantidadeAnimais;
    }
    public int getQuantidadeViveiros() {
        return quantidadeViveiros;
    }
    public void setQuantidadeViveiros(int quantidadeViveiros) {
        this.quantidadeViveiros = quantidadeViveiros;
    }
    public Animal[] getAnimais() {
        return animais;
    }
    public void setAnimais(Animal[] animais) {
        this.animais = animais;
    }
    public Viveiro[] getViveiros() {
        return viveiros;
    }
    public void setViveiros(Viveiro[] viveiros) {
        this.viveiros = viveiros;
    }

    public void cadastrarViveiro(Viveiro viveiro){
        if(this.quantidadeViveiros < 100){
            viveiros[quantidadeViveiros] = viveiro;
            quantidadeViveiros+=1;
        }
    }

    public void cadastrarAnimais(Animal animal){
        if(this.quantidadeAnimais < 100){
            animais[quantidadeAnimais] = animal;
            quantidadeAnimais+=1;
        }
    }

    public boolean alocarAnimal( Animal animal, Viveiro viveiro){
        if(viveiro.adicionarAnimal(animal)){
            return true;
        }
        return false;
    }

    public Aquario[] getSoAquario(){
        Aquario[] retorno = new Aquario[100];
        int k = 0;

        for(int i = 0; i < quantidadeViveiros;i++){
            if(this.viveiros[i] instanceof Aquario){
                Aquario aux = (Aquario)this.viveiros[i];
                retorno[k] = aux;
                k+=1;
            }
        }
        return retorno;
    }

    public Viveiro[] getSoViveiros(){
        Viveiro[] retorno = new Viveiro[100];
        int k = 0;

        for(int i = 0; i < quantidadeViveiros;i++){
            if(!(this.viveiros[i] instanceof Aquario)){
                retorno[k] = this.viveiros[i];
                k+=1;
            }
        }
        return retorno;
    }    
    
}
