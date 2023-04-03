package dados;

import java.util.ArrayList;

public class Diciplina {
    private String nome;
    private int idDiciplina;
    private ArrayList<Avaliacao> notas;
    public Diciplina(String nome, int idDiciplina, ArrayList<Avaliacao> notas) {
        this.nome = nome;
        this.idDiciplina = idDiciplina;
        this.notas = notas;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdDiciplina() {
        return idDiciplina;
    }
    public void setIdDiciplina(int idDiciplina) {
        this.idDiciplina = idDiciplina;
    }
    public ArrayList<Avaliacao> getNotas() {
        return notas;
    }
    public void setNotas(ArrayList<Avaliacao> notas) {
        this.notas = notas;
    }

    
}
