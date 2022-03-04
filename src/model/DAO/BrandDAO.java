package model.DAO;

import model.bo.Brand;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BrandDAO extends GenericDAO<Brand> implements InterfaceDAO<Brand> {
    Brand model = new Brand();

    public void setValuesForRetrieve(Brand model) throws SQLException {
        model.setId(super.resultSet.getInt("idmarca"));
        model.setDescription(super.resultSet.getString("descricaoMarca"));
    }

    @Override
    public void setValuesForStore(Brand model) throws SQLException {
        super.preparedStatement.setString(1, model.getDescription());
    }

    @Override
    public void create(Brand objeto) {
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
    public List<Brand> retrieve() {
        List<Brand> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                Brand model = new Brand();
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
    public Brand retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            Brand model = new Brand();
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
    public Brand retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("descricaoMarca"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            Brand model = new Brand();

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
    public void update(Brand model) {
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
    public void delete(Brand objeto) {
    }
}
