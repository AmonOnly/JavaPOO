package apresentacao;
import java.util.Scanner;

import negocios.*;
import dados.*;

public class Apresentacao {
    private static Zoologico zoologicos = new Zoologico();
    private static Scanner scan = new Scanner(System.in);

    public static void cadastrarAnimais(){
        System.out.println("\nDigite o nome do Animal: ");
        String nome = scan.nextLine();
        System.out.println("\nDigite a cor do Animal: ");
        String cor = scan.nextLine();
        System.out.println("\nDigite a idade do animal: ");
        int idade = Integer.parseInt(scan.nextLine());
        System.out.println("\nDigite a largura do animal: ");
        float largura = Float.parseFloat(scan.nextLine());
        System.out.println("\nDigite o comprimento do animal: ");
        float comprimento = Float.parseFloat(scan.nextLine());
        System.out.println("\nDigite a altura do animal: ");
        float altura  = Float.parseFloat(scan.nextLine());
        System.out.println("\nDigite a especie do animal: ");
        String especie = scan.nextLine();
        System.out.println("\nDigite 1 para um peixe e 2 caso não seja um peixe");
        int k = Integer.parseInt(scan.nextLine());
        if(k==1){
            Peixe animal = new Peixe(nome, cor, especie, idade, largura, comprimento, altura);
            System.out.println("\nDigite a temperatura ideal:");
            float temp = Float.parseFloat(scan.nextLine());
            animal.setTemperaturaIdeal(temp);
            zoologicos.cadastrarAnimais(animal);
        }
        else{
            Animal animal = new Animal(nome, cor, especie, idade, largura, comprimento, altura);
            zoologicos.cadastrarAnimais(animal);
        }
    }

    public static void cadastrarViveiro(){
        System.out.println("\nDigite o nome do Vivieiro:");
        String nome = scan.nextLine();
        System.out.println("\nDigite o Comprimento do viveiro:");
        float comprimento = Float.parseFloat(scan.nextLine());
        System.out.println("\nDigite a largura do viveiro: ");
        float largura = Float.parseFloat(scan.nextLine());
        System.out.println("\nDigite 1 para um aquario e 2 para um viveiro comum: ");
        int k = Integer.parseInt(scan.nextLine());
        if(k == 1){
            Aquario viveiro = new Aquario(nome, comprimento, largura);
            System.out.println("\nDigite a altura do Aquario:");
            float altura = Float.parseFloat(scan.nextLine());
            viveiro.setAltura(altura);
            System.out.println("\nDigite a temperatura do viveiro:");
            float temp = Float.parseFloat(scan.nextLine());;
            viveiro.setTemperatura(temp);
            zoologicos.cadastrarViveiro(viveiro);
        }
        else{
            Viveiro viveiro = new Viveiro(nome, comprimento, largura);
            zoologicos.cadastrarViveiro(viveiro);
        }
    }

    public static void mostrarAnimais(){
        for(int i = 0; i < zoologicos.getQuantidadeAnimais();i++){
            System.out.println("ID Animal: " + i + "\n" + zoologicos.getAnimais()[i].toString() );
        }
    }
    public static void mostrarViveiros(){
        for(int i = 0; i < zoologicos.getQuantidadeViveiros();i++){
            System.out.println("ID Viveiro: " + i + "\n" + zoologicos.getViveiros()[i].toString());
            if(zoologicos.getViveiros()[i].getQuantidadeAnimaisV() > 0){
                for(int in = 0; in <zoologicos.getViveiros()[i].getQuantidadeAnimaisV();in++){
                    System.out.println("Animais no viveiro: \n" + zoologicos.getViveiros()[i].getAnimais()[in].toString());
                }
            }
        }
    }

    public static void botarAnimais(){
        if(zoologicos.getQuantidadeAnimais() == 0){
            System.out.println("Nenhum Animal cadastrado");
            return;
        }
        if(zoologicos.getQuantidadeViveiros() == 0){
            System.out.println("Nenhum viveiro cadastrado");
        }else{
            mostrarAnimais();
            System.out.println("\nDigite o ID do animal:");
            int IdAnimal = Integer.parseInt(scan.nextLine());

            mostrarViveiros();
            System.out.println("\nDigitee o ID do viveiro;");
            int IdViveiro = Integer.parseInt(scan.nextLine());

            if(zoologicos.alocarAnimal(zoologicos.getAnimais()[IdAnimal],zoologicos.getViveiros()[IdViveiro])){
                System.out.println("\nTudo de acordo com o planejado");
            }else{
                System.out.println("Impossivel de colocar o animal neste local");
            }
        }
    }
    public static void menu(){
        System.out.println("---------------------------------------------\n");
        System.out.println("Digite 1 para Registrar um viviero\n");
        System.out.println("Digite 2 para Registrar um animal\n");
        System.out.println("Digite 3 para mostrar os viveiros\n");
        System.out.println("Digite 4 para Mostrar os animais\n");
        System.out.println("Digite 5 para Alocar um animal\n");
        System.out.println("Digite 0 para sair\n");
        System.out.println("---------------------------------------------\n");
    }

    public static void main(String[] args) {
        int k = -1;
        Peixe animal1 = new Peixe();
        animal1.setNome("Carlos");
        animal1.setAltura(10);
        animal1.setComprimento(10);
        animal1.setCor("Rosa");
        animal1.setEspecie("Carlos");
        animal1.setIdade(20);
        animal1.setTemperaturaIdeal(20);
        animal1.setLargura(10);

        Aquario aquario1 = new Aquario();
        aquario1.setAltura(500);
        aquario1.setComprimento(500);
        aquario1.setLargura(500);
        aquario1.setTemperatura(20);
        aquario1.setNome("Aquas");

        zoologicos.cadastrarAnimais(animal1);
        zoologicos.cadastrarViveiro(aquario1);

        zoologicos.alocarAnimal(animal1, aquario1);
        while(k!=0){
            menu();
            k = Integer.parseInt(scan.nextLine());
            switch(k){
                case 1:
                    cadastrarViveiro();
                    break;
                case 2:
                    cadastrarAnimais();
                    break;
                case 3:
                    mostrarViveiros();
                    break;
                case 4:
                    mostrarAnimais();
                    break;
                case 5:
                    botarAnimais();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("\nOpcão não cadastrada");
                    break;
            }
        }
    }
}
