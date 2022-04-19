package br.com.raulpacheco.models.DAO;

import br.com.raulpacheco.models.bo.PaymentCondition;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PaymentConditionDAO extends GenericDAO<PaymentCondition> implements InterfaceDAO<PaymentCondition> {
    PaymentCondition model = new PaymentCondition();

    public void setValuesForRetrieve(PaymentCondition model) throws SQLException {
        model.setId(super.resultSet.getInt("idcondicaoPagamento"));
        model.setConditionDescription(super.resultSet.getString("descricaoCondicaoPagamento"));
        model.setDaysUntilFirstInstallment(super.resultSet.getInt("numDiasAtePrimeiraParcela"));
        model.setDaysBetweenInstallments(super.resultSet.getInt("numDiasEntreParcelas"));
    }

    @Override
    public void setValuesForStore(PaymentCondition model) throws SQLException {
        super.preparedStatement.setString(1, model.getConditionDescription());
        super.preparedStatement.setInt(2, model.getDaysUntilFirstInstallment());
        super.preparedStatement.setInt(3, model.getDaysBetweenInstallments());
    }

    @Override
    public void create(PaymentCondition model) {
        try {
            super.preparedStatement = super.sqlCode(this.model.insert());
            this.setValuesForStore(model);
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    @Override
    public List<PaymentCondition> retrieve() {
        List<PaymentCondition> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                PaymentCondition model = new PaymentCondition();
                this.setValuesForRetrieve(model);
                models.add(model);
            }
            return models;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement, super.resultSet);
        }
    }

    @Override
    public PaymentCondition retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            PaymentCondition model = new PaymentCondition();
            while (super.resultSet.next()) {
                this.setValuesForRetrieve(model);
            }
            return model;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement, super.resultSet);
        }
    }

    @Override
    public PaymentCondition retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("foneFornecedor"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            PaymentCondition model = new PaymentCondition();

            while (super.resultSet.next()) {
                this.setValuesForRetrieve(model);
            }
            return model;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement, super.resultSet);
        }
    }

    @Override
    public void update(PaymentCondition model) {
        super.connection = ConnectionFactory.getConnection();
        try {
            super.preparedStatement = super.sqlCode(model.update());
            this.setValuesForStore(model);
            super.preparedStatement.setInt(4, model.getId());
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    @Override
    public void delete(PaymentCondition model) {
    }
}
