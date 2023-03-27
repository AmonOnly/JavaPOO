package dados;

public class Viveiro {
    protected String nome;
    protected float comprimento,largura;
    protected Animal animais[] = new Animal[100];
    protected int quantidadeAnimaisV = 0;

    public Viveiro(){}

    public Viveiro(String nome, float comprimento, float largura) {
        this.nome = nome;
        this.comprimento = comprimento;
        this.largura = largura;
    }

    public int getQuantidadeAnimaisV() {
        return quantidadeAnimaisV;
    }

    public void setQuantidadeAnimaisV(int quantidadeAnimaisV) {
        this.quantidadeAnimaisV = quantidadeAnimaisV;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float calculaEspaco(){
        return this.largura * this.comprimento;
    }

    public float espacoOcupado() {
        float ocupado = 0;
        for(int i = 0; i < quantidadeAnimaisV; i++ ){
            ocupado += this.animais[i].calculaEspacoOcupado();
        }
        return ocupado;
    }

    public float espacoDisponivel(){
        return calculaEspaco() - espacoOcupado();
    }

    public boolean adicionarAnimal(Animal animal){
        float animalEspaco = animal.calculaEspacoOcupado();
        if(!(this instanceof Aquario) && (animal instanceof Peixe) ){
            return false;
        }
        if(this.espacoDisponivel() > animalEspaco + 0.70 * animalEspaco  ){
            if(this.quantidadeAnimaisV < 100){
                this.setAnimais(animal);
                return true;
            }
            return false;
        }
        return false;
    }

    public Animal[] getAnimais() {
        return animais;
    }

    public void setAnimais(Animal animal) {
        if(this.quantidadeAnimaisV < 100){
            this.animais[quantidadeAnimaisV] = animal;
            quantidadeAnimaisV +=1;
        }
    }

    @Override
    public String toString() {
        return "Viveiro nome Viveiro =" + this.nome + "\n comprimento=" + this.comprimento + "\n largura=" + this.largura;
    }
    
}
