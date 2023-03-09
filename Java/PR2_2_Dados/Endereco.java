package PR2_2_Dados;

public class Endereco {
    private String nomeRua,numeroRua,nomeBairro,nomeCidade,nomeEstado,cep;
    public Endereco(){

    }
    
    public String getNomeRua(){
        return this.nomeRua;
    }
    public void setNomeRua(String nomeRua){
        this.nomeRua = nomeRua;
    }
    
    public String getnumeroRua(){
        return this.numeroRua;
    }
    public void setnumeroRua(String numeroRua){
        this.numeroRua = numeroRua;
    }
    public String getnomeBairro(){
        return this.nomeBairro;
    }
    public void setnomeBairro(String nomeBairro){
        this.nomeBairro = nomeBairro;
    }
    public String getnomeCidade(){
        return this.nomeCidade;
    }
    public void setnomeCidade(String nomeCidade){
        this.nomeCidade = nomeCidade;
    }
    public String getnomeEstado(){
        return this.nomeEstado;
    }
    public void setnomeEstado(String nomeEstado){
        this.nomeEstado = nomeEstado;
    }
    public String getcep(){
        return this.cep;
    }
    public void setcep(String cep){
        this.cep = cep;
    }
    public String toString(){
        String enderecoString = "";
        enderecoString += "Rua "+this.nomeRua;
        enderecoString += ", "+this.numeroRua;
        enderecoString += ", " + this.nomeBairro;
        enderecoString += ", "+this.nomeCidade;
        enderecoString += ", "+this.nomeEstado;
        enderecoString += ". CEP: "+this.cep+"\n\n";
        return enderecoString;
    }
    
}


