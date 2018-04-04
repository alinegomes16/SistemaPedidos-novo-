package modelo;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
    
    Connection conn;
    
    public void conectar() throws Exception {
        
        Class.forName("com.mysql.jdbc.Driver");
        
        String url, user, pass;
        url = "jdbc:mysql://localhost:3306/sorveteria";
        user = "root";
        pass = "";
        
        conn = DriverManager.getConnection(url, user, pass);
    }
    
    public void desconectar() throws Exception {
        
        if(!conn.isClosed()){
            conn.close();
        }
    }
    
}
