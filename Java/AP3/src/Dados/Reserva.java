package Dados;

public class Reserva {
    private int numReserva,poltrona;
    private String dataVoo,horaVoo,classeVoo;
    private boolean idaEvolta = false;
    private Cidade origem,destino;
    private Reserva volta;
    private float preco;

    public Cidade getOrigem(){
        return this.origem;
    }
    public void setOrigem(Cidade origem){
        this.origem = origem;
    }
    public Cidade getDestino(){
        return this.destino;
    }
    public void setDestino(Cidade destino){
        this.destino = destino;
    }
    public void setVolta(Reserva volta){
        this.volta = volta;
        this.idaEvolta = true;
    }
    public Reserva getVolta(){
        return this.volta;
    }
    public boolean getIdaEvolta(){
        return this.idaEvolta;
    }
    public void setIdaeVolta(boolean idaEvolta){
        this.idaEvolta = idaEvolta;
    }
    public int getNumReserva(){
        return this.numReserva;
    }
    public void setNumReserva(int numReserva){
        this.numReserva = numReserva;
    }
    public int getPoltrona(){
        return this.poltrona;
    }
    public void setPoltrona(int poltrona){
        this.poltrona = poltrona;
    }
    public String getDataVoo(){
        return this.dataVoo;
    }
    public void setDataVoo(String dataVoo){
        this.dataVoo = dataVoo;
    }
    public String getHoraVoo(){
        return this.horaVoo;
    }
    public void setHoraVoo(String horaVoo){
        this.horaVoo = horaVoo;
    }
    public String getClasseVoo(){
        return this.classeVoo;
    }
    public void setClasseVoo(String classeVoo){
        this.classeVoo = classeVoo;
    }
    public float getPreco(){
        return this.preco;
    }
    public void setPreco(float preco){
        this.preco = preco;
    }

    public String toString(){
        String retorno = "";
        retorno += " Numero da reserva: '" + this.numReserva + "\n" +
                ", Data do voo: '" + this.dataVoo + "\n" +
                ", Hora do voo: '" + this.horaVoo + "\n" +
                ", Preco: '" + this.preco + "\n" +
                ", Classe: '" + this.classeVoo + "\n" +
                ", Poltrona: '" + this.poltrona + "\n" +
                ", Origem: '" + this.origem.toString() + "\n" +
                ", Destino: '" + this.destino.toString() + "\n";
        return retorno;

    }
}
