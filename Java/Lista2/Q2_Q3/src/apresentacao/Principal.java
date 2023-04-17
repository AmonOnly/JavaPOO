package apresentacao;

import java.util.Scanner;
import java.util.List;
import dados.*;
public class Principal {
    static Scanner scan = new Scanner(System.in);

    public static int menorNumero(List<Integer> list){
        int menor = list.get(0);
        for(int i = 0; i < list.size();i++){
            if(menor > list.get(i)){
                menor = list.get(i);
            }
        }
        return menor;
    }


    public static void main(String[] args) {
        System.out.println("Qual a ordem da matriz quadrada que voce quer digitar?");
        int k = Integer.parseInt(scan.nextLine());
        Matriz<Integer> matriz = new Matriz<>(k, k);
        System.out.println("Digite os numeros da matriz. caso deseje sair do programa, digite -1");
        for (int i = 0; i < k; i += 1) {
            for (int j = 0; j < k; j += 1) {
                int valor = Integer.parseInt(scan.nextLine());
                if (valor != -1) {
                    matriz.set(valor, i, j);
                } else {
                    System.out.println("Saindo do programa...");
                    return;
                }
            }
        }

        int menor1 = menorNumero(matriz.getElementosQuadrantes(Quadrante.PRIMEIRO));
        int menor2 = menorNumero(matriz.getElementosQuadrantes(Quadrante.SEGUNDO));
        int menor3 = menorNumero(matriz.getElementosQuadrantes(Quadrante.TERCEIRO));
        int menor4 = menorNumero(matriz.getElementosQuadrantes(Quadrante.QUARTO));
        int menor = menor1;
        if(menor > menor2){
            menor = menor2;
        }
        if(menor > menor3){
            menor = menor3;
        }
        if(menor > menor4){
            menor = menor4;
        }

        System.out.println("Menor numero da matriz é " + menor);
    }
}
