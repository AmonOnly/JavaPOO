package dados;

public class Aluno {
    private String nome;
    private int idade;
    private double[] notas = new double[5];
    private int quantidadeNotas = 0;
    public Aluno() {
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public double[] getNotas() {
        return notas;
    }
    public void setNotas(double notas) {
        if(this.quantidadeNotas > 4){
            return;
        }
        this.notas[quantidadeNotas] = notas;
        this.quantidadeNotas +=1;
    } 

    public double calcularMedia(){
        double a = 0;
        for(int i = 0; i < this.notas.length; i++){
            a += notas[i];
        }
        return a/this.notas.length;
    }
    public String toString(){
        return "Nome: "+this.nome+"/ Idade: "+this.idade+"/ Média: " + calcularMedia();
    }
    
}
