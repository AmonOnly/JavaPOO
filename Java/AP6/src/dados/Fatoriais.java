package dados;

public class Fatoriais extends Gerador {
    public Fatoriais(){
        super();
    }

    public void gerar(int n){
        for(int i = 1;i<=n;i++){
            sequencia.add(fatorial(i));
        }
    }

    public int fatorial(int n){
        int soma = 1;
        for(int i = 1; i <= n;i++){
            soma *=i;
        }
        return soma;
    }
}
