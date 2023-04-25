package apresentacao;
import dados.*;

public class Main {
    public static void main(String[] args) {
        Circulo circulo1 = new Circulo();
        circulo1.setRaio(10);

        Circulo circulo2 = new Circulo();
        circulo2.setRaio(4);

        Losango losango1 = new Losango();
        losango1.setD(10);
        losango1.setd(10);

        Losango losango2 = new Losango();
        losango2.setD(5);
        losango2.setd(5);

        TrianguloEquilatero triangulo1 = new TrianguloEquilatero();
        triangulo1.setLado(10);

        TrianguloEquilatero triangulo2 = new TrianguloEquilatero();
        triangulo2.setLado(5);

        System.out.println(circulo1.toString());
        System.out.println(circulo2.toString());
        System.out.println(losango1.toString());
        System.out.println(losango2.toString());
        System.out.println(triangulo1.toString());
        System.out.println(triangulo2.toString());
    }
}
