package Apresentacao;

import Dados.*;
import Negocios.*;
import java.util.*;


public class Apresentacao {
    private static Scanner scan = new Scanner(System.in);
    private static ReservaPassagem reservaPassagem = new ReservaPassagem();

    public static void cadastrarCliente() {
        Cliente cliente = new Cliente();

        System.out.println("Digite o nome do cliente");
        String nome = scan.nextLine();
        cliente.setNome(nome);

        System.out.println("Digite o CPF");
        String cpf = scan.nextLine();
        cliente.setCpf(cpf);

        System.out.println("Digite o telefone");
        String telefone = scan.nextLine();
        cliente.setTelefone(telefone);

        System.out.println("Digite o endereco");
        String endereco = scan.nextLine();
        cliente.setEndereco(endereco);

        reservaPassagem.cadastrarCliente(cliente);
    }

    public static void cadastrarCidade() {
        Cidade cidade = new Cidade();

        System.out.println("Digite o nome da cidade:");
        String nome = scan.nextLine();
        cidade.setCidade(nome);

        System.out.println("Digite o nome do Estado");
        String estado = scan.nextLine();
        cidade.setEstado(estado);

        reservaPassagem.cadastrarCidade(cidade);
    }

    public static void FazerReserva() {
        if (reservaPassagem.getQuantidadeDeClientes() == 0) {
            System.out.println("Nenhum cliente cadastrado");
            return;
        }
        if (reservaPassagem.getQuantidadeDeCidades() <= 1) {
            System.out.println("Quantidade insuficiente de cidades");
            return;
        }
        Cliente[] clientes = reservaPassagem.mostrarClientes();
        System.out.println("\nClientes");
        for (int i = 0; i < reservaPassagem.getQuantidadeDeClientes(); i++) {
            System.out.println("Cliente ID " + i + " " + clientes[i].toString());
        }
        System.out.println("\nDigite o ID do cliente");
        int clienteID = Integer.parseInt(scan.nextLine());
        if (clienteID > reservaPassagem.getQuantidadeDeClientes()) {
            System.out.println("Cliente não cadastrado");
            return;
        }
        Reserva reserva = new Reserva();
        Cidade[] cidades = reservaPassagem.mostrarCidades();
        System.out.println("Cidades\n");
        for (int i = 0; i < reservaPassagem.getQuantidadeDeCidades(); i++) {
            System.out.println("Cidade ID " + i + " " + cidades[i].toString());
        }
        System.out.println("\nDigite o ID da cidade de Origem:");
        int origemID = Integer.parseInt(scan.nextLine());
        System.out.println("\nDigite o ID da cidade de Destino: ");
        int destinoID = Integer.parseInt(scan.nextLine());
        if (origemID == destinoID) {
            System.out.println("A origem não pode ser igual o destino");
            return;
        }
        reserva = cadastrarReserva();
        reserva.setDestino(cidades[destinoID]);
        reserva.setOrigem(cidades[origemID]);

        Reserva volta = new Reserva();
        System.out.println("\nDigite 1 para reservar a volta");
        int codvolta = Integer.parseInt(scan.nextLine());
        if (codvolta == 1) {
            volta = cadastrarReserva();
            volta.setOrigem(cidades[destinoID]);
            volta.setDestino(cidades[origemID]);
            reserva.setVolta(volta);
        }
        clientes[clienteID].getReservaIda(reserva);
        if (reserva.getIdaEvolta() == true) {
            clientes[clienteID].getReservaVolta(reserva, volta);
        }
        reservaPassagem.setCliente(clienteID, clientes[clienteID]);
    }

    public static Reserva cadastrarReserva() {
        Reserva reserva = new Reserva();

        System.out.println("Digite o numero da reserva");
        int numReserva = Integer.parseInt(scan.nextLine());
        reserva.setNumReserva(numReserva);

        System.out.println("Digite a data do voo");
        String dataVoo = scan.nextLine();
        reserva.setDataVoo(dataVoo);

        System.out.println("Digite a hora do voo");
        String horaVoo = scan.nextLine();
        reserva.setHoraVoo(horaVoo);

        System.out.println("Digite o preco da reserva");
        float preco = Float.parseFloat(scan.nextLine());
        reserva.setPreco(preco);

        System.out.println("Digite a classe do voo");
        String classeVoo = scan.nextLine();
        reserva.setClasseVoo(classeVoo);

        System.out.println("Digite o numero da poltrona");
        int poltrona = Integer.parseInt(scan.nextLine());
        reserva.setPoltrona(poltrona);

        return reserva;
    }

    public static void mostrarReservas() {
        if (reservaPassagem.getQuantidadeDeClientes() == 0) {
            System.out.println("Sem clientes cadastrados");
            return;
        }
        System.out.println("Digite o cpf do cliente para o qual deseja mostrar as reservas");
        String cpfCliente = (scan.nextLine());
        Reserva[] reservas = reservaPassagem.mostrarReservas(cpfCliente);
        if (reservas == null) {
            System.out.println("Algo deu errado");
            return;
        }
        for (int i = 0; i < reservas.length; i += 1) {
            if (reservas[i] == null)
                break;

            System.out.println(reservas[i].toString());
            System.out.println("\n");

        }

    }

    public static void main(String[] args) {
        int escolha = -1;
        while(escolha != 0){
            System.out.println("Digite 1 para Cadastrar uma cidade\n");
            System.out.println("Digite 2 para cadastrar um cliente\n");
            System.out.println("Digite 3 para Fazer uma reserva\n");
            System.out.println("Digite 4 para mostrar as reservas de um cliente\n");
            System.out.println("Digite 0 para sair");

            escolha = Integer.parseInt(scan.nextLine());
            switch(escolha){
                case 1:
                    cadastrarCidade();
                    break;
                case 2:
                    cadastrarCliente();
                    break;
                case 3:
                    FazerReserva();
                    break;
                case 4:
                    mostrarReservas();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opcao não cadastrada");
                    break;
            }
        }
    }
}
