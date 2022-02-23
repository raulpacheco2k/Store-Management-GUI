package model.DAO;

import java.util.List;
import model.bo.Bairro;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BairroDAO implements InterfaceDAO<Bairro>{
    Bairro model = new Bairro();

    @Override
    public void create(Bairro objeto) {
        Connection conexao = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        
        try{
            pstm = conexao.prepareStatement(model.insert());
            pstm.setString(1, objeto.getDescricaoBairro());
            pstm.executeUpdate();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        ConnectionFactory.closeConnection(conexao, pstm);
    }

    @Override
    public List<Bairro> retrieve() {
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        List<Bairro> bairros = new ArrayList<>();
        
        try{
            pstm = conexao.prepareStatement(model.findAll());
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
        
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(model.findById());
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
        Connection conexao     = ConnectionFactory.getConnection();
        PreparedStatement pstm = null;
        ResultSet rst          = null;
        
        try{
            pstm = conexao.prepareStatement(model.findByField("descricaoBairro"));
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
        PreparedStatement pstm = null;
        try{
            pstm = conexao.prepareStatement(model.update());
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
