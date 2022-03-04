/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package model.bo;

public class ProductType extends Model {
    private int id;
    private String description;

    public ProductType() {
        setTable("tipoproduto");
    }

    public ProductType(int id, String description) {
        this.id = id;
        this.description = description;
        setTable("tipoproduto");
    }

    public int getId() {
        return id;
    }

    public ProductType setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ProductType setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String insert() {
        return "INSERT INTO " + this.getTable() + " (descricaoTipoProduto) VALUES (?)";
    }

    @Override
    public String findAll() {
        return "SELECT idtipoProduto, descricaoTipoProduto FROM" + this.getTable();
    }

    @Override
    public String findById() {
        return "SELECT idtipoProduto, descricaoTipoProduto FROM" + this.getTable() + "WHERE idtipoProduto = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idtipoProduto, descricaoTipoProduto FROM" + this.getTable() + "WHERE " + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE " + this.getTable() + "SET descricaoTipoProduto = ? WHERE idtipoProduto = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
