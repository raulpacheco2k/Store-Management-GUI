package br.com.raulpacheco.models.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table(name = "cidade")
public final class Cidade {
    @Column
    private int idCidade;
    @Column
    private String descricaoCidade;
    @Column
    private String ufCidade;
    @Column
    private String table;
    @Id
    private Long id;

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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
