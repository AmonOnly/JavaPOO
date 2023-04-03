package dados;

public class Avaliacao {
    private String nome,data;
    private int peso;
    private double nota;
    public Avaliacao(String nome, String data, int peso, double nota) {
        this.nome = nome;
        this.data = data;
        this.peso = peso;
        this.nota = nota;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        this.peso = peso;
    }
    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }
    
}
