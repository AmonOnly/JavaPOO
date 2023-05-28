package dados;

import java.util.*;

public class Avaliacao {
    private String nome;
    private Date data;
    private int peso;
    private double nota;
    public Avaliacao(){}
    public Avaliacao(String nome, Date data, int peso, double nota) {
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
    public Date getData() {
        return data;
    }
    public void setData(Date data) {
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

    @Override
    public String toString() {
        return "Avaliação: " + this.nome + "Data: " + this.data + "Nota: " + this.nota;
    }
    
}
