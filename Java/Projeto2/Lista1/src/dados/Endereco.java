package dados;

    public class Endereco {
        private String rua,bairro,cidade,estado;
        private int cep,numeroCasa;
    public Endereco(){

    }
    public Endereco(String rua,String bairro,String cidade,String estado, int cep,int numeroCasa){
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.estado = estado;
        this.rua = rua;
        this.numeroCasa = numeroCasa;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public int getCep() {
        return cep;
    }
    public void setCep(int cep) {
        this.cep = cep;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getNumeroCasa() {
        return numeroCasa;
    }
    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
    public String getRua() {
        return rua;
    }
    public void setRua(String rua) {
        this.rua = rua;
    }
    @Override
    public String toString() {
        String enderecoString = "";
        enderecoString += " Rua " + this.rua;
        enderecoString += ", " + this.numeroCasa;
        enderecoString += ", " + this.bairro;
        enderecoString += ", " + this.cidade;
        enderecoString += ", " + this.estado;
        enderecoString += ". CEP: " + this.cep + "\n\n";
        return enderecoString;
    }

}
