/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package model.bo;

public abstract class Model implements HasTable {
    private String table;

    public Model(String table) {
        this.table = table;
    }

    public String getTable() {
        return table;
    }
}
