/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package br.com.raulpacheco.models.bo;

public class PurchaseItems extends Model {
    private int id;
    private int purchase_id;
    private int productCharacteristics_id;
    private float quantity;
    private float unitaryValue;

    public PurchaseItems() {
        setTable("itenscompra");
    }

    public PurchaseItems(int id, int purchase_id, int productCharacteristics_id, float quantity, float unitaryValue) {
        this.id = id;
        this.purchase_id = purchase_id;
        this.productCharacteristics_id = productCharacteristics_id;
        this.quantity = quantity;
        this.unitaryValue = unitaryValue;
        setTable("itenscompra");
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

    @Override
    public String insert() {
        return "INSERT INTO " + this.getTable() + " (compra_idcompra, caracteristicaProduto_idCaracterisitcaProduto, qtdProduto, valunitarioProduto) VALUES (?, ?, ?, ?)";
    }

    @Override
    public String findAll() {
        return "SELECT iditensCompra, compra_idcompra, caracteristicaProduto_idCaracterisitcaProduto, qtdProduto, valunitarioProduto FROM " + this.getTable();
    }

    @Override
    public String findById() {
        return "SELECT iditensCompra, compra_idcompra, caracteristicaProduto_idCaracterisitcaProduto, qtdProduto, valunitarioProduto FROM " + this.getTable() + " WHERE idtipoProduto = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT iditensCompra, compra_idcompra, caracteristicaProduto_idCaracterisitcaProduto, qtdProduto, valunitarioProduto FROM " + this.getTable() + " WHERE " + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE " + this.getTable() + " SET compra_idcompra = ?, caracteristicaProduto_idCaracterisitcaProduto = ?, qtdProduto = ?, valunitarioProduto = ? WHERE iditensCompra = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
