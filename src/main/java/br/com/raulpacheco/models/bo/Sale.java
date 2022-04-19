/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package br.com.raulpacheco.models.bo;

import java.util.Date;

public class Sale extends Model {
    private int id;
    private String serie;
    private Date date;
    private String hour;
    private float discountValue;
    private float totalValue;
    private int client_id;
    private int paymentCondition_id;
    private int dueDay;
    private int seller_id;

    public Sale() {
    }

    public Sale(int id, String serie, Date date, String hour, float discountValue, float totalValue, int client_id, int paymentCondition_id, int dueDay, int seller_id) {
        this.id = id;
        this.serie = serie;
        this.date = date;
        this.hour = hour;
        this.discountValue = discountValue;
        this.totalValue = totalValue;
        this.client_id = client_id;
        this.paymentCondition_id = paymentCondition_id;
        this.dueDay = dueDay;
        this.seller_id = seller_id;
    }

    public int getId() {
        return id;
    }

    public Sale setId(int id) {
        this.id = id;
        return this;
    }

    public String getSerie() {
        return serie;
    }

    public Sale setSerie(String serie) {
        this.serie = serie;
        return this;
    }

    public Date getDate() {
        return date;
    }

    public Sale setDate(Date date) {
        this.date = date;
        return this;
    }

    public String getHour() {
        return hour;
    }

    public Sale setHour(String hour) {
        this.hour = hour;
        return this;
    }

    public float getDiscountValue() {
        return discountValue;
    }

    public Sale setDiscountValue(float discountValue) {
        this.discountValue = discountValue;
        return this;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public Sale setTotalValue(float totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public int getClient_id() {
        return client_id;
    }

    public Sale setClient_id(int client_id) {
        this.client_id = client_id;
        return this;
    }

    public int getPaymentCondition_id() {
        return paymentCondition_id;
    }

    public Sale setPaymentCondition_id(int paymentCondition_id) {
        this.paymentCondition_id = paymentCondition_id;
        return this;
    }

    public int getDueDay() {
        return dueDay;
    }

    public Sale setDueDay(int dueDay) {
        this.dueDay = dueDay;
        return this;
    }

    public int getSeller_id() {
        return seller_id;
    }

    public Sale setSeller_id(int seller_id) {
        this.seller_id = seller_id;
        return this;
    }

    @Override
    public String insert() {
        return "INSERT INTO venda (serieVenda, dtVenda, hrVenda, valDescontoVenda, valTotalVenda, cliente_idcliente, condicaoPagamento_idcondicaoPagamento, diaVencimentoParcela, vendedor_idvendedor) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String findAll() {
        return "SELECT idvenda, serieVenda, dtVenda, hrVenda, valDescontoVenda, valTotalVenda, cliente_idcliente, condicaoPagamento_idcondicaoPagamento, diaVencimentoParcela, vendedor_idvendedor FROM venda";
    }

    @Override
    public String findById() {
        return "SELECT idvenda, serieVenda, dtVenda, hrVenda, valDescontoVenda, valTotalVenda, cliente_idcliente, condicaoPagamento_idcondicaoPagamento, diaVencimentoParcela, vendedor_idvendedor WHERE idvenda = ? ";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idvenda, serieVenda, dtVenda, hrVenda, valDescontoVenda, valTotalVenda, cliente_idcliente, condicaoPagamento_idcondicaoPagamento, diaVencimentoParcela, vendedor_idvendedor WHERE " + string + "?";
    }

    @Override
    public String update() {
        return "UPDATE venda SET serieVenda = ?, dtVenda = ?, hrVenda = ?, valDescontoVenda = ?, valTotalVenda = ?, cliente_idcliente = ?, condicaoPagamento_idcondicaoPagamento = ?, diaVencimentoParcela = ?, vendedor_idvendedor = ?  idvenda = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
