package dados;
import java.util.LinkedList;
import java.util.List;

public class Matriz<T> {
    private int m,n;
    private T[][] matriz;
    
    public Matriz(int m, int n){
        this.m = m;
        this.n = n;
        this.matriz = (T[][]) new Object[m][n];
    }

    public boolean set(T objeto, int i, int j ){
        if(i >= this.m || j >= this.n){
            return false;
        }
        else{
            this.matriz[i][j] = objeto;
            return true;
        }
    }

    public T get(int i, int j){
        if(i >= this.m || j >= this.n){
            return null;
        }else{
            return this.matriz[i][j];
        }
    }

    public List<T> getLinha(int linha){
        List<T> linhas = new LinkedList<>(); 
        for(int i = 0; i < this.n;i++){
            linhas.add(this.matriz[linha][i]);
        }
        return linhas;
    }

    public List<T> getcolunas(int coluna){
        List<T> colunas = new LinkedList<>(); 
        for(int i = 0; i < this.m;i++){
            colunas.add(this.matriz[i][coluna]);
        }
        return colunas;
    }

    public List<T> getElementosQuadrantes(Quadrante quadrantes){
        List<T> aux = new LinkedList<T>();
        if( this.m% 2 != 0 && this.n%2 != 0 ){
            if(quadrantes == Quadrante.PRIMEIRO){
                for(int i = 0;i<(this.m/2) + 1;i++){
                    for(int in = 0; in<(this.n/2)+1;in++){
                        aux.add(this.matriz[i][in]);
                    }
                }
            }
            else if(quadrantes == Quadrante.SEGUNDO){
                for(int i = 0;i<(this.m/2)+1;i++){
                    for(int in = (this.n/2)+1; in<this.n;in++){
                        aux.add(this.matriz[i][in]);
                    }
                }
            }
            else if(quadrantes == Quadrante.TERCEIRO){
                for(int i = (this.m/2)+1;i<this.m;i++){
                    for(int in = 0; in<(this.n/2)+1;in++){
                        aux.add(this.matriz[i][in]);
                    }
                }
            }
            else if(quadrantes == Quadrante.QUARTO){
                for(int i = (this.m/2)+1;i<this.m;i++){
                    for(int in = (this.n/2)+1; in<this.n;in++){
                        aux.add(this.matriz[i][in]);
                    }
                }
            }
        }else{
            if(quadrantes == Quadrante.PRIMEIRO){
                for(int i = 0;i<(this.m/2);i++){
                    for(int in = 0; in<(this.n/2);in++){
                        aux.add(this.matriz[i][in]);
                    }
                }
            }
            else if(quadrantes == Quadrante.SEGUNDO){
                for(int i = 0;i<(this.m/2);i++){
                    for(int in = (this.n/2); in<this.n;in++){
                        aux.add(this.matriz[i][in]);
                    }
                }
            }
            else if(quadrantes == Quadrante.TERCEIRO){
                for(int i = (this.m/2);i<this.m;i++){
                    for(int in = 0; in<(this.n/2);in++){
                        aux.add(this.matriz[i][in]);
                    }
                }
            }
            else if(quadrantes == Quadrante.QUARTO){
                for(int i = (this.m/2);i<this.m;i++){
                    for(int in = (this.n/2); in<this.n;in++){
                        aux.add(this.matriz[i][in]);
                    }
                }
            }
        }
        return aux;
    }
}
