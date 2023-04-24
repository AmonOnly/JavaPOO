package dados;

public class NumeroPrimos extends Gerador {
    public NumeroPrimos(){
        super();
    }

    public void gerar(int n){
        for(int i = 1;sequencia.size() != n;i++){
            if(ehPrimo(i)){
                sequencia.add(i);
            }
        }
    }
    public boolean ehPrimo(int n){
        int k = 0;
        for(int i = 2; i <= n;i++){
            if(n%i == 0){
                k++;
            }
        }
        if(k > 1){
            return false;
        }
        return true;
    }

    
}
