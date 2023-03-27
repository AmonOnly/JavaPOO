package dados;

public class Peixe extends Animal {
    public Peixe(){}
    public Peixe (String nome, String cor, String especie, int idade, float largura, float comprimento, float altura){
        super(nome, cor, especie, idade, largura, comprimento, altura);
    }
    private float temperaturaIdeal;
    
    public float getTemperaturaIdeal() {
        return temperaturaIdeal;
    }

    public void setTemperaturaIdeal(float temperaturaIdeal) {
        this.temperaturaIdeal = temperaturaIdeal;
    }

    public float calculaEspacoOcupado(){
        return super.calculaEspacoOcupado() * altura;
    }
    
    public String toString(){
        return super.toString()+ ", Temperatura Ideal: '" + getTemperaturaIdeal() + "'";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        Peixe other = (Peixe) obj;
        if (Float.floatToIntBits(temperaturaIdeal) != Float.floatToIntBits(other.temperaturaIdeal))
            return false;
        return true;
    }
    

}
