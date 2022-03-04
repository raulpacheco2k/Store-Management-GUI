package model.DAO;

import model.bo.Color;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorDAO extends GenericDAO<Color> implements InterfaceDAO<Color> {
    Color model = new Color();

    public void setValuesForRetrieve(Color model) throws SQLException {
        model.setId(super.resultSet.getInt("idcor"));
        model.setDescription(super.resultSet.getString("descricaoCor"));
    }

    @Override
    public void setValuesForStore(Color model) throws SQLException {
        super.preparedStatement.setString(1, model.getDescription());
    }

    @Override
    public void create(Color objeto) {
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
    public List<Color> retrieve() {
        List<Color> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                Color model = new Color();
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
    public Color retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            Color model = new Color();
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
    public Color retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("descricaoCor"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            Color model = new Color();

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
    public void update(Color model) {
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
    public void delete(Color objeto) {
    }
}
