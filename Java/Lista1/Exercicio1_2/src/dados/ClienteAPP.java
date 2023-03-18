package dados;

public class ClienteAPP {
    private String nomeCliente,cpf;
    private int dataDia,dataMes,dataAno;
    private Endereco endereco = new Endereco();
    
    public ClienteAPP(){

    }
    public ClienteAPP(String nomeCliente, String cpf, int dataDia, int dataMes,int dataAno, Endereco endereco ){
        this.cpf = cpf;
        this.dataAno = dataAno;
        this.dataDia = dataDia;
        this.dataMes = dataMes;
        this.endereco = endereco;
        this.nomeCliente = nomeCliente;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public int getDataAno() {
        return dataAno;
    }
    public void setDataAno(int dataAno) {
        this.dataAno = dataAno;
    }
    public int getDataDia() {
        return dataDia;
    }
    public void setDataDia(int dataDia) {
        this.dataDia = dataDia;
    }
    public int getDataMes() {
        return dataMes;
    }
    public void setDataMes(int dataMes) {
        this.dataMes = dataMes;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    public String getNomeCliente() {
        return nomeCliente;
    }
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }
    
    public String toString(){
        String clienteString ="";
        clienteString += "Nome: " + this.nomeCliente + "\n" +
        "Data de Nascimento: " + this.dataDia + "/" 
        + this.dataMes + "/" + this.dataAno + "\n";
        if(this.endereco != null){
            clienteString += "\n Endereço: " + this.endereco.toString();
        }
        return clienteString;
    }
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof ClienteAPP)){
            return false;
        }
        ClienteAPP cliente = (ClienteAPP)obj;
        if(this.nomeCliente.equals(cliente.getNomeCliente())&&
         this.cpf.equals(cliente.getCpf())){
            return true;
        }
        else
            return false;

    }
}
