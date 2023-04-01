package negocio;
import java.util.*;
import dados.*;

public class ListaTelefonica {
    private Map<Character,List<Contato>> contatos = new HashMap<Character,List<Contato>>();

    public ListaTelefonica(){
        for(char i = 'A'; i < 'Z';i++){
            List<Contato> listaCont = new LinkedList<Contato>();
            this.contatos.put(i, listaCont);
        }
    }
    
    public void adicionarContato(Contato contato){
        String nome = contato.getNomeContato().toUpperCase();
        this.contatos.get(nome.charAt(0)).add(contato);
    }

    public void removerContato(Contato contato){
       String nome = contato.getNomeContato().toUpperCase();
       this.contatos.get(nome.charAt(0)).remove(contato);
    }

    public List<Contato> buscarContatos(char letra){
        return this.contatos.get(letra);
    }
    public Map<Character,List<Contato>> buscarContatos(){
        return this.contatos;
    }
}
