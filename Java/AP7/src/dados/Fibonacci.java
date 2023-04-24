package dados;

public class Fibonacci extends Gerador {
    public Fibonacci(){
        super();
    }

    public void gerar(int n){
        int a = 1;
        int b = 0;
        int c;
        if(n == 0){
            return;
        }
        if(n == 1){
            sequencia.add(0);
            return;
        }
        if(n == 2){
            sequencia.add(0);
            sequencia.add(1);
            return;
        }else{
            sequencia.add(0);
            sequencia.add(1);
            for(int i = 2; i < n;i++){
                c = a + b;
                sequencia.add(c);
                b = a;
                a = c;
            } 
        }

    }
}
