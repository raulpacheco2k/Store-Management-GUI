package model.DAO;

import model.bo.PurchaseItems;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PurchaseItemsDAO extends GenericDAO<PurchaseItems> implements InterfaceDAO<PurchaseItems> {
    PurchaseItems model = new PurchaseItems();

    public void setValuesForRetrieve(PurchaseItems model) throws SQLException {
        model.setId(super.resultSet.getInt("iditensCompra"));
        model.setPurchase_id(super.resultSet.getInt("compra_idcompra"));
        model.setProductCharacteristics_id(super.resultSet.getInt("caracteristicaProduto_idCaracterisitcaProduto"));
        model.setQuantity(super.resultSet.getFloat("qtdProduto"));
        model.setUnitaryValue(super.resultSet.getFloat("valunitarioProduto"));
    }

    @Override
    public void setValuesForStore(PurchaseItems model) throws SQLException {
        super.preparedStatement.setInt(1, model.getPurchase_id());
        super.preparedStatement.setInt(2, model.getProductCharacteristics_id());
        super.preparedStatement.setFloat(3, model.getQuantity());
        super.preparedStatement.setFloat(4, model.getUnitaryValue());
    }

    @Override
    public void create(PurchaseItems model) {
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
    public List<PurchaseItems> retrieve() {
        List<PurchaseItems> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                PurchaseItems model = new PurchaseItems();
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
    public PurchaseItems retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            PurchaseItems model = new PurchaseItems();
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
    public PurchaseItems retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("caracteristicaProduto_idCaracterisitcaProduto"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            PurchaseItems model = new PurchaseItems();

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
    public void update(PurchaseItems model) {
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
    public void delete(PurchaseItems objeto) {
    }
}
