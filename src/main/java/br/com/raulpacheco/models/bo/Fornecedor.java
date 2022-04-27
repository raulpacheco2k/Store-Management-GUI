package br.com.raulpacheco.models.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fornecedor")
public class Fornecedor extends Pessoa {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int idFornecedor;
    private String razaoSocialFornecedor;
    private String cnpjFornecedor;
    private String inscEstadualFornecedor;
    public int idEndereco;

    public Fornecedor() {
    }

    public Fornecedor(String razaoSocialFornecedor, String cnpjFornecedor, String inscEstadualFornecedor, String nome, String email, String compleEndereco, Endereco endereco) {
        super(nome, email, compleEndereco, endereco);
        this.razaoSocialFornecedor = razaoSocialFornecedor;
        this.cnpjFornecedor = cnpjFornecedor;
        this.inscEstadualFornecedor = inscEstadualFornecedor;
        this.idEndereco = endereco.getIdCep();
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

    public Endereco getEndereco() {
        return super.getEndereco();
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
}
