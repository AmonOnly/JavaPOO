package negocios;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import dados.*;

public class Sistema {
    private Comparator<Pessoa> 
    private Map<Integer,List<Pessoa>> pessoaIdade = new HashMap<Integer,List<Pessoa>>();
    Sistema(){
        for(int i = 0 ; i < 5;i++){
          List<Pessoa> pessoas = new LinkedList<Pessoa>();
          pessoaIdade.put(i, pessoas);
        }
    }
    // id para idade de 1 até 12 é 0
    // id para idade de 13 até 18 é 1
    // id para idade de 19 até 25 é 2
    // id para idade de 26 até 59 é 3
    // id para idade de 60 ou mais é 4

    public boolean faixaEtaria(int a,int b,int c){
        if(c >= a && c <= b){
            return true;
        }
        return false;
    }
    public void adicionarPessoa(Pessoa pessoa){
        if(faixaEtaria(1, 12, pessoa.getIdade())){
            pessoaIdade.get(0).add(pessoa);
        }
        if(faixaEtaria(13, 18, pessoa.getIdade())){
            pessoaIdade.get(1).add(pessoa);
        }
        if(faixaEtaria(19, 25, pessoa.getIdade())){
            pessoaIdade.get(2).add(pessoa);
        }
        if(faixaEtaria(26, 59, pessoa.getIdade())){
            pessoaIdade.get(3).add(pessoa);
        }
        else{
            pessoaIdade.get(4).add(pessoa);
        }
    }

    public void sortList(){
        for(int i = 0; i < 5; i++){
            this.pessoaIdade.get(i).sort(null);
        }
    }
}
