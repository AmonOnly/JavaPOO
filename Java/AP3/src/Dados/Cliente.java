package Dados;

public class Cliente {
    private String nome,cpf,endereco,telefone;
    private int quantidadeReservas = 0;
    private Reserva[] reservas = new Reserva[50];

    public int getQuantidadeReservas(){
        return this.quantidadeReservas;
    }
    public void setQuatidadeReservas(int quantidadeReservas){
        this.quantidadeReservas = quantidadeReservas;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCpf(){
        return this.cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public String getEndereco(){
        return this.endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public Reserva[] getReservas(){
        return this.reservas;
    }

    public void getReservaIda(Reserva reserva){
        int id = this.quantidadeReservas;
        if(id < 50){
            this.reservas[id] = new Reserva();
            this.reservas[id] = reserva;
            quantidadeReservas ++;
        }
    }
    public void getReservaVolta(Reserva ida, Reserva volta){
        int id = this.quantidadeReservas;
        if(id < 50){
            this.reservas[id] = volta;
            quantidadeReservas ++;
            ida.setVolta(volta);
        }
    }

    public String toString(){
        String retorno = "";
        retorno +=
            "Nome Cliente: " + this.nome + "\n" +
            "Numero CPF " + this.cpf + "\n" + 
            "Telefone: " + this.telefone + "\n" + 
            "Endereço: " + this.endereco + "\n";
        if(this.quantidadeReservas >0){
            retorno += "Reservas: " + this.reservas.toString() + "\n";

        }
        return retorno;
    }







}