package br.com.raulpacheco.models.DAO;

import br.com.raulpacheco.models.bo.ProductCharacteristics;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductCharacteristicsDAO extends GenericDAO<ProductCharacteristics> implements InterfaceDAO<ProductCharacteristics> {
    ProductCharacteristics model = new ProductCharacteristics();

    public void setValuesForRetrieve(ProductCharacteristics model) throws SQLException {
        model.setId(super.resultSet.getInt("idCaracterisitcaProduto"));
        model.setIdProduct(super.resultSet.getInt("produto_idproduto"));
        model.setIdColor(super.resultSet.getInt("cor_idcor"));
        model.setSize(super.resultSet.getString("tamanhoProduto"));
        model.setBarCode(super.resultSet.getString("barraProduto"));
        model.setStock(super.resultSet.getFloat("qtdEstoqueProduto"));
    }

    @Override
    public void setValuesForStore(ProductCharacteristics model) throws SQLException {
        super.preparedStatement.setInt(1, model.getIdProduct());
        super.preparedStatement.setInt(2, model.getIdColor());
        super.preparedStatement.setString(3, model.getSize());
        super.preparedStatement.setString(4, model.getBarCode());
        super.preparedStatement.setFloat(5, model.getStock());
    }

    @Override
    public void create(ProductCharacteristics model) {
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
    public List<ProductCharacteristics> retrieve() {
        List<ProductCharacteristics> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                ProductCharacteristics model = new ProductCharacteristics();
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
    public ProductCharacteristics retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            ProductCharacteristics model = new ProductCharacteristics();
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
    public ProductCharacteristics retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("descricaoTipoProduto"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            ProductCharacteristics model = new ProductCharacteristics();

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
    public void update(ProductCharacteristics model) {
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
    public void delete(ProductCharacteristics model) {
    }
}
