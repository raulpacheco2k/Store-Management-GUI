package br.com.raulpacheco.models.DAO;

import br.com.raulpacheco.models.bo.Purchase;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseDAO extends GenericDAO<Purchase> implements InterfaceDAO<Purchase> {
    Purchase model = new Purchase();

    public void setValuesForRetrieve(Purchase model) throws SQLException {
        model.setId(super.resultSet.getInt("idcompra"));
        model.setIdProvider(super.resultSet.getInt("fornecedor_idfornecedor"));
        model.setPaymentCondition(super.resultSet.getInt("condicaoPagamento_idcondicaoPagamento"));
        model.setNumberNF(super.resultSet.getInt("numNFCompra"));
        model.setSerieNF(super.resultSet.getString("numNFCompra"));
        model.setDateHour(super.resultSet.getDate("dtHrCompra"));
        model.setDiscount(super.resultSet.getFloat("descontoCompra"));
        model.setTotalValue(super.resultSet.getFloat("valorTotalCompra"));
    }

    @Override
    public void setValuesForStore(Purchase model) throws SQLException {
        super.preparedStatement.setInt(1, model.getIdProvider());
        super.preparedStatement.setInt(2, model.getPaymentCondition());
        super.preparedStatement.setInt(3, model.getNumberNF());
        super.preparedStatement.setString(4, model.getSerieNF());
        super.preparedStatement.setDate(5, (Date) model.getDateHour());
        super.preparedStatement.setFloat(6, model.getDiscount());
        super.preparedStatement.setFloat(7, model.getTotalValue());
    }

    @Override
    public void create(Purchase model) {
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
    public List<Purchase> retrieve() {
        List<Purchase> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                Purchase model = new Purchase();
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
    public Purchase retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            Purchase model = new Purchase();
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
    public Purchase retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("caracteristicaProduto_idCaracterisitcaProduto"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            Purchase model = new Purchase();

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
    public void update(Purchase model) {
        super.connection = ConnectionFactory.getConnection();
        try {
            super.preparedStatement = super.sqlCode(model.update());
            this.setValuesForStore(model);
            super.preparedStatement.setInt(8, model.getId());
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    @Override
    public void delete(Purchase model) {
    }
}
