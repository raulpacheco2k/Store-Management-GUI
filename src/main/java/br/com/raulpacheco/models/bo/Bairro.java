package br.com.raulpacheco.models.bo;

import javax.persistence.*;
import java.sql.ResultSet;
import java.sql.SQLException;

@Entity
@Table(name = "bairro")
public class Bairro {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @Column(name = "idbairro")
    private int id;

    @Column(name = "descricaoBairro")
    private String description;

    public Bairro() {
    }

    public Bairro(ResultSet resultSet) throws SQLException {
        this.setIdBairro(resultSet.getInt("idBairro"));
        this.setDescricaoBairro(resultSet.getString("descricaoBairro"));
    }

    public Bairro(int idBairro, String description) {
        this.id = idBairro;
        this.description = description;
    }

    public int getIdBairro() {
        return id;
    }

    public void setIdBairro(int idBairro) {
        this.id = idBairro;
    }

    public String getDescricaoBairro() {
        return description;
    }

    public void setDescricaoBairro(String description) {
        this.description = Bairro.this.description;
    }

    @Override
    public String toString() {
        return this.getDescricaoBairro();
    }
}