package br.com.raulpacheco.models.DAO;

import br.com.raulpacheco.models.bo.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends GenericDAO<Product> implements InterfaceDAO<Product> {
    Product model = new Product();

    public void setValuesForRetrieve(Product model) throws SQLException {
        model.setId(super.resultSet.getInt("idproduto"));
        model.setDescription(super.resultSet.getString("descricaoProduto"));
        model.setValue(super.resultSet.getFloat("valProduto"));
        model.setBrand_id(super.resultSet.getInt("marca_idmarca"));
        model.setProduct_type(super.resultSet.getInt("tipoProduto_idtipoProduto"));
        model.setProduct_size(super.resultSet.getInt("tamanho_idtamanho"));
    }

    @Override
    public void setValuesForStore(Product model) throws SQLException {
        super.preparedStatement.setString(1, model.getDescription());
    }

    @Override
    public void create(Product model) {
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
    public List<Product> retrieve() {
        List<Product> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                Product model = new Product();
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
    public Product retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            Product model = new Product();
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
    public Product retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("descricaoTipoProduto"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            Product model = new Product();

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
    public void update(Product model) {
        super.connection = ConnectionFactory.getConnection();
        try {
            super.preparedStatement = super.sqlCode(model.update());
            this.setValuesForStore(model);
            super.preparedStatement.setInt(2, model.getId());
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    @Override
    public void delete(Product model) {
    }
}
