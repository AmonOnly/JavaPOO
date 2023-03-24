package dados;

public class Peixe extends Animal {
    public Peixe (){
        super();
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
}
