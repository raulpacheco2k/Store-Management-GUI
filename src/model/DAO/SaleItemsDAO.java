package model.DAO;

import model.bo.SaleItems;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SaleItemsDAO extends GenericDAO<SaleItems> implements InterfaceDAO<SaleItems> {
    SaleItems model = new SaleItems();

    public void setValuesForRetrieve(SaleItems model) throws SQLException {
        model.setId(super.resultSet.getInt("iditensCompra"));
        model.setSale_id(super.resultSet.getInt("compra_idcompra"));
        model.setProductCharacteristics_id(super.resultSet.getInt("caracteristicaProduto_idCaracterisitcaProduto"));
        model.setQuantity(super.resultSet.getFloat("qtdProduto"));
        model.setUnitaryValue(super.resultSet.getFloat("valunitarioProduto"));
    }

    @Override
    public void setValuesForStore(SaleItems model) throws SQLException {
        super.preparedStatement.setInt(1, model.getSale_id());
        super.preparedStatement.setInt(2, model.getProductCharacteristics_id());
        super.preparedStatement.setFloat(3, model.getUnitaryValue());
        super.preparedStatement.setFloat(4, model.getQuantity());
    }

    @Override
    public void create(SaleItems objeto) {
        try {
            super.preparedStatement = super.sqlCode(model.insert());
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    @Override
    public List<SaleItems> retrieve() {
        List<SaleItems> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                SaleItems model = new SaleItems();
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
    public SaleItems retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            SaleItems model = new SaleItems();
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
    public SaleItems retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("caracteristicaProduto_idCaracterisitcaProduto"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            SaleItems model = new SaleItems();

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
    public void update(SaleItems model) {
        super.connection = ConnectionFactory.getConnection();
        try {
            super.preparedStatement = super.sqlCode(model.update());
            this.setValuesForStore(model);
            super.preparedStatement.setInt(5, model.getId());
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    @Override
    public void delete(SaleItems objeto) {
    }
}
