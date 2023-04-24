package dados;

public class Quadrados extends Gerador {
    public Quadrados(){
        super();
    }

    public void gerar(int n){
        for(int i = 1; i <= n;i++){
            sequencia.add(i*i);
        }
    }

    
}
