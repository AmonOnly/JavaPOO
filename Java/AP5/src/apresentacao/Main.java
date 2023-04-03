package apresentacao;
import negocio.*;

import java.util.*;

import dados.*;
public class Main {
    static Scanner scan = new Scanner(System.in);
    private static ListaTelefonica lista = new ListaTelefonica();
    private static int quantiodadeContatos = 0;

    public static Contato novoContato(){
        Contato novoContato = new Contato();
        System.out.println("Digite o nome do novo contato:\n");
        String nome = scan.nextLine();
        novoContato.setNomeContato(nome);

        System.out.println("Digite o telefone de Contato\n");
        long telefone = Long.parseLong(scan.nextLine());
        novoContato.setTelefoneContato(telefone);

        return novoContato;
    }

    public static void adicionarContato(){
        Contato contato = new Contato();
        contato = novoContato();
        lista.adicionarContato(contato);
        quantiodadeContatos +=1;
    }

    public static void removerContato(){
        if(quantiodadeContatos == 0){
            System.out.println("Nenhum Contato Cadastrado\n");
            return;
        }
        Contato contatoDesejado = new Contato();
        System.out.println("Digite a letra do contato desejado\n");
        String letraNome = scan.nextLine().toUpperCase();
        char letra = letraNome.charAt(0);
        exibirContatos(letra);
        System.out.println("Digite o ID do contato que deseja deletar:\n");
        int id = Integer.parseInt(scan.nextLine());
        contatoDesejado = lista.buscarContatos(letra).get(id);
        lista.removerContato(contatoDesejado);
        quantiodadeContatos--;
    }

    public static void exibirContatos(){
        for(char i = 'A'; i <= 'Z';i++){
            List<Contato> listaCont = new LinkedList<Contato>();
            listaCont = lista.buscarContatos(i);
            if(listaCont == null){
                System.out.println("Não há mais contatos");
                return;
            }
            for(int in = 0; in < listaCont.size();in++){
                System.out.println(listaCont.get(in).toString());
            }
        }
    }

    public static void exibirContatos(char letra){
        if(quantiodadeContatos == 0){
            System.out.println("não há contatos");
            return;
        }
        List<Contato> listaCont = new LinkedList<Contato>();
        listaCont = lista.buscarContatos(letra);
        for(int in = 0; in < listaCont.size();in++){
            System.out.println("ID: " + in + "\n" + listaCont.get(in).toString());
        }
    }

    private static void Menu(){
        System.out.println("Digite 1 para adicionar um contato:\n");
        System.out.println("Digite 2 para remover um contato:\n");
        System.out.println("Digite 3 para exibir todos os contatos:\n");
        System.out.println("Digite 0 para sair");
    }

    public static void main(String[] args) {
        int i = -1;
        while(i!=0){
            Menu();
            i = Integer.parseInt(scan.nextLine());
            switch(i){
                case 1:
                    adicionarContato();
                    break;
                case 2:
                    removerContato();
                    break;
                case 3:
                    exibirContatos();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Está opção não existe\n");
                    break;
            }
        }
    }
}
