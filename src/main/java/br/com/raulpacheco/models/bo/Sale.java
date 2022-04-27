package br.com.raulpacheco.models.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Sale  {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
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
}
