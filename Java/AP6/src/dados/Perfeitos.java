package dados;

public class Perfeitos extends Gerador {
    public Perfeitos(){
        super();
    }


    public void gerar(int n){
        for(int i = 1; sequencia.size() != n;i++){
            if(verificaPerfeito(i)){
                sequencia.add(i);
            }
        }
    }
    
    private boolean verificaPerfeito(int n){
        int k = 0;
        for(int i = 1; i < n;i++){
            if(n%i == 0){
                k+= i;
            }
        }
        if(k == n){
            return true;
        }
        return false;
    }
    
}
