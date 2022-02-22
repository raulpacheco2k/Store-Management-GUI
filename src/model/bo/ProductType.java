/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package model.bo;

public class ProductType {
    private int id;
    private String description;

    public ProductType() {
    }

    public ProductType(int id, String description) {
        this.id = id;
        this.description = description;
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
}
