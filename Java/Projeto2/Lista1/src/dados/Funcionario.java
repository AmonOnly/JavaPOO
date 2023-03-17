package dados;

public class Funcionario {
    private String nomeFuncionario,setorFuncionario,cpf,telefone;
    private Endereco endereco = new Endereco();

    public Funcionario(String nomeFuncionario, String setorFuncionario, String cpf, String telefone,
            Endereco endereco) {
        this.nomeFuncionario = nomeFuncionario;
        this.setorFuncionario = setorFuncionario;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
    }


    public Funcionario(){

    }
    
    
    public String getNomeFuncionario() {
        return nomeFuncionario;
    }
    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }
    public String getSetorFuncionario() {
        return setorFuncionario;
    }
    public void setSetorFuncionario(String setorFuncionario) {
        this.setorFuncionario = setorFuncionario;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getTelefone() {
        return telefone;
    }
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public Endereco getEndereco() {
        return endereco;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        String funcionarioString = "";
        funcionarioString += "Nome: " + this.nomeFuncionario + "\n" +
        "Setor: " + this.setorFuncionario + "\n" + 
        "Cpf: " + this.cpf + "\n" + 
        "Telefone de Contato: " + this.telefone;
        if(this.endereco != null){
            funcionarioString += "\n Endereço" + this.endereco.toString();
        }
        return funcionarioString;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Funcionario other = (Funcionario) obj;
        if (nomeFuncionario == null) {
            if (other.nomeFuncionario != null)
                return false;
        } else if (!nomeFuncionario.equals(other.nomeFuncionario))
            return false;
        if (setorFuncionario == null) {
            if (other.setorFuncionario != null)
                return false;
        } else if (!setorFuncionario.equals(other.setorFuncionario))
            return false;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        if (telefone == null) {
            if (other.telefone != null)
                return false;
        } else if (!telefone.equals(other.telefone))
            return false;
        return true;
    }
}
