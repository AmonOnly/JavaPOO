package dados;

public class TrianguloEquilatero extends FormaGeomatrica {
    public TrianguloEquilatero(){
        super();
    }

    public void setLado(int valor){
        this.medida1 = valor;
    }

    public double calculaArea(){
        double Area;
        Area =((Math.sqrt(3)/4)*(medida1*medida1));
        return Area;

    }
    public double calculaPerimetro(){
        double perimetro = 3*medida1;
        return perimetro;
    }

    @Override
    public String toString() {
        return "Triangulo Equilatero de lado " + this.medida1 + 
        " Com area de " + calculaArea() + " e perimetro de " + calculaPerimetro(); 
    }
    
}
