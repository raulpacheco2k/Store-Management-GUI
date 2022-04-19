package br.com.raulpacheco.models.bo;

public class PaymentCondition extends Model {
    private int id;
    private String conditionDescription;
    private int daysUntilFirstInstallment;
    private int daysBetweenInstallments;

    public PaymentCondition() {
        setTable("condicaopagamento");
    }

    public PaymentCondition(int id, String conditionDescription, int daysUntilFirstInstallment, int daysBetweenInstallments) {
        this.id = id;
        this.conditionDescription = conditionDescription;
        this.daysUntilFirstInstallment = daysUntilFirstInstallment;
        this.daysBetweenInstallments = daysBetweenInstallments;
        setTable("condicaopagamento");
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

    @Override
    public String insert() {
        return "INSERT INTO " + this.getTable() + " (descricaoCondicaoPagamento, numDiasAtePrimeiraParcela, numDiasEntreParcelas) VALUES (?, ?, ?)";
    }

    @Override
    public String findAll() {
        return "SELECT idcondicaoPagamento, descricaoCondicaoPagamento, numDiasAtePrimeiraParcela, numDiasEntreParcelas FROM " + this.getTable();
    }

    @Override
    public String findById() {
        return "SELECT idcondicaoPagamento, descricaoCondicaoPagamento, numDiasAtePrimeiraParcela, numDiasEntreParcelas FROM " + this.getTable() + " WHERE idcondicaoPagamento = ?";
    }

    @Override
    public String findByField(String string) {
        return "SELECT idcondicaoPagamento, descricaoCondicaoPagamento, numDiasAtePrimeiraParcela, numDiasEntreParcelas FROM " + this.getTable() + " WHERE " + string + " = ?";
    }

    @Override
    public String update() {
        return "UPDATE " + this.getTable() + " SET descricaoCondicaoPagamento = ?, numDiasAtePrimeiraParcela = ?, numDiasEntreParcelas = ? WHERE idcondicaoPagamento = ?";
    }

    @Override
    public String delete() {
        return null;
    }
}
