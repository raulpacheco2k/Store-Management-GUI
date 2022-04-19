package br.com.raulpacheco.models.DAO;

import br.com.raulpacheco.models.bo.Bairro;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BairroDAO extends GenericDAO<Bairro> implements InterfaceDAO<Bairro> {
    Bairro model = new Bairro();

    public void setValuesForRetrieve(Bairro model) throws SQLException {
        model.setIdBairro(super.resultSet.getInt("idbairro"));
        model.setDescricaoBairro(super.resultSet.getString("descricaoBairro"));
    }

    @Override
    public void setValuesForStore(Bairro model) throws SQLException {
        super.preparedStatement.setString(1, model.getDescricaoBairro());
    }

    @Override
    public void create(Bairro model) {
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
    public List<Bairro> retrieve() {
        List<Bairro> bairros = new ArrayList<>();

        try {
            super.preparedStatement = super.sqlCode(model.findAll());
            super.resultSet = super.preparedStatement.executeQuery();

            while (super.resultSet.next()) {
                Bairro bairro = new Bairro();
                this.setValuesForRetrieve(bairro);
                bairros.add(bairro);
            }
            return bairros;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement, super.resultSet);
        }
    }

    @Override
    public Bairro retrieve(int codigo) {
        try {
            super.preparedStatement = super.sqlCode(model.findById());
            super.preparedStatement.setInt(1, codigo);

            super.resultSet = super.preparedStatement.executeQuery();
            Bairro bairro = new Bairro();
            while (super.resultSet.next()) {
                this.setValuesForRetrieve(bairro);
            }
           
            return bairro;
        } catch (Exception ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement, super.resultSet);
            return null;
        }
        
    }

    @Override
    public Bairro retrieve(String descricao) {
        try {
            super.preparedStatement = super.sqlCode(model.findByField("descricaoBairro"));
            super.preparedStatement.setString(1, descricao);
            super.resultSet = super.preparedStatement.executeQuery();
            Bairro bairro = new Bairro();

            while (super.resultSet.next()) {
                this.setValuesForRetrieve(bairro);
            }
            return bairro;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement, super.resultSet);
        }
    }

    @Override
    public void update(Bairro objeto) {
        super.connection = ConnectionFactory.getConnection();
        try {
            super.preparedStatement = super.sqlCode(model.update());
            super.preparedStatement.setString(1, objeto.getDescricaoBairro());
            super.preparedStatement.setInt(2, objeto.getIdBairro());
            super.preparedStatement.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            ConnectionFactory.closeConnection(super.connection, super.preparedStatement);
        }
    }

    @Override
    public void delete(Bairro model) {
    }
}
