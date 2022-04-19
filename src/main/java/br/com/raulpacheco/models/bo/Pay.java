/*
 * Copyright (c) 2022.
 * Raul Pacheco Domingos (raulpacheco2k)
 * https://github.com/raulpacheco2k
 * https://linkedin.com/in/raulpacheco2k/
 * https://twitter.com/raulpacheco2k
 */

package br.com.raulpacheco.models.bo;

import java.util.Date;

public class Pay extends Model {
    private int id;
    private int purchase_id;
    private Date dateIssuance;
    private Date dueDate;
    private Date payDate;
    private float issuanceValue;
    private float addition;
    private float discount;
    private float amountPaid;
    private int status;

    public Pay() {
        setTable("pagar");
    }

    public Pay(int id, int purchase_id, Date dateIssuance, Date dueDate, Date payDate, float issuanceValue, float addition, float discount, float amountPaid, int status) {
        this.id = id;
        this.purchase_id = purchase_id;
        this.dateIssuance = dateIssuance;
        this.dueDate = dueDate;
        this.payDate = payDate;
        this.issuanceValue = issuanceValue;
        this.addition = addition;
        this.discount = discount;
        this.amountPaid = amountPaid;
        this.status = status;
        setTable("pagar");
    }

    public int getId() {
        return id;
    }

    public Pay setId(int id) {
        this.id = id;
        return this;
    }

    public int getPurchase_id() {
        return purchase_id;
    }

    public Pay setPurchase_id(int purchase_id) {
        this.purchase_id = purchase_id;
        return this;
    }

    public Date getDateIssuance() {
        return dateIssuance;
    }

    public Pay setDateIssuance(Date dateIssuance) {
        this.dateIssuance = dateIssuance;
        return this;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public Pay setDueDate(Date dueDate) {
        this.dueDate = dueDate;
        return this;
    }

    public Date getPayDate() {
        return payDate;
    }

    public Pay setPayDate(Date payDate) {
        this.payDate = payDate;
        return this;
    }

    public float getIssuanceValue() {
        return issuanceValue;
    }

    public Pay setIssuanceValue(float issuanceValue) {
        this.issuanceValue = issuanceValue;
        return this;
    }

    public float getAddition() {
        return addition;
    }

    public Pay setAddition(float addition) {
        this.addition = addition;
        return this;
    }

    public float getDiscount() {
        return discount;
    }

    public Pay setDiscount(float discount) {
        this.discount = discount;
        return this;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public Pay setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
        return this;
    }

    public int getStatus() {
        return status;
    }

    public Pay setStatus(int status) {
        this.status = status;
        return this;
    }

    @Override
    public String insert() {
        return "INSERT INTO pagar (compra_idcompra, dtHrEmissaoPagar, dtVencimentoPagar, valemitidoPagar, acrescimoPagar, descontoPagar, dtHrPgtoPagar, valPagoPagar, statusPagar) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ) ";
    }

    @Override
    public String findAll() {
        return "SELECT idpagar, compra_idcompra, dtHrEmissaoPagar, dtVencimentoPagar, valemitidoPagar, acrescimoPagar, descontoPagar, dtHrPgtoPagar, valPagoPagar, statusPagar FROM pagar";
    }

    @Override
    public String findById() {
        return "SELECT idpagar, compra_idcompra, dtHrEmissaoPagar, dtVencimentoPagar, valemitidoPagar, acrescimoPagar, descontoPagar, dtHrPgtoPagar, valPagoPagar, statusPagar FROM pagar WHERE idpagar = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idpagar, compra_idcompra, dtHrEmissaoPagar, dtVencimentoPagar, valemitidoPagar, acrescimoPagar, descontoPagar, dtHrPgtoPagar, valPagoPagar, statusPagar FROM pagar WHERE" + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE pagar SET compra_idcompra = ?, dtHrEmissaoPagar = ?, dtVencimentoPagar = ?, valemitidoPagar = ?, acrescimoPagar = ?, descontoPagar = ?, dtHrPgtoPagar = ?, valPagoPagar = ?, statusPagar = ? WHERE idpagar = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
