package br.com.raulpacheco.models.DAO;

import br.com.raulpacheco.models.bo.Fornecedor;
import br.com.raulpacheco.services.AddressService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO extends GenericDAO<Fornecedor> implements InterfaceDAO<Fornecedor> {
    Fornecedor model = new Fornecedor();
    AddressService addressService = new AddressService();

    public void setValuesForRetrieve(Fornecedor model) throws SQLException {
        model.setIdFornecedor(super.resultSet.getInt("idFornecedor"));
        model.setRazaoSocialFornecedor(super.resultSet.getString("razaoSocialFornecedor"));
        model.setNome(super.resultSet.getString("nomeFantasiaFornecedor"));
        model.setCnpjFornecedor(super.resultSet.getString("cnpjFornecedor"));
        model.setInscEstadualFornecedor(super.resultSet.getString("inscEstadualFornecedor"));
        model.setEmail(super.resultSet.getString("emailFornecedor"));
        model.setCompleEndereco(super.resultSet.getString("compleEnderecofornecedor"));
        model.setEndereco(addressService.buscar(super.resultSet.getInt("endereco_idcep")));
    }

    @Override
    public void setValuesForStore(Fornecedor model) throws SQLException {
        super.preparedStatement.setString(1, model.getRazaoSocialFornecedor());
        super.preparedStatement.setString(2, model.getNome());
        super.preparedStatement.setString(3, model.getCnpjFornecedor());
        super.preparedStatement.setString(4, model.getInscEstadualFornecedor());
        super.preparedStatement.setString(5, model.getEmail());
        super.preparedStatement.setString(6, model.getCompleEndereco());
        super.preparedStatement.setInt(7, model.idEndereco);
    }

    @Override
    public void create(Fornecedor model) {
        try {
            super.preparedStatement = super.sqlCode(model.insert());
            this.setValuesForStore(model);
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    @Override
    public List<Fornecedor> retrieve() {
        List<Fornecedor> models = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                Fornecedor model = new Fornecedor();
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
    public Fornecedor retrieve(int codigo) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, codigo);
            super.resultSet = super.preparedStatement.executeQuery();
            Fornecedor model = new Fornecedor();

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
    public Fornecedor retrieve(String descricao) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("descricaoBairro"));
            super.preparedStatement.setString(1, descricao);
            super.resultSet = super.preparedStatement.executeQuery();
            Fornecedor model = new Fornecedor();

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
    public void update(Fornecedor model) {
        super.connection = ConnectionFactory.getConnection();
        try {
            super.preparedStatement = super.sqlCode(model.update());
            this.setValuesForStore(model);
            super.preparedStatement.setInt(8, model.getIdFornecedor());
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
