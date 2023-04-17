package apresentacao;
import java.util.Scanner;

import dados.*;
import negocios.*;
public class Apresentacao {
    private static Sistema sistema = new Sistema();
    static Scanner scan = new Scanner(System.in);

    private static void cadPessoas(){
        Pessoa pessoa = new Pessoa();

        System.out.println("Digite o nome:");
        String nome = scan.nextLine();
        pessoa.setNome(nome);

        System.out.println("Digite a idade:");
        int idade = Integer.parseInt(scan.nextLine());
        pessoa.setIdade(idade);

        System.out.println("Digite o CPF:");
        String cpf = scan.nextLine();
        pessoa.setCpf(cpf);

        System.out.println("Digite a cidade:");
        String cidade = scan.nextLine();
        pessoa.setCidade(cidade);

        sistema.adicionarPessoa(pessoa);
    }
    public static void mostra(){
        for(int i = 0; i < 5; i += 1){
            intervalo(i);
            for(int i2 = 0; i2 < sistema.getPessoaIdade().get(i).size(); i2 += 1){
                System.out.println(sistema.getPessoaIdade().get(i).get(i2).toString());
            }
        }
    }

    public static void intervalo(int id){
        switch(id){
            case 0:
                System.out.println("1 até 12: ");
                break;
            case 1:
                System.out.println();
                System.out.println("13 até 18: ");
                break;
            case 2:
                System.out.println();
                System.out.println("19 até 25: ");
                break;
            case 3:
                System.out.println();
                System.out.println("26 até 59: ");
                break;
            case 4:
                System.out.println();
                System.out.println("60 ou mais: ");
                break;
        }
    }

    public static void main(String[] args) {
        int i = 0;
        while(i != -1){
            System.out.println("Digite -1 para parar ou 1 para continuar");
            i = Integer.parseInt(scan.nextLine());
            if(i == -1){
                break;
            }
            cadPessoas();
            mostra();
        }
    }
}
