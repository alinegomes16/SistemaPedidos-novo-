package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class MenuDAO extends Conexao{
    
    public void inserir(Menu menu) throws Exception {
        
        String sql = "INSERT INTO menu (titulo, link, icone) VALUES (?, ?, ?)";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, menu.getTitulo());
        pstm.setString(2, menu.getLink());
        pstm.setString(3, menu.getIcone());
        pstm.execute();
        
        this.desconectar();
    }
    
    
    public ArrayList<Menu> listar() throws Exception{
        
        ArrayList<Menu> lista = new ArrayList<Menu>();
        
        String sql = "SELECT * FROM menu";
        ResultSet rs;
        
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);  //o rs tem a mesma função do pdo no php;
        
        while (rs.next()){
            Menu menu = new Menu();
            menu.setId(rs.getInt("id"));
            menu.setTitulo(rs.getString("titulo"));
            menu.setLink(rs.getString("link"));
            menu.setIcone(rs.getString("icone"));
            lista.add(menu);
        }
        
        this.desconectar();
        return lista;
    }

    
    public void excluir(int id) throws Exception{
      
        String sql = "DELETE FROM menu WHERE id=?";
        
        this.conectar();
        
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        
        this.desconectar();
        
    }

    
    public Menu carregarPorId(int id) throws Exception{
        
        String sql = "SELECT * FROM menu WHERE id="+id;
        Menu menu = new Menu();
        ResultSet rs;
        
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        
        if (rs.next()) {
            menu.setId(rs.getInt("id"));
            menu.setTitulo(rs.getString("titulo"));
            menu.setLink(rs.getString("link"));
            menu.setIcone(rs.getString("icone"));
        }
        
        this.desconectar();
        return menu;
    }
    
    
    public void alterar(Menu menu) throws Exception {
        
         String sql = "UPDATE menu set titulo = ?, link = ?, icone =? WHERE id = ?";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        pstm.setString(1, menu.getTitulo());
        pstm.setString(2, menu.getLink());
        pstm.setString(3, menu.getIcone());
        pstm.setInt(4, menu.getId());
        pstm.execute();
        
        this.desconectar();
        
    }
    
}
