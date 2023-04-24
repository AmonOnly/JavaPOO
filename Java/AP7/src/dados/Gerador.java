package dados;
import java.util.*;;

public abstract class Gerador implements Isequencia{
    protected List<Integer> sequencia = new ArrayList<Integer>();
    public Gerador(){};

    public abstract void gerar(int quantidade);
    public List<Integer> getSequencia() {
        return this.sequencia;
    }

    public int sortear(){
        Random ran = new Random();
        return sequencia.get(ran.nextInt(this.sequencia.size()+1));
    }

    public long somatorio(){
        long soma = 0;
        for(int i = 0;i<this.sequencia.size();i++){
            soma += this.sequencia.get(i);
        }
        return soma;
    }

    public double mediaAritimetica(){
        double soma = (double) somatorio();
        return (soma/this.sequencia.size());
    }

    public double mediaGeometrica(){
        double produtorio = 0;
        for(int i = 0;i<this.sequencia.size();i++){
            produtorio *= this.sequencia.get(i);
        }
        return Math.pow(produtorio,1/sequencia.size());

    }

    public double variancia(){
        double media = mediaAritimetica();
        double subtracao = 0;
        for(int i = 0;i<sequencia.size();i++){
            subtracao += Math.pow(sequencia.get(i)-media,2);
        }
        return subtracao/(sequencia.size()-1);
    }
    public double desvioPadrao(){
        return Math.sqrt(variancia());
    }
    public Long amplitude(){
        long menor = sequencia.get(0);
        long maior = sequencia.get(0);
        for(int i = 0;i< sequencia.size();i++){
            if(menor > sequencia.get(i)){
                menor = sequencia.get(i);
            }
            if(maior < sequencia.get(i)){
                maior = sequencia.get(i);
            }
        }
        return (maior - menor);
    }
    
}


    
