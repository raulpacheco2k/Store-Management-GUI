package br.com.raulpacheco.models.DAO;

import br.com.raulpacheco.models.bo.ProductType;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductTypeDAO extends GenericDAO<ProductType> implements InterfaceDAO<ProductType> {
    ProductType model = new ProductType();

    public void setValuesForRetrieve(ProductType model) throws SQLException {
        model.setId(super.resultSet.getInt("idtipoProduto"));
        model.setDescription(super.resultSet.getString("descricaoTipoProduto"));
    }

    @Override
    public void setValuesForStore(ProductType model) throws SQLException {
        super.preparedStatement.setString(1, model.getDescription());
    }

    @Override
    public void create(ProductType model) {
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
    public List<ProductType> retrieve() {
        List<ProductType> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                ProductType model = new ProductType();
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
    public ProductType retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            ProductType model = new ProductType();
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
    public ProductType retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("descricaoTipoProduto"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            ProductType model = new ProductType();

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
    public void update(ProductType model) {
        super.connection = ConnectionFactory.getConnection();
        try {
            super.preparedStatement = super.sqlCode(model.update());
            super.preparedStatement.setString(1, model.getDescription());
            super.preparedStatement.setInt(2, model.getId());
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    @Override
    public void delete(ProductType model) {
    }
}
