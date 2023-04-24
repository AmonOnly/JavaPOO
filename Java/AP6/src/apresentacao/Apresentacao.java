package apresentacao;
import java.util.Scanner;
import dados.*;
import java.util.List;

public class Apresentacao{
    static Scanner scan = new Scanner(System.in);
        public void gerar(int quantidade) {};
    private static void menu(){
        System.out.println("Digite 1 para Naturais");
        System.out.println("Digite 2 para Abundantes");
        System.out.println("Digite 3 para Fibonacci");
        System.out.println("Digite 4 para Fatoriais");
        System.out.println("Digite 5 para Numero Primos");
        System.out.println("Digite 6 para Quadrados");
        System.out.println("Digite 7 para Perfeitos");
        System.out.println("Digite 0 para sair");
    }
    public static void mostrarSequencia(List<Integer> lista){
        if(lista.size() == 0){
            System.out.println("Não há nada na lista");
        }else{
            System.out.print("[");
            for(int i =0; i < lista.size();i++){
                System.out.print(lista.get(i)+", ");
            }
            System.out.print("]" + "\n");
        }
    }

    public static void gerarNatural(int n){
        Naturais naturais = new Naturais();
        naturais.gerar(n);
        System.out.print("Naturais: ");
        mostrarSequencia(naturais.getSequencia());
        
    }
    public static void gerarFatorial(int n){
        Fatoriais fatoriais = new Fatoriais();
        fatoriais.gerar(n);
        System.out.print("Fatorial: ");
        mostrarSequencia(fatoriais.getSequencia());
        
    }
    public static void gerarFibonacci(int n){
        Fibonacci fibonacci = new Fibonacci();
        fibonacci.gerar(n);
        System.out.print("Fibonacci: ");
        mostrarSequencia(fibonacci.getSequencia());
        
    }
    public static void gerarNumeroPrimos(int n){
        NumeroPrimos numeroPrimos = new NumeroPrimos();
        numeroPrimos.gerar(n);
        System.out.print("Numero Primos: ");
        mostrarSequencia(numeroPrimos.getSequencia());
        
    }
    public static void gerarPerfeito(int n){
        Perfeitos perfeitos = new Perfeitos();
        perfeitos.gerar(n);
        System.out.print("Perfeitos: ");
        mostrarSequencia(perfeitos.getSequencia());
        
    }
    public static void gerarAbundate(int n){
        Abundantes abundantes = new Abundantes();
        abundantes.gerar(n);
        System.out.print("Abundantes: ");
        mostrarSequencia(abundantes.getSequencia());
        
    }
    public static void gerarQuadrados(int n){
        Quadrados quadrados = new Quadrados();
        quadrados.gerar(n);
        System.out.print("Quadrados: ");
        mostrarSequencia(quadrados.getSequencia());
        
    }

    public static void main(String[] args) {
        
        int i = -1;
        while(i != 0){
            int k = 0;
            menu();
            i = Integer.parseInt(scan.nextLine());
            switch(i){
                case 1:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarNatural(k);
                    break;
                case 2:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarAbundate(k);
                    break;
                case 3:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarFibonacci(k);
                    break;
                case 4:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarFatorial(k);
                    break;
                case 5:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarNumeroPrimos(k);
                    break;
                case 6:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarQuadrados(k);
                    break;
                case 7:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarPerfeito(k);
                    break;
                case 0:
                    return;
            }
        }
    }
}

