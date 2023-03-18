package dados;

public class Produto {
    private int idProduto;
    private String nomeProduto,descricaoProduto,tipoProduto,marcaProduto;
    private double precoProduto;
    public Produto(){

    }
    public Produto(int idProduto, String nomeProduto, String descricaoProduto, String tipoProduto, Double precoProduto, String marcaProduto){
        this.descricaoProduto = descricaoProduto;
        this.nomeProduto = nomeProduto;
        this. tipoProduto = tipoProduto;
        this.idProduto = idProduto;
        this.precoProduto = precoProduto ;
        this.marcaProduto = marcaProduto;
    }


    public String getDescricaoProduto() {
        return descricaoProduto;
    }
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }
    public int getIdProduto() {
        return idProduto;
    }
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }
    public String getNomeProduto() {
        return nomeProduto;
    }
    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }
    public double getPrecoProduto() {
        return precoProduto;
    }
    public void setPrecoProduto(Double precoProduto) {
        this.precoProduto = precoProduto;
    }
    public String getTipoProduto() {
        return tipoProduto;
    }
    public void setTipoProduto(String tipoProduto) {
        this.tipoProduto = tipoProduto;
    }
    public String getMarcaProduto() {
        return marcaProduto;
    }
    public void setMarcaProduto(String marcaProduto) {
        this.marcaProduto = marcaProduto;
    }

    public String toString() {
        String produString = "";
        produString += "Id produto:" + this.idProduto + "//"
        + "Nome: " + this.nomeProduto +" "+ " Marca:"+ this.marcaProduto + "\n"
        + "Preço do Produto: " + this.precoProduto + "\n"
        + "Tipo do Produto: " + this.tipoProduto + "\n"
        + "Derscição do Produto: " + this.descricaoProduto + "\n";
        return produString;
    }
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if(!(obj instanceof Produto)){
            return false;
        }
        Produto produto = (Produto)obj;
        if(this.marcaProduto.equals(produto.getMarcaProduto())&& this.nomeProduto.equals(produto.getNomeProduto())){
            return true;
        }
        else
            return false;

    }

}
