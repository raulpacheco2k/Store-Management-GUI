package model.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ConnectionFactory {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String banco = "jdbc:mysql://localhost:3306/bancoLoja";
    private static final String user = "root";
    private static final String senha = "@7sBM9PGxO!g";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(mountStringConnection(banco, user, senha));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static String mountStringConnection(String banco, String user, String senha) {
        return banco + "?verifyServerCertificate=false&useSSL=false&requireSSL=false&USER=" + user + "&password=" + senha + "&serverTimezone=UTC";
    }

    public static void closeConnection(Connection conexao) {
        try {
            conexao.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection conexao, PreparedStatement pstm) {
        try {
            pstm.close();
            conexao.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void closeConnection(Connection conexao, PreparedStatement pstm, ResultSet rst) {
        try {
            pstm.close();
            rst.close();
            conexao.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
