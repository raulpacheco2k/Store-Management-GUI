package br.com.raulpacheco.models.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table(name = "bairro")
public class Bairro extends Model {
    @Id
    private int idBairro;

    @Column
    private String descricaoBairro;

    public Bairro() {
        setTable("bairro");
    }

    public Bairro(ResultSet resultSet) throws SQLException {
        this.setIdBairro(resultSet.getInt("idBairro"));
        this.setDescricaoBairro(resultSet.getString("descricaoBairro"));
        setTable("bairro");
    }

    public Bairro(int idBairro, String descricaoBairro) {
        this.idBairro = idBairro;
        this.descricaoBairro = descricaoBairro;
        setTable("bairro");
    }

    public int getIdBairro() {
        return idBairro;
    }

    public void setIdBairro(int idBairro) {
        this.idBairro = idBairro;
    }

    public String getDescricaoBairro() {
        return descricaoBairro;
    }

    public void setDescricaoBairro(String descricaoBairro) {
        this.descricaoBairro = descricaoBairro;
    }

    @Override
    public String toString() {
        return this.getDescricaoBairro();
    }

    @Override
    public String insert() {
        return "INSERT INTO " + getTable() + " (descricaoBairro) VALUES(?)";
    }

    @Override
    public String findAll() {
        return "SELECT idbairro, descricaoBairro FROM " + getTable();
    }

    @Override
    public String findById() {
        return " SELECT idbairro, descricaoBairro FROM " + getTable() + " WHERE idbairro = ?";
    }

    @Override
    public String findByField(String field) {
        return "SELECT idbairro, descricaoBairro FROM " + getTable() + " WHERE" + field + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE " + getTable() + " SET descricaoBairro = ? WHERE idbairro = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}