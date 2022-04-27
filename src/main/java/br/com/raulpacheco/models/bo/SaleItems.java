package br.com.raulpacheco.models.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class SaleItems  {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;
    private int sale_id;
    private int productCharacteristics_id;
    private float quantity;
    private float unitaryValue;

    public SaleItems() {
    }

    public SaleItems(int id, int sale_id, int productCharacteristics_id, float quantity, float unitaryValue) {
        this.id = id;
        this.sale_id = sale_id;
        this.productCharacteristics_id = productCharacteristics_id;
        this.quantity = quantity;
        this.unitaryValue = unitaryValue;
    }

    public int getId() {
        return id;
    }

    public SaleItems setId(int id) {
        this.id = id;
        return this;
    }

    public int getSale_id() {
        return sale_id;
    }

    public SaleItems setSale_id(int sale_id) {
        this.sale_id = sale_id;
        return this;
    }

    public int getProductCharacteristics_id() {
        return productCharacteristics_id;
    }

    public SaleItems setProductCharacteristics_id(int productCharacteristics_id) {
        this.productCharacteristics_id = productCharacteristics_id;
        return this;
    }

    public float getQuantity() {
        return quantity;
    }

    public SaleItems setQuantity(float quantity) {
        this.quantity = quantity;
        return this;
    }

    public float getUnitaryValue() {
        return unitaryValue;
    }

    public SaleItems setUnitaryValue(float unitaryValue) {
        this.unitaryValue = unitaryValue;
        return this;
    }
}
