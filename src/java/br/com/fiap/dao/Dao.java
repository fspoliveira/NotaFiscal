package br.com.fiap.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
    protected Connection cn;
    protected PreparedStatement st;
    protected ResultSet rs;
    protected String erro;

    private String url="jdbc:mysql://localhost/notafiscal?user=root&password=fiap";

    public boolean abreConexao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url);
            return true;
        }
        catch(Exception ex) {
            erro = ex.getMessage();
            return false;
        }
    }

    public void fechaConexao() {
        try {
            cn.close();
        }
        catch(Exception ex) {}
    }

    public String getErro() {
        return erro;
    }

}
