package model.bo;
public abstract class Pessoa {
    private String nome;
    private String email;
    private String compleEndereco;
    private Endereco endereco;

    public Pessoa() {
    }

    public Pessoa(String nome, String email, String compleEndereco, Endereco endereco) {
        this.nome = nome;
        this.email = email;
        this.compleEndereco = compleEndereco;
        this.endereco = endereco;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompleEndereco() {
        return compleEndereco;
    }

    public void setCompleEndereco(String compleEndereco) {
        this.compleEndereco = compleEndereco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return  this.getNome() + ","+
                this.getEmail() + ","+
                this.getEndereco().getCepCep() + ","+
                this.getEndereco().getBairro()+ ","+
                this.getEndereco().getCidade()+ ","+
                this.getEndereco().getLogradouroCep()+ ","+
                this.getCompleEndereco() ;
    }
    
    
    
}
