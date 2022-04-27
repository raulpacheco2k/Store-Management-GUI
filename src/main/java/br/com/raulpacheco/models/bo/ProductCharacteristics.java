package br.com.raulpacheco.models.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProductCharacteristics  {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;
    private int idProduct;
    private int idColor;
    private String size;
    private String barCode;
    private float stock;

    public ProductCharacteristics() {
    }

    public ProductCharacteristics(int id, int idProduct, int idColor, String size, String barCode, float stock) {
        this.id = id;
        this.idProduct = idProduct;
        this.idColor = idColor;
        this.size = size;
        this.barCode = barCode;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public ProductCharacteristics setId(int id) {
        this.id = id;
        return this;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public ProductCharacteristics setIdProduct(int idProduct) {
        this.idProduct = idProduct;
        return this;
    }

    public int getIdColor() {
        return idColor;
    }

    public ProductCharacteristics setIdColor(int idColor) {
        this.idColor = idColor;
        return this;
    }

    public String getSize() {
        return size;
    }

    public ProductCharacteristics setSize(String size) {
        this.size = size;
        return this;
    }

    public String getBarCode() {
        return barCode;
    }

    public ProductCharacteristics setBarCode(String barCode) {
        this.barCode = barCode;
        return this;
    }

    public float getStock() {
        return stock;
    }

    public ProductCharacteristics setStock(float stock) {
        this.stock = stock;
        return this;
    }
}
