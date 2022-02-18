package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Endereco {
  private int idCep;
  private String cepCep;
  private String logradouroCep;
  private Bairro bairro;
  private Cidade cidade;

    public Endereco() {
    }

    public Endereco(ResultSet resultSet) throws SQLException {
        this.setIdCep(resultSet.getInt("idcep"));
        this.setCepCep(resultSet.getString("cepCep"));
        this.setLogradouroCep(resultSet.getString("logradouroCep"));
    }

    public Endereco(int idCep, String cepCep, String logradouroCep, Bairro bairro, Cidade cidade) {
        this.idCep = idCep;
        this.cepCep = cepCep;
        this.logradouroCep = logradouroCep;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public int getIdCep() {
        return idCep;
    }

    public void setIdCep(int idCep) {
        this.idCep = idCep;
    }

    public String getCepCep() {
        return cepCep;
    }

    public void setCepCep(String cepCep) {
        this.cepCep = cepCep;
    }

    public String getLogradouroCep() {
        return logradouroCep;
    }

    public void setLogradouroCep(String logradouroCep) {
        this.logradouroCep = logradouroCep;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return this.getCepCep();
    }
}
