package dados;

import java.util.*;

public class Equipe<T> {
    private String nome;
    private List<T> lista = new LinkedList<>();
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<T> getLista() {
        return lista;
    }
    public void setLista(List<T> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        String returne = "";
        for(int i = 0; i < this.lista.size();i++){
            returne += "|"+ lista.get(i).toString();
        }
        return returne;
    }
}
