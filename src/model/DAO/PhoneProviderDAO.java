package model.DAO;

import model.bo.PhoneProvider;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneProviderDAO extends GenericDAO<PhoneProvider> implements InterfaceDAO<PhoneProvider> {
    PhoneProvider model = new PhoneProvider();

    public void setValuesForRetrieve(PhoneProvider model) throws SQLException {
        model.setPhone(super.resultSet.getString("foneFornecedor"));
        model.setProvider(super.resultSet.getInt("fornecedor_idfornecedor"));
    }

    @Override
    public void setValuesForStore(PhoneProvider model) throws SQLException {
        super.preparedStatement.setString(1, model.getPhone());
    }

    @Override
    public void create(PhoneProvider model) {
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
    public List<PhoneProvider> retrieve() {
        List<PhoneProvider> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                PhoneProvider model = new PhoneProvider();
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
    public PhoneProvider retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            PhoneProvider model = new PhoneProvider();
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
    public PhoneProvider retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("foneFornecedor"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            PhoneProvider model = new PhoneProvider();

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
    public void update(PhoneProvider model) {
        super.connection = ConnectionFactory.getConnection();
        try {
            super.preparedStatement = super.sqlCode(model.update());
            super.preparedStatement.setString(1, model.getPhone());
            super.preparedStatement.setString(2, model.getPhone());
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    @Override
    public void delete(PhoneProvider objeto) {
    }
}
