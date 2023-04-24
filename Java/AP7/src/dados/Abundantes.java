package dados;

public class Abundantes extends Gerador {
    
    public Abundantes(){
        super();
    }

    public void gerar(int n){
        for(int i = 0; sequencia.size() != n;i++){
            if(verificaAbundante(i)){
                sequencia.add(i);
            }
        }
    }
    
    private boolean verificaAbundante(int n){
        int k = 0;
        for(int i = 1; i < n;i++){
            if(n%i == 0){
                k+= i;
            }
        }
        if(k > n){
            return true;
        }
        return false;
    }
    
}
