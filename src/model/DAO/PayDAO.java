package model.DAO;

import model.bo.Pay;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PayDAO extends GenericDAO<Pay> implements InterfaceDAO<Pay> {
    Pay model = new Pay();

    public void setValuesForRetrieve(Pay model) throws SQLException {
        model.setId(super.resultSet.getInt("idpagar"));
        model.setPurchase_id(super.resultSet.getInt("compra_idcompra"));
        model.setDateIssuance(super.resultSet.getDate("dtHrEmissaoPagar"));
        model.setDueDate(super.resultSet.getDate("dtVencimentoPagar"));
        model.setIssuanceValue(super.resultSet.getFloat("valemitidoPagar"));
        model.setAmountPaid(super.resultSet.getFloat("acrescimoPagar"));
        model.setDiscount(super.resultSet.getFloat("descontoPagar"));
        model.setPayDate(super.resultSet.getDate("dtHrPgtoPagar"));
        model.setIssuanceValue(super.resultSet.getFloat("valPagoPagar"));
        model.setStatus(super.resultSet.getInt("statusPagar"));
    }

    @Override
    public void setValuesForStore(Pay model) throws SQLException {
        super.preparedStatement.setInt(1, model.getPurchase_id());
        super.preparedStatement.setDate(2, (Date) model.getDateIssuance());
        super.preparedStatement.setDate(3, (Date) model.getDueDate());
        super.preparedStatement.setFloat(4, model.getIssuanceValue());
        super.preparedStatement.setFloat(5, model.getAmountPaid());
        super.preparedStatement.setFloat(6, model.getDiscount());
        super.preparedStatement.setDate(7, (Date) model.getPayDate());
        super.preparedStatement.setFloat(8, model.getIssuanceValue());
        super.preparedStatement.setInt(9, model.getStatus());
    }

    @Override
    public void create(Pay model) {
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
    public List<Pay> retrieve() {
        List<Pay> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                Pay model = new Pay();
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
    public Pay retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            Pay model = new Pay();
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
    public Pay retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("descricaoTipoProduto"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            Pay model = new Pay();

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
    public void update(Pay model) {
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
    public void delete(Pay model) {
    }
}
