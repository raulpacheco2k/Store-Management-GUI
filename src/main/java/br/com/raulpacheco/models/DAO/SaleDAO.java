package br.com.raulpacheco.models.DAO;

import br.com.raulpacheco.models.bo.Sale;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO extends GenericDAO<Sale> implements InterfaceDAO<Sale> {
    Sale model = new Sale();

    public void setValuesForRetrieve(Sale model) throws SQLException {
        model.setId(super.resultSet.getInt("idvenda"));
        model.setSerie(super.resultSet.getString("serieVenda"));
        model.setDate(super.resultSet.getDate("dtVenda"));
        model.setHour(super.resultSet.getString("hrVenda"));
        model.setDiscountValue(super.resultSet.getFloat("valDescontoVenda"));
        model.setTotalValue(super.resultSet.getFloat("valTotalVenda"));
        model.setClient_id(super.resultSet.getInt("cliente_idcliente"));
        model.setPaymentCondition_id(super.resultSet.getInt("condicaoPagamento_idcondicaoPagamento"));
        model.setDueDay(super.resultSet.getInt("diaVencimentoParcela"));
        model.setSeller_id(super.resultSet.getInt("vendedor_idvendedor"));
    }

    @Override
    public void setValuesForStore(Sale model) throws SQLException {
        super.preparedStatement.setString(1, model.getSerie());
        super.preparedStatement.setDate(2, (Date) model.getDate());
        super.preparedStatement.setString(3, model.getHour());
        super.preparedStatement.setFloat(4, model.getDiscountValue());
        super.preparedStatement.setFloat(5, model.getTotalValue());
        super.preparedStatement.setInt(6, model.getClient_id());
        super.preparedStatement.setInt(7, model.getPaymentCondition_id());
        super.preparedStatement.setInt(8, model.getDueDay());
        super.preparedStatement.setInt(9, model.getSeller_id());
    }

    @Override
    public void create(Sale model) {
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
    public List<Sale> retrieve() {
        List<Sale> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                Sale model = new Sale();
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
    public Sale retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            Sale model = new Sale();
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
    public Sale retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("caracteristicaProduto_idCaracterisitcaProduto"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            Sale model = new Sale();

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
    public void update(Sale model) {
        super.connection = ConnectionFactory.getConnection();
        try {
            super.preparedStatement = super.sqlCode(model.update());
            this.setValuesForStore(model);
            super.preparedStatement.setInt(10, model.getId());
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    @Override
    public void delete(Sale model) {
    }
}
