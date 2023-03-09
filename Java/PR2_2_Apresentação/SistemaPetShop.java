package PR2_2_Apresentação;
import PR2_2_Dados.*;
import java.util.*;
public class SistemaPetShop {
    private static Veterinario[] veterinarios = new Veterinario[50];
    private static int numeroVeterinarios = 0;
    private static Scanner scan = new Scanner(System.in);

    public static void menu(){
        System.out.println("\nDigite 1 para cadastrar um Veterinario");
        System.out.println("\nDigite 2 para Mostrar todos os Veterinarios");
        System.out.println("\nDigite 3 para cadastrar um endereço a um Veterinario");
        System.out.println("\nDigite 4 para cadastrar um animal");
        System.out.println("\nDigite 5 para Mostrar os animais");
        System.out.println("\nDigite 6 para cadastrar um Dono");
        System.out.println("\nDigite 0 para sair");

    }
    public static void cadastrarVeterianario(){
        if(numeroVeterinarios < 50){
            Veterinario vet = new Veterinario();

            System.out.println("\nDigite o nome do Veterinário");
            String nome = scan.nextLine();
            vet.setnome(nome);

            System.out.println("\nDigite o Salario do veterinario");
            double salario = Double.parseDouble(scan.nextLine());
            vet.setsalario(salario);

            veterinarios[numeroVeterinarios] = vet;
            numeroVeterinarios ++;
        }
        else{
            System.out.println("\n Numero maximo de Veterinarios atingido");
        }
    }
    public static void mostrarVeterinario(){
        if(numeroVeterinarios == 0){
            System.out.println("\nNao há Veterinario cadastrados");
        }
        else{
            for(int i =0;i < numeroVeterinarios;i++){
                System.out.println("ID Vet = " + i + " \n" + veterinarios[i].toString());
            }
        }
    }
    public static Veterinario escolheVeterinario() {
        if(numeroVeterinarios == 0){
            System.out.println("\nNao há Veterinario cadastrados");
            return null;
        }
        System.out.println("\nEscolha o veterinario");
        int escolhe = Integer.parseInt(scan.nextLine());
        if(escolhe > numeroVeterinarios){
            System.out.println("\nNão há veterinario com este id");
            return null;
        }
        else
            return veterinarios[escolhe];

    }
    public static Endereco cadEndereco(){
        Endereco en = new Endereco();

        System.out.println("\nDigite o Nome da Rua");
        String nome = scan.nextLine();
        en.setNomeRua(nome);

        System.out.println("\nDigite o numero da casa");
        String numero = scan.nextLine();
        en.setnumeroRua(numero);

        System.out.println("\nDigite o Bairro");
        String bairro = scan.nextLine();
        en.setnomeBairro(bairro);

        System.out.println("\nDigite a Cidade");
        String cidade = scan.nextLine();
        en.setnomeCidade(cidade);

        System.out.println("\nDigite o Estado");
        String Estado = scan.nextLine();
        en.setnumeroRua(Estado);

        System.out.println("\nDigite o numero do CEP");
        String cep = scan.nextLine();
        en.setcep(cep);

        return en;
    }

    public static void cadEnVeterinario(){
        Veterinario vet = escolheVeterinario();
        if(vet != null){
            vet.setendereco(cadEndereco());
        }else{
            System.out.println("\nVeterinario não cadastrado");
        }
    }

    public static Animais cadAnimais(){
        Animais pet = new Animais();

        System.out.println("\nDigite o nome do Animal:");
        String nome = scan.nextLine();
        pet.setNome(nome);

        System.out.println("\nDigite a especie do animal:");
        String especie = scan.nextLine();
        pet.setEspecie(especie);

        System.out.println("\nDigite a Descricao:");
        String descricao = scan.nextLine();
        pet.setDescricao(descricao);

        return pet;
    }

    public static void cadPetVet(){
        Veterinario vet = escolheVeterinario();
        if(vet != null){
            vet.setanimais(cadAnimais());
        }else{
            System.out.println("\nVeterinario não cadastrado");
        }
    }

    public static Dono cadDono(){
        Dono own = new Dono();

        System.out.println("\nDigite o nome do dono:");
        String nome = scan.nextLine();
        own.setnome(nome);

        System.out.println("\nDigite o cpf do dono");
        String cpf = scan.nextLine();
        own.setcpf(cpf);

        own.setendereco(cadEndereco());

        return own;
    }
    
    public static void mostrarAnimais(){
        Veterinario vet = escolheVeterinario();
        if(vet!= null){
            for(int i = 0;i<vet.getQuatidadeAnimais();i++){
                System.out.println("\nAnimal Id" + i + "\n" + vet.getanimais()[i].toString());

            }
            if(vet.getQuatidadeAnimais() == 0){
                System.out.println("\nNenhum animal cadastrado");
            }
            else{
                System.out.println("\nVeterinario não cadastrado");
            }
        }
    }
    public static Animais escolheAnimais(){
        Veterinario vet = escolheVeterinario();
        if(vet != null){
            for(int i = 0; i<vet.getQuatidadeAnimais();i++){
                System.out.println("\nAnimal Id " + i + " \n" + vet.getanimais()[i].toString());
            }
            if(vet.getQuatidadeAnimais() == 0){
                System.out.println("\nNenhum animal cadastrado para esse veterinario");
                return null;
            }
            int aniEscolhe = Integer.parseInt(scan.nextLine());
            if (aniEscolhe > vet.getQuatidadeAnimais()){
                return null;
            }else{
                return vet.getanimais()[aniEscolhe];
            }
        }
        return null;
    }
    public static void cadastrarDonoAnimal(){
        Animais pet = escolheAnimais();
        if(pet != null){
            pet.setDono(cadDono());
        }else{
            System.out.println("\nEscolha invalida");
        }
    }
    public static void main(String[] args) {
       int escolha = -1;
       while(escolha != 0){
        menu();
        escolha = Integer.parseInt(scan.nextLine());
        switch(escolha){
            case 0:
                break;
            case 1:
                cadastrarVeterianario();
                break;
            case 2:
                mostrarVeterinario();
                break;
            case 3:
                cadEnVeterinario();
                break;
            case 4:
                cadPetVet();
                break;
            case 5:
                mostrarAnimais();
                break;
            case 6:
                cadastrarDonoAnimal();
                break;
            default:
                System.out.println("Escolha invalida");
                break;
        }
       } 
    }


    
}
