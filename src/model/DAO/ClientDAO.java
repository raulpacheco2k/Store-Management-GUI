package model.DAO;

import model.bo.Client;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

public class ClientDAO implements InterfaceDAO<Client>{

    @Override
    public void create(Client objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO cliente "
                + "(nomeCliente, dtNasCliente, cpfCliente, rgCliente,"
                + " foneCliente, fone2Cliente, emailCliente, compleEnderecoCliente,"
                + " endereco_idcep) VALUE (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstm = null;
        
        try{
            assert conexao != null;
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getNome());


            java.util.Date utilDate = objeto.getDtNasc();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());


            pstm.setDate(2, sqlDate);
            pstm.setString(3, objeto.getCpfCliente());
            pstm.setString(4, objeto.getRgCliente());
            pstm.setString(5, objeto.getFoneCliente());
            pstm.setString(6, objeto.getFone2Cliente());
            pstm.setString(7, objeto.getEmail());
            pstm.setString(8, objeto.getCompleEndereco());
            pstm.setString(9, "2");
            
            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        
        ConnectionFactory.closeConnection(conexao, pstm);
    }  
    
    @Override
    public List<Client> retrieve() {
        String sqlExecutar     =   "SELECT idcliente, nomeCliente, dtNasCliente,"
                + " cpfCliente, rgCliente, foneCliente, fone2Cliente, "
                + "emailCliente  FROM cliente";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<Client> clients = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();            
            
            while(rst.next()){
                Client client = new Client();
                
                client.setNome(rst.getString("nomeCliente"));
                client.setDtNasc(rst.getDate("dtNasCliente"));
                client.setRgCliente((rst.getString("rgCliente")));
                client.setCpfCliente((rst.getString("cpfCliente")));
                client.setFoneCliente((rst.getString("foneCliente")));
                client.setFone2Cliente((rst.getString("fone2Cliente")));
                client.setEmail((rst.getString("emailCliente")));   
                
                clients.add(client);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return clients;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }
    
    @Override
    public Client retrieve(int codigo) {
        String sqlExecutar     =   " SELECT idcidade, "
                                 + " descricaoCidade, "
                                 + " ufCidade "
                                 + " FROM cidade "
                                 + " WHERE cidade.idcidade = ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            rst = pstm.executeQuery();  
            Client client = new Client();
            while(rst.next()){
                client.setNome(rst.getString("nomeCliente"));
                client.setDtNasc(rst.getDate("dtNasCliente"));
                client.setRgCliente((rst.getString("rgCliente")));
                client.setCpfCliente((rst.getString("cpfCliente")));
                client.setFoneCliente((rst.getString("foneCliente")));
                client.setFone2Cliente((rst.getString("fone2Cliente")));
                client.setEmail((rst.getString("emailCliente")));   
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return client; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }

    @Override
    public Client retrieve(String descricao) {
        String sqlExecutar     =   " SELECT idcidade, "
                                 + " descricaoCidade, "
                                 + " ufCidade "
                                 + " FROM cidade "
                                 + " WHERE cidade.descricaoCidade = ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();  
            Client client = new Client();
            
            while(rst.next()){
                client.setNome(rst.getString("nomeCliente"));
                client.setDtNasc(rst.getDate("dtNasCliente"));
                client.setRgCliente((rst.getString("rgCliente")));
                client.setCpfCliente((rst.getString("cpfCliente")));
                client.setFoneCliente((rst.getString("foneCliente")));
                client.setFone2Cliente((rst.getString("fone2Cliente")));
                client.setEmail((rst.getString("emailCliente")));   
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return client; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }  
    }

    @Override
    public void update(Client objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        
        String sqlExecutar = "UPDATE cliente "
                + "SET nomeCliente = ?, "
                + "dtNasCliente = ?, "
                + "cpfCliente = ?, "
                + "rgCliente = ?, "
                + "foneCliente = ?, "
                + "fone2Cliente = ?, "
                + "emailCliente = ?, "
                + "compleEnderecoCliente = ?, "
                + "endereco_idcep  = ? "
                + "WHERE cliente.idcliente = ?";
        
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            
            pstm.setString(1, objeto.getNome());
            pstm.setString(2, objeto.getDtNasc().toString());
            pstm.setString(3, objeto.getCpfCliente());
            pstm.setString(4, objeto.getRgCliente());
            pstm.setString(5, objeto.getFoneCliente());
            pstm.setString(6, objeto.getFone2Cliente());
            pstm.setString(7, objeto.getEmail());
            pstm.setString(8, objeto.getCompleEndereco());
            
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Client objeto) {
        
    }
}