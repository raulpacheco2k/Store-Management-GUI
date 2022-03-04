/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package model.bo;

import java.util.Date;

public class Receive extends Model {
    private int id;
    private int sale_id;
    private Date dateIssuance;
    private Date dueDate;
    private Date payDate;
    private float issuanceValue;
    private float addition;
    private float discount;
    private float amountPaid;
    private int status;

    public Receive() {
        setTable("receber");
    }

    public Receive(int id, int sale_id, Date dateIssuance, Date dueDate, Date payDate, float issuanceValue, float addition, float discount, float amountPaid, int status) {
        this.id = id;
        this.sale_id = sale_id;
        this.dateIssuance = dateIssuance;
        this.dueDate = dueDate;
        this.payDate = payDate;
        this.issuanceValue = issuanceValue;
        this.addition = addition;
        this.discount = discount;
        this.amountPaid = amountPaid;
        this.status = status;
        setTable("receber");
    }

    public int getId() {
        return id;
    }

    public Receive setId(int id) {
        this.id = id;
        return this;
    }

    public int getSale_id() {
        return sale_id;
    }

    public Receive setSale_id(int sale_id) {
        this.sale_id = sale_id;
        return this;
    }

    public Date getDateIssuance() {
        return dateIssuance;
    }

    public Receive setDateIssuance(Date dateIssuance) {
        this.dateIssuance = dateIssuance;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Receive setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Date getPayDate() {
        return payDate;
    }

    public Receive setPayDate(Date payDate) {
        this.payDate = payDate;
        return this;
    }

    public float getIssuanceValue() {
        return issuanceValue;
    }

    public Receive setIssuanceValue(float issuanceValue) {
        this.issuanceValue = issuanceValue;
        return this;
    }

    public float getAddition() {
        return addition;
    }

    public Receive setAddition(float addition) {
        this.addition = addition;
        return this;
    }

    public float getDiscount() {
        return discount;
    }

    public Receive setDiscount(float discount) {
        this.discount = discount;
        return this;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public Receive setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Receive setStatus(int status) {
        this.status = status;
        return this;
    }

    @Override
    public String insert() {
        return "INSERT INTO receber (venda_idvenda, dtHrEmissaoRec, valEmissaoRec, dtVencimentoRec, dtPgtoRec, acrescimeRec, descontoRec, valPagoRec, statusRec) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    public String findAll() {
        return "SELECT idreceber, venda_idvenda, dtHrEmissaoRec, valEmissaoRec, dtVencimentoRec, dtPgtoRec, acrescimeRec, descontoRec, valPagoRec, statusRec FROM receber";
    }

    @Override
    public String findById() {
        return "SELECT idreceber, venda_idvenda, dtHrEmissaoRec, valEmissaoRec, dtVencimentoRec, dtPgtoRec, acrescimeRec, descontoRec, valPagoRec, statusRec FROM receber WHERE idpagar = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idreceber, venda_idvenda, dtHrEmissaoRec, valEmissaoRec, dtVencimentoRec, dtPgtoRec, acrescimeRec, descontoRec, valPagoRec, statusRec FROM receber WHERE" + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE receber SET venda_idvenda = ?, dtHrEmissaoRec = ?, valEmissaoRec = ?, dtVencimentoRec = ?, dtPgtoRec = ?, acrescimeRec = ?, descontoRec = ?, valPagoRec = ?, statusRec = ? WHERE idreceber = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
