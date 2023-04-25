package dados;

public class Circulo extends FormaGeomatrica {
    public Circulo(){
        super();
    }
    public void setRaio(int valor){
        this.medida1 = valor;
    }

    public double calculaArea(){
        return Math.PI*(medida1*medida1);
    }
    public double calculaPerimetro(){
        return Math.PI*(2*medida1);
    }

    @Override
    public String toString() {
        return "Circulo de raio " + this.medida1 + 
        " Com area de " + calculaArea() + " e perimetro de " + calculaPerimetro();
    }
}
