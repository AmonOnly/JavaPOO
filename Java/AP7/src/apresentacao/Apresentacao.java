package apresentacao;
import java.util.Scanner;
import dados.*;
import java.util.List;

public class Apresentacao{
    private static Naturais naturais = new Naturais();
    private static Fatoriais fatoriais = new Fatoriais();
    private static Fibonacci fibonacci = new Fibonacci();
    private static NumeroPrimos numeroPrimos = new NumeroPrimos();
    private static Perfeitos perfeitos = new Perfeitos();
    private static Abundantes abundantes = new Abundantes();
    private static Quadrados quadrados = new Quadrados();
    static Scanner scan = new Scanner(System.in);
        public void gerar(int quantidade) {};
    private static void menu(){
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Digite 1 para Naturais");
        System.out.println("Digite 2 para Abundantes");
        System.out.println("Digite 3 para Fibonacci");
        System.out.println("Digite 4 para Fatoriais");
        System.out.println("Digite 5 para Numero Primos");
        System.out.println("Digite 6 para Quadrados");
        System.out.println("Digite 7 para Perfeitos");
        System.out.println("Digite 0 para sair");
        System.out.println("---------------------------------------------------------------------------");
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
        naturais.gerar(n);
        System.out.print("Naturais: ");
        mostrarSequencia(naturais.getSequencia());
        
    }
    public static void gerarFatorial(int n){
        fatoriais.gerar(n);
        System.out.print("Fatorial: ");
        mostrarSequencia(fatoriais.getSequencia());
        
    }
    public static void gerarFibonacci(int n){
        fibonacci.gerar(n);
        System.out.print("Fibonacci: ");
        mostrarSequencia(fibonacci.getSequencia());
        
    }
    public static void gerarNumeroPrimos(int n){
        numeroPrimos.gerar(n);
        System.out.print("Numero Primos: ");
        mostrarSequencia(numeroPrimos.getSequencia());
        
    }
    public static void gerarPerfeito(int n){
        perfeitos.gerar(n);
        System.out.print("Perfeitos: ");
        mostrarSequencia(perfeitos.getSequencia());
        
    }
    public static void gerarAbundate(int n){
        abundantes.gerar(n);
        System.out.print("Abundantes: ");
        mostrarSequencia(abundantes.getSequencia());
        
    }
    public static void gerarQuadrados(int n){
        quadrados.gerar(n);
        System.out.print("Quadrados: ");
        mostrarSequencia(quadrados.getSequencia());
        
    }

    public static void calculosDoGerador(int i){
        if(i == 1){
                System.out.println("Sortear: "+naturais.sortear());
                System.out.println("Somatorio: "+naturais.somatorio());
                System.out.println("Media Aritimetica: "+naturais.mediaAritimetica());
                System.out.println("Media Geomatrica: "+naturais.mediaGeometrica());
                System.out.println("Variancia: "+naturais.variancia());
                System.out.println("Desvio padrao: "+naturais.desvioPadrao());
                System.out.println("Amplitude: "+naturais.amplitude());
            }
            if(i == 2){
                System.out.println("Sortear: "+abundantes.sortear());
                System.out.println("Somatorio: "+abundantes.somatorio());
                System.out.println("Media Aritimetica: "+abundantes.mediaAritimetica());
                System.out.println("Media Geomatrica: "+abundantes.mediaGeometrica());
                System.out.println("Variancia: "+abundantes.variancia());
                System.out.println("Desvio padrao: "+abundantes.desvioPadrao());
                System.out.println("Amplitude: "+abundantes.amplitude());
            }
            if(i == 3){
                System.out.println("Sortear: "+fibonacci.sortear());
                System.out.println("Somatorio: "+fibonacci.somatorio());
                System.out.println("Media Aritimetica: "+fibonacci.mediaAritimetica());
                System.out.println("Media Geomatrica: "+fibonacci.mediaGeometrica());
                System.out.println("Variancia: "+fibonacci.variancia());
                System.out.println("Desvio padrao: "+fibonacci.desvioPadrao());
                System.out.println("Amplitude: "+fibonacci.amplitude());
            }
            if(i == 4){
                System.out.println("Sortear: "+fatoriais.sortear());
                System.out.println("Somatorio: "+fatoriais.somatorio());
                System.out.println("Media Aritimetica: "+fatoriais.mediaAritimetica());
                System.out.println("Media Geomatrica: "+fatoriais.mediaGeometrica());
                System.out.println("Variancia: "+fatoriais.variancia());
                System.out.println("Desvio padrao: "+fatoriais.desvioPadrao());
                System.out.println("Amplitude: "+fatoriais.amplitude());
            }
            if(i == 5){
                System.out.println("Sortear: "+numeroPrimos.sortear());
                System.out.println("Somatorio: "+numeroPrimos.somatorio());
                System.out.println("Media Aritimetica: "+numeroPrimos.mediaAritimetica());
                System.out.println("Media Geomatrica: "+numeroPrimos.mediaGeometrica());
                System.out.println("Variancia: "+numeroPrimos.variancia());
                System.out.println("Desvio padrao: "+numeroPrimos.desvioPadrao());
                System.out.println("Amplitude: "+numeroPrimos.amplitude());
            }
            if(i == 6){
                System.out.println("Sortear: "+quadrados.sortear());
                System.out.println("Somatorio: "+quadrados.somatorio());
                System.out.println("Media Aritimetica: "+quadrados.mediaAritimetica());
                System.out.println("Media Geomatrica: "+quadrados.mediaGeometrica());
                System.out.println("Variancia: "+quadrados.variancia());
                System.out.println("Desvio padrao: "+quadrados.desvioPadrao());
                System.out.println("Amplitude: "+quadrados.amplitude());
            }
            if(i == 7){
                System.out.println("Sortear: "+perfeitos.sortear());
                System.out.println("Somatorio: "+perfeitos.somatorio());
                System.out.println("Media Aritimetica: "+perfeitos.mediaAritimetica());
                System.out.println("Media Geomatrica: "+perfeitos.mediaGeometrica());
                System.out.println("Variancia: "+perfeitos.variancia());
                System.out.println("Desvio padrao: "+perfeitos.desvioPadrao());
                System.out.println("Amplitude: "+perfeitos.amplitude());
            }

        
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
                    calculosDoGerador(i);
                    break;
                case 2:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarAbundate(k);
                    calculosDoGerador(i);
                    break;
                case 3:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarFibonacci(k);
                    calculosDoGerador(i);
                    break;
                case 4:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarFatorial(k);
                    calculosDoGerador(i);
                    break;
                case 5:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarNumeroPrimos(k);
                    calculosDoGerador(i);
                    break;
                case 6:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarQuadrados(k);
                    calculosDoGerador(i);
                    break;
                case 7:
                    System.out.println("Digite o numero");
                    k = Integer.parseInt(scan.nextLine());
                    gerarPerfeito(k);
                    calculosDoGerador(i);
                    break;
                case 0:
                    return;
            }
        }
    }
}

