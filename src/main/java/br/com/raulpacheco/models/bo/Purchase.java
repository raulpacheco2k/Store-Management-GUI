package br.com.raulpacheco.models.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table
public class Purchase  {
    @Id
    @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    private int id;
    private int idProvider;
    private int paymentCondition;
    private int numberNF;
    private String serieNF;
    private Date dateHour;
    private float discount;
    private float totalValue;

    public Purchase() {
    }

    public Purchase(
            int id,
            int idProvider,
            int paymentCondition,
            int numberNF,
            String serieNF,
            Date dateHour,
            float discount,
            float totalValue
    ) {
        this.id = id;
        this.idProvider = idProvider;
        this.paymentCondition = paymentCondition;
        this.numberNF = numberNF;
        this.serieNF = serieNF;
        this.dateHour = dateHour;
        this.discount = discount;
        this.totalValue = totalValue;
    }

    public int getId() {
        return id;
    }

    public Purchase setId(int id) {
        this.id = id;
        return this;
    }

    public int getIdProvider() {
        return idProvider;
    }

    public Purchase setIdProvider(int idProvider) {
        this.idProvider = idProvider;
        return this;
    }

    public int getPaymentCondition() {
        return paymentCondition;
    }

    public Purchase setPaymentCondition(int paymentCondition) {
        this.paymentCondition = paymentCondition;
        return this;
    }

    public int getNumberNF() {
        return numberNF;
    }

    public Purchase setNumberNF(int numberNF) {
        this.numberNF = numberNF;
        return this;
    }

    public String getSerieNF() {
        return serieNF;
    }

    public Purchase setSerieNF(String serieNF) {
        this.serieNF = serieNF;
        return this;
    }

    public Date getDateHour() {
        return dateHour;
    }

    public Purchase setDateHour(Date dateHour) {
        this.dateHour = dateHour;
        return this;
    }

    public float getDiscount() {
        return discount;
    }

    public Purchase setDiscount(float discount) {
        this.discount = discount;
        return this;
    }

    public float getTotalValue() {
        return totalValue;
    }

    public Purchase setTotalValue(float totalValue) {
        this.totalValue = totalValue;
        return this;
    }
}
