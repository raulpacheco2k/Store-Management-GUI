package model.DAO;

import model.bo.Fornecedor;
import service.AddressService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO extends GenericDAO<Fornecedor> implements InterfaceDAO<Fornecedor> {
    Fornecedor model = new Fornecedor();
    AddressService addressService = new AddressService();

    public FornecedorDAO() {
    }

    @Override
    public void create(Fornecedor model) {
        try {
            super.preparedStatement = super.sqlCode(model.insert());
            super.preparedStatement.setString(1, model.getRazaoSocialFornecedor());
            super.preparedStatement.setString(2, model.getNome());
            super.preparedStatement.setString(3, model.getCnpjFornecedor());
            super.preparedStatement.setString(4, model.getInscEstadualFornecedor());
            super.preparedStatement.setString(5, model.getEmail());
            super.preparedStatement.setString(6, model.getCompleEndereco());
            super.preparedStatement.setInt(7, model.getEndereco().getIdCep());
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    public Fornecedor setValues(Fornecedor model) throws SQLException {
        model.setIdFornecedor(super.resultSet.getInt("idFornecedor"));
        model.setRazaoSocialFornecedor(super.resultSet.getString("RazaoSocialFornecedor"));
        model.setNome(super.resultSet.getString("nomeFantasiaFornecedor"));
        model.setCnpjFornecedor(super.resultSet.getString("cnpjFornecedor"));
        model.setInscEstadualFornecedor(super.resultSet.getString("inscEstadualFornecedor"));
        model.setEmail(super.resultSet.getString("emailFornecedor"));
        model.setCompleEndereco(super.resultSet.getString("compleEnderecofornecedor"));
        model.setEndereco(addressService.buscar(super.resultSet.getInt("inscEstadualFornecedor")));
        return model;
    }

    @Override
    public List<Fornecedor> retrieve() {
        List<Fornecedor> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                Fornecedor model = new Fornecedor();
                this.setValues(model);
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
    public Fornecedor retrieve(int codigo) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, codigo);

            super.resultSet = super.preparedStatement.executeQuery();
            Fornecedor model = new Fornecedor();
            while (super.resultSet.next()) {
                this.setValues(model);
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
    public Fornecedor retrieve(String descricao) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("descricaoBairro"));
            super.preparedStatement.setString(1, descricao);
            super.resultSet = super.preparedStatement.executeQuery();
            Fornecedor model = new Fornecedor();

            while (super.resultSet.next()) {
                this.setValues(model);
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
    public void update(Fornecedor model) {
        super.connection = ConnectionFactory.getConnection();
        try {
            super.preparedStatement = super.sqlCode(model.update());
            // super.preparedStatement.setString(1, objeto.getDescricaoBairro());
            // super.preparedStatement.setInt(2, objeto.getIdBairro());
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    @Override
    public void delete(Fornecedor model) {
    }
}
