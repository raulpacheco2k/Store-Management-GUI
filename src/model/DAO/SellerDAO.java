package model.DAO;

import model.bo.Seller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SellerDAO extends GenericDAO<Seller> implements InterfaceDAO<Seller> {
    Seller model = new Seller();

    public void setValuesForRetrieve(Seller model) throws SQLException {
        model.setId(super.resultSet.getInt("idvendedor"));
        model.setName(super.resultSet.getString("nomeVendedor"));
        model.setCpf(super.resultSet.getString("cpfVendedor"));
        model.setEmail(super.resultSet.getString("emailVendedor"));
        model.setPhone1(super.resultSet.getString("foneVendedor"));
        model.setPhone2(super.resultSet.getString("fone2Vendedor"));
        model.setSalesCommissionPercentage(super.resultSet.getFloat("percentComissaoVenda"));
        model.setPaymentCommissionPercentage(super.resultSet.getFloat("percentComissaoRecebto"));
        model.setCompleteAddress(super.resultSet.getString("compleEnderecoVendedor"));
        model.setAddress_id(super.resultSet.getInt("endereco_idcep"));
    }

    @Override
    public void setValuesForStore(Seller model) throws SQLException {
        super.preparedStatement.setString(1, model.getName());
        super.preparedStatement.setString(2, model.getCpf());
        super.preparedStatement.setString(3, model.getEmail());
        super.preparedStatement.setString(4, model.getPhone1());
        super.preparedStatement.setString(5, model.getPhone2());
        super.preparedStatement.setFloat(6, model.getSalesCommissionPercentage());
        super.preparedStatement.setFloat(7, model.getPaymentCommissionPercentage());
        super.preparedStatement.setString(8, model.getCompleteAddress());
        super.preparedStatement.setInt(9, model.getAddress_id());
    }

    @Override
    public void create(Seller model) {
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
    public List<Seller> retrieve() {
        List<Seller> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                Seller model = new Seller();
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
    public Seller retrieve(int id) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, id);

            super.resultSet = super.preparedStatement.executeQuery();
            Seller model = new Seller();
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
    public Seller retrieve(String string) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("descricaoTipoProduto"));
            super.preparedStatement.setString(1, string);
            super.resultSet = super.preparedStatement.executeQuery();
            Seller model = new Seller();

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
    public void update(Seller model) {
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
    public void delete(Seller model) {
    }
}
