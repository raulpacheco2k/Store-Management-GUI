package br.com.raulpacheco.models.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProductType  {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
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
