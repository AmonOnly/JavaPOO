package PR2_2_Dados;

public class Animais {
    private String nome,especie,descricao;
    private Dono dono;
    public Animais(){
        
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getEspecie(){
        return this.especie;
    }
    public void setEspecie(String especie){
        this.especie = especie;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public Dono getDono(){
        return this.dono;
    }
    public void setDono(Dono dono){
        this.dono = dono;
    }
    public String toString(){
        String animalString = "";
        animalString += "Nome: "+this.nome+"\nEspécie: "+this.especie+"\nDescrição: "+this.descricao;
        if(this.dono != null)
            animalString += "\nDono: "+this.dono.toString();
        return animalString;

    }
}

