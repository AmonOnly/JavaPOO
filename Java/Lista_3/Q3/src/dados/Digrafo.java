package dados;
import java.util.*;;

public class Digrafo {
    private Map<Integer,List<Integer>> matrizAdjacencia2 = new HashMap<Integer,List<Integer>>();
    
    public void adicionarVertice(){
        List<Integer> vertices = new LinkedList<>();
        for(int i = 0; i < matrizAdjacencia2.size()+1;i++){
            vertices.add(0);
        }
        System.out.println("matriz size:"+ matrizAdjacencia2.size());
        int k = matrizAdjacencia2.size();
        matrizAdjacencia2.put(k, vertices);
        for(int i = 0; i < matrizAdjacencia2.size();i++){
            this.matrizAdjacencia2.get(i).add(0);
        }
    }
    public void adicionarAresta(int origem, int destino){
        if(this.matrizAdjacencia2.containsKey(origem)){
            this.matrizAdjacencia2.get(origem).set(destino, 1);
        }else{System.out.println("não existe essa origem");}
    }

    @Override
    public String toString() {
        String retorno = "  ";
        for(int i = 0; i < matrizAdjacencia2.size();i++){
            retorno += i + " ";
        }
        retorno += "\n";
        for(int i = 0 ; i<matrizAdjacencia2.size();i++){
            retorno += i+ " ";
            for(int in = 0; in < matrizAdjacencia2.size();in++){
                retorno += matrizAdjacencia2.get(i).get(in) + " ";
            }
            retorno += "\n";
        }
        return retorno;
    }
}
