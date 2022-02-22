package model.bo;

public class PaymentCondition {
    private int id;
    private String conditionDescription;
    private int daysUntilFirstInstallment;
    private int daysBetweenInstallments;

    public PaymentCondition() {
    }

    public PaymentCondition(int id, String conditionDescription, int daysUntilFirstInstallment, int daysBetweenInstallments) {
        this.id = id;
        this.conditionDescription = conditionDescription;
        this.daysUntilFirstInstallment = daysUntilFirstInstallment;
        this.daysBetweenInstallments = daysBetweenInstallments;
    }

    public int getId() {
        return id;
    }

    public PaymentCondition setId(int id) {
        this.id = id;
        return this;
    }

    public String getConditionDescription() {
        return conditionDescription;
    }

    public PaymentCondition setConditionDescription(String conditionDescription) {
        this.conditionDescription = conditionDescription;
        return this;
    }

    public int getDaysUntilFirstInstallment() {
        return daysUntilFirstInstallment;
    }

    public PaymentCondition setDaysUntilFirstInstallment(int daysUntilFirstInstallment) {
        this.daysUntilFirstInstallment = daysUntilFirstInstallment;
        return this;
    }

    public int getDaysBetweenInstallments() {
        return daysBetweenInstallments;
    }

    public PaymentCondition setDaysBetweenInstallments(int daysBetweenInstallments) {
        this.daysBetweenInstallments = daysBetweenInstallments;
        return this;
    }
}
