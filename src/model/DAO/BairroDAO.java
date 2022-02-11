package model.DAO;

import java.util.List;
import model.bo.Bairro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BairroDAO implements InterfaceDAO<Bairro>{
    @Override
    public void create(Bairro objeto) {
        //Abrindo conexão
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = "INSERT INTO bairro (descricaoBairro) VALUES(?)";
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoBairro());
            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        //fechar a conexão
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Bairro> retrieve() {
        String sqlExecutar     =   " SELECT idbairro, "
                                 + " descricaoBairro  "
                                 + " FROM bairro";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<Bairro> bairros = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            rst = pstm.executeQuery();            
            
            while(rst.next()){
                Bairro bairro = new Bairro();
                bairro.setIdBairro(rst.getInt("idbairro"));
                bairro.setDescricaoBairro(rst.getString("descricaoBairro"));
                bairros.add(bairro);
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return bairros;       
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
    }
    @Override
    public Bairro retrieve(int codigo) {
        String sqlExecutar     =   " SELECT idbairro, "
                                 + " descricaoBairro  "
                                 + " FROM bairro "
                                 + " WHERE bairro.idbairro = ?";
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setInt(1, codigo);
            
            rst = pstm.executeQuery();  
            Bairro bairro = new Bairro();
            while(rst.next()){
                bairro.setIdBairro(rst.getInt("idbairro"));
                bairro.setDescricaoBairro(rst.getString("descricaoBairro"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return bairro; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }
          
    }

    @Override
    public Bairro retrieve(String descricao) {
        String sqlExecutar     =   " SELECT idbairro, "
                                 + " descricaoBairro  "
                                 + " FROM bairro "
                                 + " WHERE bairro.descricaoBairro = ?";
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, descricao);
            rst = pstm.executeQuery();  
            Bairro bairro = new Bairro();
            
            while(rst.next()){
                bairro.setIdBairro(rst.getInt("idbairro"));
                bairro.setDescricaoBairro(rst.getString("descricaoBairro"));
            }
            ConnectionFactory.closeConnection(conexao, pstm, rst);

            return bairro; 
        } catch(Exception ex){
            ex.printStackTrace();
            ConnectionFactory.closeConnection(conexao, pstm, rst);
            return null;
        }  
    }

    @Override
    public void update(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        String sqlExecutar = " UPDATE bairro "
                           + " SET descricaoBairro   = ? "
                           + " WHERE bairro.idbairro = ? ";
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(sqlExecutar);
            pstm.setString(1, objeto.getDescricaoBairro());
            pstm.setInt(2, objeto.getIdBairro());
            pstm.executeUpdate();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public void delete(Bairro objeto) {
    }
    
}
