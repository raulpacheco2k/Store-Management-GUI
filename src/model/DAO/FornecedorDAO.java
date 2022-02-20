package model.DAO;

import model.bo.Fornecedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FornecedorDAO implements InterfaceDAO<Fornecedor> {

    PreparedStatement pstm;
    ResultSet queryResult;

    @Override
    public void create(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar =
                "INSERT INTO fornecedor (razaoSocialFornecedor, nomeFantasiaFornecedor, cnpjFornecedor, " +
                        "inscEstadualFornecedor, emailFornecedor, compleEnderecofornecedor, endereco_idcep) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            this.pstm = conexao.prepareStatement(sqlExecutar);
            this.pstm.setString(1, objeto.getRazaoSocialFornecedor());
            this.pstm.setString(2, objeto.getNome());
            this.pstm.setString(3, objeto.getCnpjFornecedor());
            this.pstm.setString(4, objeto.getInscEstadualFornecedor());
            this.pstm.setString(5, objeto.getEmail());
            this.pstm.setString(6, objeto.getCompleEndereco());
            this.pstm.setInt(7, objeto.getEndereco().getIdCep());

            this.pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, this.pstm);
    }

    @Override
    public List<Fornecedor> retrieve() {
        String sqlExecutar = "SELECT * FROM endereco";

        Connection conexao = ConnectionFactory.getConnection();

        List<Fornecedor> cidades = new ArrayList<>();

        try {
            this.pstm = conexao.prepareStatement(sqlExecutar);
            this.queryResult = pstm.executeQuery();

            while (this.queryResult.next()) {
                Fornecedor address = new Fornecedor();
                // address.setIdCep(this.queryResult.getInt("idcep"));
                // address.setCepCep(this.queryResult.getString("cepCep"));
                // address.setBairro(this.BairroDAO.retrieve(this.queryResult.getInt("bairro_idbairro")));
                // address.setCidade(this.CidadeDAO.retrieve(this.queryResult.getInt("cidade_idcidade")));
                cidades.add(address);
            }

            ConnectionFactory.closeConnection(conexao, pstm, this.queryResult);

            return cidades;
        } catch (Exception ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, this.queryResult);
            return null;
        }
    }

    @Override
    public Fornecedor retrieve(int codigo) {
        String sqlExecutar = " SELECT * "
                + " FROM cidade "
                + " WHERE cidade.idcidade = ?";
        Connection conexao = ConnectionFactory.getConnection();

        try {
            this.pstm = conexao.prepareStatement(sqlExecutar);
            this.pstm.setInt(1, codigo);
            this.queryResult = this.pstm.executeQuery();
            Fornecedor address = new Fornecedor();
            while (this.queryResult.next()) {
                // address.setIdCep(this.queryResult.getInt("idcep"));
                // address.setCepCep(this.queryResult.getString("cepCep"));
                // address.setBairro(this.BairroDAO.retrieve(this.queryResult.getInt("bairro_idbairro")));
                // address.setCidade(this.CidadeDAO.retrieve(this.queryResult.getInt("cidade_idcidade")));
            }
            ConnectionFactory.closeConnection(conexao, this.pstm, this.queryResult);
            return address;
        } catch (Exception ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, this.pstm, this.queryResult);
            return null;
        }
    }

    @Override
    public Fornecedor retrieve(String descricao) {
        String sqlExecutar = " SELECT idcidade, "
                + " descricaoCidade, "
                + " ufCidade "
                + " FROM cidade "
                + " WHERE cidade.descricaoCidade = ?";
        Connection conexao = ConnectionFactory.getConnection();

        try {
            this.pstm = conexao.prepareStatement(sqlExecutar);
            this.pstm.setString(1, descricao);
            this.queryResult = this.pstm.executeQuery();
            Fornecedor address = new Fornecedor();

            while (this.queryResult.next()) {
                // address.setIdCep(this.queryResult.getInt("idcep"));
                // address.setCepCep(this.queryResult.getString("cepCep"));
                // address.setBairro(this.BairroDAO.retrieve(this.queryResult.getInt("bairro_idbairro")));
                // address.setCidade(this.CidadeDAO.retrieve(this.queryResult.getInt("cidade_idcidade")));
            }

            ConnectionFactory.closeConnection(conexao, this.pstm, this.queryResult);

            return address;
        } catch (Exception ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, this.pstm, this.queryResult);
            return null;
        }
    }

    @Override
    public void update(Fornecedor objeto) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar =
                " UPDATE endereco "
                        + "SET cepCep = ? ,"
                        + " logradouroCep = ?, "
                        + "bairro_idbairro = ?,"
                        + "cidade_idcidade = ?"
                        + " WHERE endereco.idcep = ? ";


        try {
            this.pstm = conexao.prepareStatement(sqlExecutar);
            // this.pstm.setString(1, objeto.getCepCep());
            // this.pstm.setString(2, objeto.getLogradouroCep());
            // this.pstm.setInt(3, objeto.getBairro().getIdBairro());
            // this.pstm.setInt(4, objeto.getCidade().getIdCidade());

            this.pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, this.pstm);
    }

    @Override
    public void delete(Fornecedor objeto) {

    }

}
