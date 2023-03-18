package apresetacao;
import dados.*;
public class Apresentacao {
    private static Pessoa pessoa1 = new Pessoa();
    private static Pessoa pessoa2 = new Pessoa();
    private static Pessoa pessoa3 = new Pessoa();
    private static Sorteador sorteador = new Sorteador();
    public static void main(String[] args) {
        pessoa1.setCpf("09066083921");
        pessoa3.setCpf("09063234426");
        pessoa2.setCpf("01266343921");
        pessoa1.setNomePessoa("Pedro");
        pessoa2.setNomePessoa("Fernando");
        pessoa3.setNomePessoa("Gustavo");
        pessoa1.setCpf("12");
        pessoa2.setCpf("13");
        pessoa3.setCpf("14");
        sorteador.setPessoas(pessoa1);
        sorteador.setPessoas(pessoa2);
        sorteador.setPessoas(pessoa3);
        System.out.println("Pessoa Sorteada: " + sorteador.SorteadorPessoas().toString());
        System.out.println(sorteador.toString());
    }
}
