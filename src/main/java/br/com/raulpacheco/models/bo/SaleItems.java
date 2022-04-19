/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package br.com.raulpacheco.models.bo;

public class SaleItems extends Model {
    private int id;
    private int sale_id;
    private int productCharacteristics_id;
    private float quantity;
    private float unitaryValue;

    public SaleItems() {
        setTable("itensvenda");
    }

    public SaleItems(int id, int sale_id, int productCharacteristics_id, float quantity, float unitaryValue) {
        this.id = id;
        this.sale_id = sale_id;
        this.productCharacteristics_id = productCharacteristics_id;
        this.quantity = quantity;
        this.unitaryValue = unitaryValue;
        setTable("itensvenda");
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

    @Override
    public String insert() {
        return "INSERT INTO " + this.getTable() + " (venda_idvenda, caracteristicaProduto_idCaracterisitcaProduto, valunitarioProduto, qtdProduto) VALUES (?, ?, ?, ?)";
    }

    @Override
    public String findAll() {
        return "SELECT idItensVenda, venda_idvenda, caracteristicaProduto_idCaracterisitcaProduto, valunitarioProduto, qtdProduto FROM " + this.getTable();
    }

    @Override
    public String findById() {
        return "SELECT idItensVenda, venda_idvenda, caracteristicaProduto_idCaracterisitcaProduto, valunitarioProduto, qtdProduto FROM " + this.getTable() + " WHERE idtipoProduto = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idItensVenda, venda_idvenda, caracteristicaProduto_idCaracterisitcaProduto, valunitarioProduto, qtdProduto FROM " + this.getTable() + " WHERE " + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE " + this.getTable() + " SET venda_idvenda = ?, caracteristicaProduto_idCaracterisitcaProduto = ?, valunitarioProduto = ?, qtdProduto = ? WHERE idItensVenda = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
