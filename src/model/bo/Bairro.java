package model.bo;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Bairro {
    private int idBairro;
    private String descricaoBairro;

    public Bairro() {
    }

    public Bairro(ResultSet resultSet) throws SQLException {
        this.setIdBairro(resultSet.getInt("idBairro"));
        this.setDescricaoBairro(resultSet.getString("descricaoBairro"));
    }

    public Bairro(int idBairro, String descricaoBairro) {
        this.idBairro = idBairro;
        this.descricaoBairro = descricaoBairro;
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
        return this.getIdBairro() + "," + this.getDescricaoBairro();
    }
}