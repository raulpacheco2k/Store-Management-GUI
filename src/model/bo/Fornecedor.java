package model.bo;

public class Fornecedor extends Pessoa {

    private int idFornecedor;
    private String razaoSocialFornecedor;
    private String cnpjFornecedor;
    private String inscEstadualFornecedor;

    public Fornecedor() {
        setTable("fornecedor");
    }

    public Fornecedor(String razaoSocialFornecedor, String cnpjFornecedor, String inscEstadualFornecedor, String nome, String email, String compleEndereco, Endereco endereco) {
        super(nome, email, compleEndereco, endereco);
        this.razaoSocialFornecedor = razaoSocialFornecedor;
        this.cnpjFornecedor = cnpjFornecedor;
        this.inscEstadualFornecedor = inscEstadualFornecedor;
        setTable("fornecedor");
    }

    public int getIdFornecedor() {
        return idFornecedor;
    }

    public void setIdFornecedor(int idFornecedor) {
        this.idFornecedor = idFornecedor;
    }

    public String getRazaoSocialFornecedor() {
        return razaoSocialFornecedor;
    }

    public void setRazaoSocialFornecedor(String razaoSocialFornecedor) {
        this.razaoSocialFornecedor = razaoSocialFornecedor;
    }

    public String getCnpjFornecedor() {
        return cnpjFornecedor;
    }

    public void setCnpjFornecedor(String cnpjFornecedor) {
        this.cnpjFornecedor = cnpjFornecedor;
    }

    public String getInscEstadualFornecedor() {
        return inscEstadualFornecedor;
    }

    public void setInscEstadualFornecedor(String inscEstadualFornecedor) {
        this.inscEstadualFornecedor = inscEstadualFornecedor;
    }


    @Override
    public String toString() {
        return this.getIdFornecedor() + "," +
                this.getNome() + "," +
                this.getRazaoSocialFornecedor() + "," +
                this.getCnpjFornecedor() + "," +
                this.getInscEstadualFornecedor() + "," +
                this.getEmail() + "," +
                this.getEndereco().getCidade() + "," +
                this.getEndereco().getBairro() + "," +
                this.getEndereco().getCepCep() + "," +
                this.getEndereco().getLogradouroCep() +
                this.getCompleEndereco();

    }

    @Override
    public String insert() {
        return "INSERT INTO fornecedor (razaoSocialFornecedor, nomeFantasiaFornecedor, cnpjFornecedor, inscEstadualFornecedor, emailFornecedor, compleEnderecofornecedor, endereco_idcep) VALUES (?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String findAll() {
        return "SELECT idfornecedor, razaoSocialFornecedor, nomeFantasiaFornecedor, cnpjFornecedor, inscEstadualFornecedor, emailFornecedor, compleEnderecofornecedor, endereco_idcep FROM " + getTable();
    }

    @Override
    public String findById() {
        return "SELECT idfornecedor, razaoSocialFornecedor, nomeFantasiaFornecedor, cnpjFornecedor, inscEstadualFornecedor, emailFornecedor, compleEnderecofornecedor, endereco_idcep FROM " + getTable() + " WHERE idfornecedor = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idfornecedor, razaoSocialFornecedor, nomeFantasiaFornecedor, cnpjFornecedor, inscEstadualFornecedor, emailFornecedor, compleEnderecofornecedor, endereco_idcep FROM " + getTable() + " WHERE " + string + " = ?";
    }

    @Override
    public String update() {
        return null;
    }

    @Override
    public String delete() {
        return null;
    }
}
