package Negocios;
import Dados.*;
public class ReservaPassagem {
    private Cidade[] listaCidade = new Cidade[50];
    private Cliente[] listaClientes = new Cliente[50];
    private int quatidadeClientes = 0,quatidadeCidades = 0;
    public int getQuantidadeDeCidades() {
        return this.quatidadeCidades;
    }

    public void setQuantidadeDeCidades(int quatidadeCidades) {
        this.quatidadeCidades = quatidadeCidades;
    }

    public int getQuantidadeDeClientes() {
        return this.quatidadeClientes;
    }

    public void setQuantidadeDeClientes(int quatidadeClientes) {
        this.quatidadeClientes = quatidadeClientes;
    }

    public void cadastrarCidade(Cidade cidade){
        if(this.quatidadeCidades < 50 && cidade != null){
            this.listaCidade[this.quatidadeCidades] = cidade;
            this.quatidadeCidades += 1;
        }
    }
    public void cadastrarCliente(Cliente cliente){
        if(this.quatidadeClientes < 50 && cliente != null){
            this.listaClientes[this.quatidadeClientes] = cliente;
            this.quatidadeClientes+=1;
        }
    }
    public void reservaIda(Cliente cliente, Reserva reserva){
        cliente.getReservaIda(reserva);
    }
    public void reservaVolta(Cliente cliente, Reserva ida, Reserva volta){
        cliente.getReservaVolta(ida,volta);
    }
    public Reserva[] mostrarReservas(String cpfCliente) {
        for (int i = 0; i < this.quatidadeClientes; i += 1) {
            if (this.listaClientes[i].getCpf().equals(cpfCliente)) {
                return this.listaClientes[i].getReservas();
            }
        }
        return null;
    }

    public Cidade[] mostrarCidades() {
        return this.listaCidade;
    }

    public Cliente[] mostrarClientes() {
        return this.listaClientes;
    }

    public void setCliente(int clienteID, Cliente cliente){
        this.listaClientes[clienteID] = cliente;
    }


}
