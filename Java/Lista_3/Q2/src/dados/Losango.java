package dados;

public class Losango extends FormaGeomatrica {
    public Losango(){
        super();
    }
    
    public void setD(int valor){
        this.medida1 = valor;
    }
    public void setd(int valor){
        this.medida2 = valor;
    }

    public double calculaArea(){
        return (medida1*medida2)/2;
    }
    public double calculaPerimetro(){
        double lado = Math.sqrt(((medida1*medida1)/4)+((medida2*medida2)/4) );
        return 4*lado;
    }

    @Override
    public String toString() {
        return "Losangolo de " + this.medida1 + "x" + this.medida2 + 
        " Com area de " + calculaArea() + " e perimetro de " + calculaPerimetro();
    }
}
