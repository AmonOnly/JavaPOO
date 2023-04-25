package dados;

public abstract class Animal {
    protected String nome; // dito pelo professor para usar o protected

    public abstract String emitirSom();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
