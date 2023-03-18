package dados;

public class Imovel {
    private float largura=9, comprimento=0,preco=0;

    public float areaTotal(){
        float aux;
        aux = this.largura * this.comprimento;
        return aux;
    }
    public Imovel(){}
    
    public float getLargura() {
        return this.largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getComprimento() {
        return this.comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getPreco() {
        return this.preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        
        return "Largura do Terreno: " + this.largura + "\nComprimento do Terreno: " + this.comprimento + "\nArea total: " + this.areaTotal() + "m2" + "\nPreço: " + this.preco;
    }

}
