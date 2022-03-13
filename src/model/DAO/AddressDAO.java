package model.DAO;

import model.bo.Endereco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements InterfaceDAO<Endereco> {

    BairroDAO BairroDAO;
    CidadeDAO CidadeDAO;
    PreparedStatement pstm;
    ResultSet queryResult;

    public AddressDAO() {
        this.BairroDAO = new BairroDAO();
        this.CidadeDAO = new CidadeDAO();
    }

    @Override
    public void create(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar =
                "INSERT INTO endereco "
                        + "(cepCep, logradouroCep, bairro_idbairro, cidade_idcidade) "
                        + "VALUES (?, ?, ?, ?)";

        try {
            this.pstm = conexao.prepareStatement(sqlExecutar);
            this.pstm.setString(1, objeto.getCepCep());
            this.pstm.setString(2, objeto.getLogradouroCep());
            this.pstm.setInt(3, objeto.getBairro().getIdBairro());
            this.pstm.setInt(4, objeto.getCidade().getIdCidade());

            this.pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, this.pstm);
    }

    @Override
    public List<Endereco> retrieve() {
        String sqlExecutar = "SELECT idcep, cepCep, logradouroCep, bairro_idbairro, cidade_idcidade FROM endereco";
        Connection conexao = ConnectionFactory.getConnection();
        List<Endereco> cidades = new ArrayList<>();

        try {
            this.pstm = conexao.prepareStatement(sqlExecutar);
            this.queryResult = pstm.executeQuery();

            while (this.queryResult.next()) {
                Endereco address = new Endereco();
                address.setIdCep(this.queryResult.getInt("idcep"));
                address.setCepCep(this.queryResult.getString("cepCep"));
                address.setLogradouroCep(this.queryResult.getString("logradouroCep"));
                address.setBairro(this.BairroDAO.retrieve(this.queryResult.getInt("bairro_idbairro")));
                address.setCidade(this.CidadeDAO.retrieve(this.queryResult.getInt("cidade_idcidade")));
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
    public Endereco retrieve(int codigo) {
        String sqlExecutar = " SELECT idcep, cepCep, logradouroCep, bairro_idbairro, cidade_idcidade FROM endereco WHERE idcep = ?";
        Connection conexao = ConnectionFactory.getConnection();

        try {
            this.pstm = conexao.prepareStatement(sqlExecutar);
            this.pstm.setInt(1, codigo);
            this.queryResult = this.pstm.executeQuery();
            Endereco address = new Endereco();
            while (this.queryResult.next()) {
                address.setIdCep(this.queryResult.getInt("idcep"));
                address.setCepCep(this.queryResult.getString("cepCep"));
                address.setLogradouroCep(this.queryResult.getString("logradouroCep"));
                address.setBairro(this.BairroDAO.retrieve(this.queryResult.getInt("bairro_idbairro")));
                address.setCidade(this.CidadeDAO.retrieve(this.queryResult.getInt("cidade_idcidade")));
            }
            ConnectionFactory.closeConnection(conexao, this.pstm, this.queryResult);
            return address;
        } catch (Exception ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, this.pstm, this.queryResult);
            return null;
        }
    }

    private Endereco getEndereco(Connection conexao) throws SQLException {
        this.queryResult = this.pstm.executeQuery();
        Endereco address = new Endereco();
        while (this.queryResult.next()) {
            address.setIdCep(this.queryResult.getInt("idcep"));
            address.setCepCep(this.queryResult.getString("cepCep"));
            address.setBairro(this.BairroDAO.retrieve(this.queryResult.getInt("bairro_idbairro")));
            address.setCidade(this.CidadeDAO.retrieve(this.queryResult.getInt("cidade_idcidade")));
        }
        ConnectionFactory.closeConnection(conexao, this.pstm, this.queryResult);
        return address;
    }

    @Override
    public Endereco retrieve(String descricao) {
        String sqlExecutar = "SELECT idcep, cepCep, logradouroCep, bairro_idbairro, cidade_idcidade FROM endereco WHERE cepCep = ?";
        Connection conexao = ConnectionFactory.getConnection();

        try {
            this.pstm = conexao.prepareStatement(sqlExecutar);
            this.pstm.setString(1, descricao);
            return getEndereco(conexao);
        } catch (Exception ex) {
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, this.pstm, this.queryResult);
            return null;
        }
    }

    @Override
    public void update(Endereco objeto) {
        Connection conexao = ConnectionFactory.getConnection();

        String sqlExecutar =
                " UPDATE endereco "
                        + " SET cepCep = ? ,"
                        + " logradouroCep = ?, "
                        + "bairro_idbairro = ?,"
                        + "cidade_idcidade = ?"
                        + " WHERE endereco.idcep = ? ";


        try {
            this.pstm = conexao.prepareStatement(sqlExecutar);
            this.pstm.setString(1, objeto.getCepCep());
            this.pstm.setString(2, objeto.getLogradouroCep());
            this.pstm.setInt(3, objeto.getBairro().getIdBairro());
            this.pstm.setInt(4, objeto.getCidade().getIdCidade());
            this.pstm.setInt(5, objeto.getIdCep());

            this.pstm.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, this.pstm);
    }

    @Override
    public void delete(Endereco model) {

    }

}
