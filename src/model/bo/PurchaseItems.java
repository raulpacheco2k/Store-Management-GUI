/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package model.bo;

public class PurchaseItems {
    private int id;
    private int purchase_id;
    private int productCharacteristics_id;
    private float quantity;
    private float unitaryValue;

    public PurchaseItems() {
    }

    public PurchaseItems(int id, int purchase_id, int productCharacteristics_id, float quantity, float unitaryValue) {
        this.id = id;
        this.purchase_id = purchase_id;
        this.productCharacteristics_id = productCharacteristics_id;
        this.quantity = quantity;
        this.unitaryValue = unitaryValue;
    }

    public int getId() {
        return id;
    }

    public PurchaseItems setId(int id) {
        this.id = id;
        return this;
    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public PurchaseItems setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
        return this;
    }

    public int getProductCharacteristics_id() {
        return productCharacteristics_id;
    }

    public PurchaseItems setProductCharacteristics_id(int productCharacteristics_id) {
        this.productCharacteristics_id = productCharacteristics_id;
        return this;
    }

    public float getQuantity() {
        return quantity;
    }

    public PurchaseItems setQuantity(float quantity) {
        this.quantity = quantity;
        return this;
    }

    public float getUnitaryValue() {
        return unitaryValue;
    }

    public PurchaseItems setUnitaryValue(float unitaryValue) {
        this.unitaryValue = unitaryValue;
        return this;
    }
}
