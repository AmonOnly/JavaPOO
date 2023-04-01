package dados;

public class Contato {
    private String nomeContato;
    private long telefoneContato;

    public String getNomeContato() {
        return this.nomeContato;
    }
    public void setNomeContato(String nomeContato) {
        this.nomeContato = nomeContato;
    }
    public long getTelefoneContato() {
        return this.telefoneContato;
    }
    public void setTelefoneContato(long telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String toString() {
        return "nome:" + this.nomeContato + ", telefone" + this.telefoneContato + "\n";
    }
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nomeContato == null) ? 0 : nomeContato.hashCode());
        result = prime * result + (int) (telefoneContato ^ (telefoneContato >>> 32));
        return result;
    }
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Contato other = (Contato) obj;
        if (nomeContato == null) {
            if (other.nomeContato != null)
                return false;
        } else if (!nomeContato.equals(other.nomeContato))
            return false;
        if (telefoneContato != other.telefoneContato)
            return false;
        return true;
    }
    
    

}
