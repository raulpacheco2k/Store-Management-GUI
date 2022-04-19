/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package br.com.raulpacheco.models.bo;

public class Size extends Model {
    private int id;
    private String description;

    public Size() {
        setTable("tamanho");
    }

    public Size(int id, String description) {
        this.id = id;
        this.description = description;
        setTable("tamanho");

    }

    public int getId() {
        return id;
    }

    public Size setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Size setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String insert() {
        return "INSERT INTO " + this.getTable() + " (descricaoTamanho) VALUES (?)";
    }

    @Override
    public String findAll() {
        return "SELECT idtamanho, descricaoTamanho FROM " + this.getTable();
    }

    @Override
    public String findById() {
        return "SELECT idtamanho, descricaoTamanho FROM " + this.getTable() + " WHERE idtamanho = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idtamanho, descricaoTamanho FROM " + this.getTable() + " WHERE " + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE " + this.getTable() + " SET descricaoTamanho = ? WHERE idtamanho = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
