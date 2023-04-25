package apresentacao;
import dados.*;

public class Main {
    public static void main(String[] args) {
        Coruja coguja = new Coruja();
        coguja.setNome("Coguja");

        Coruja kota = new Coruja();
        kota.setNome("Kota");

        Mula psico = new Mula();
        psico.setNome("Psico");

        Mula pietro = new Mula();
        pietro.setNome("Pietro");

        Peru pisco = new Peru();
        pisco.setNome("Pisco");

        Peru pericles = new Peru();
        pericles.setNome("Pericles");

        System.out.println(coguja.emitirSom());
        System.out.println(kota.emitirSom());
        System.out.println(psico.emitirSom());
        System.out.println(pietro.emitirSom());
        System.out.println(pisco.emitirSom());
        System.out.println(pericles.emitirSom());

    }
    
}
