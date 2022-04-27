package br.com.raulpacheco.models.bo;

import javax.persistence.*;

@Entity
@Table(name = "marca")
public class Brand  {
    @Id
    @Column(name = "idmarca")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "descricaoMarca")
    private String description;

    public Brand() {
    }

    public Brand(int id, String description) {
        this.id = id;
        this.description = description;
    }

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
}
