package Dados;

public class Cidade {
    private String cidade,estado;
    public String getCidade(){
        return this.cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public String getEstado(){
        return this.estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }

    public String toString(){
        return
            "cidade: " + this.cidade + " " + "Estado: " + this.estado + " ";
    }
}

