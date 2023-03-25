package dados;

public class Aquario extends Viveiro {
    public Aquario(String nome, float comprimento, float largura){
        super(nome,comprimento,largura);
    }
    public Aquario(){}

    private float altura, temperatura;

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }


    public float calculaEspaco(){
        return super.calculaEspaco() * altura;
    }

    public boolean adicionarAnimal(Animal animal){
        if(animal instanceof Peixe){
            Peixe peixe = new Peixe();
            peixe = (Peixe) animal;
            if(this.temperatura < 3 + peixe.getTemperaturaIdeal() && this.temperatura > peixe.getTemperaturaIdeal() - 3){
                super.adicionarAnimal(peixe);
                return true;
            }
            return false;
        }
        return false;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }

    @Override
    public String toString() {
        return super.toString() + "\n Temperatura ideal:" + this.temperatura;
    }
}
