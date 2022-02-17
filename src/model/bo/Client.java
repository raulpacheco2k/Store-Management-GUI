package model.bo;

import java.util.Date;

public class Client extends Pessoa {
    private int idCliente;
    private Date dtNasc;
    private String cpfCliente;
    private String rgCliente;
    private String foneCliente;
    private String fone2Cliente;

    public Client() {
    }

    public Client(int idClinete, Date dtNasc, String cpfCliente, String rgCliente, String foneCliente, String fone2Cliente, String nome, String email, String compleEndereco, Endereco endereco) {
        super(nome, email, compleEndereco, endereco);
        this.idCliente = idClinete;
        this.dtNasc = dtNasc;
        this.cpfCliente = cpfCliente;
        this.rgCliente = rgCliente;
        this.foneCliente = foneCliente;
        this.fone2Cliente = fone2Cliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDtNasc() {
        return this.dtNasc;
    }

    public java.sql.Date getDtNascToSql() {
        java.util.Date utilDate = this.getDtNasc();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        return sqlDate;
    }

    public void setDtNasc(Date dtNasc) {
        this.dtNasc = dtNasc;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public String getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(String rgCliente) {
        this.rgCliente = rgCliente;
    }

    public String getFoneCliente() {
        return foneCliente;
    }

    public void setFoneCliente(String foneCliente) {
        this.foneCliente = foneCliente;
    }

    public String getFone2Cliente() {
        return fone2Cliente;
    }

    public void setFone2Cliente(String fone2Cliente) {
        this.fone2Cliente = fone2Cliente;
    }

    @Override
    public String toString() {
        return this.getIdCliente() + "," +
                super.toString() + "," +
                this.getCpfCliente() + "," +
                this.getRgCliente() + "," +
                this.getDtNasc() + "," +
                this.getFoneCliente() + "," +
                this.getFone2Cliente();
    }
}
