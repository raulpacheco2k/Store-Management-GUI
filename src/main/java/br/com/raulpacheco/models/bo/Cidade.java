package br.com.raulpacheco.models.bo;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table(name = "cidade")
public final class Cidade {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int idCidade;
    private String descricaoCidade;
    private String ufCidade;

    public Cidade() {
    }

    public Cidade(ResultSet resultSet) throws SQLException {
        this.setIdCidade(resultSet.getInt("idCidade"));
        this.setDescricaoCidade(resultSet.getString("descricaoCidade"));
        this.setUfCidade(resultSet.getString("ufCidade"));
    }

    public Cidade(int idCidade, String descricaoCidade, String ufCidade) {
        this.idCidade = idCidade;
        this.descricaoCidade = descricaoCidade;
        this.ufCidade = ufCidade;
    }

    public int getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }

    public String getDescricaoCidade() {
        return descricaoCidade;
    }

    public void setDescricaoCidade(String descricaoCidade) {
        this.descricaoCidade = descricaoCidade;
    }

    public String getUfCidade() {
        return ufCidade;
    }

    public void setUfCidade(String ufCidade) {
        this.ufCidade = ufCidade;
    }

    @Override
    public String toString() {
        return this.getDescricaoCidade();
    }

    public void setId(int id) {
        this.idCidade = id;
    }

    public int getId() {
        return this.idCidade;
    }
}
