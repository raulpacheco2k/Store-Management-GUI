package br.com.raulpacheco.models.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Receive  {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
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
}
