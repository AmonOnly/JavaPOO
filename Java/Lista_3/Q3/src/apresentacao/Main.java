package apresentacao;
import dados.*;
public class Main {
    public static void main(String[] args) {
        Digrafo digrafo = new Digrafo();
        Grafo grafo = new Grafo();
        
        grafo.adicionarVertice();
        grafo.adicionarVertice();
        grafo.adicionarVertice();
        grafo.adicionarVertice();
        grafo.adicionarAresta(1, 2);
        grafo.adicionarAresta(3, 0);
        digrafo.adicionarVertice();
        digrafo.adicionarVertice();
        digrafo.adicionarVertice();
        digrafo.adicionarVertice();
        digrafo.adicionarAresta(3, 2);
        digrafo.adicionarAresta(0, 2);

        System.out.println("Digrafo: ");
        System.out.println(digrafo.toString());
        System.out.println("Grafo: ");
        System.out.println(grafo.toString());

    }
    
}
