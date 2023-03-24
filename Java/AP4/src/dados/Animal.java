package dados;

public class Animal {
    private String nome,cor,especie;
    private int idade;
    protected float largura = 0;
    protected float comprimento = 0;
    protected float altura = 0;

    public Animal(String nome, String cor, String especie, int idade, float largura, float comprimento, float altura) {
        this.nome = nome;
        this.cor = cor;
        this.especie = especie;
        this.idade = idade;
        this.largura = largura;
        this.comprimento = comprimento;
        this.altura = altura;
    }

    public Animal(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getLargura() {
        return largura;
    }

    public void setLargura(float largura) {
        this.largura = largura;
    }

    public float getComprimento() {
        return comprimento;
    }

    public void setComprimento(float comprimento) {
        this.comprimento = comprimento;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float calculaEspacoOcupado(){
        return this.altura * this.comprimento;   
    }

    public String toString() {
        return "Nome:'" + getNome() + "'" +
                ", Cor: '" + getCor() + "'" +
                ", Especie: '" + getEspecie() + "'" +
                ", Idade: '" + getIdade() + "'" +
                ", Largura: '" + getLargura() + "'" +
                ", Comprimento: '" + getComprimento() + "'" +
                ", Altura: '" + getAltura() + "'";
    }

}
