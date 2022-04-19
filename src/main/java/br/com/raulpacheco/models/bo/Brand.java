/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package br.com.raulpacheco.models.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marca")
public class Brand extends Model {
    @Column(name = "idmarca")
    private int id;
    @Column(name = "descricaoMarca")
    private String description;

    public Brand() {
        setTable("marca");
    }

    public Brand(int id, String description) {
        this.id = id;
        this.description = description;
        setTable("marca");
    }

    @Id
    public int getId() {
        return id;
    }

    public Brand setId(int id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Brand setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public String insert() {
        return "INSERT INTO " + this.getTable() + " (descricaoMarca) VALUES (?)";
    }

    @Override
    public String findAll() {
        return "SELECT idmarca, descricaoMarca FROM " + this.getTable();
    }

    @Override
    public String findById() {
        return "SELECT idmarca, descricaoMarca FROM " + this.getTable() + " WHERE idmarca = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idmarca, descricaoMarca FROM " + this.getTable() + " WHERE " + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE " + getTable() + " SET descricaoMarca = ? WHERE idmarca = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
