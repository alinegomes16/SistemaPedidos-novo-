package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;


public class PerfilDAO extends Conexao {
    
    public void inserir(Perfil perfil) throws Exception {
        
        String sql = "INSERT INTO perfil (nome, descricao) VALUES (?, ?)";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, perfil.getNome());
        pstm.setString(2, perfil.getDescricao());
        pstm.execute();
        
        this.desconectar();
            
    }
    
    public ArrayList<Perfil> listar() throws Exception{
        
        ArrayList<Perfil> lista = new ArrayList<Perfil>();
        
        String sql = "SELECT * FROM perfil";
        ResultSet rs;
        
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        
        while (rs.next()) {
            Perfil perfil = new Perfil();
            perfil.setId(rs.getInt("id"));
            perfil.setNome(rs.getString("nome"));
            perfil.setDescricao(rs.getString("descricao"));
            lista.add(perfil);
        }
        
        this.desconectar();
        return lista;
    }
    
    public void excluir(int id) throws Exception{
        
        String sql = "DELETE FROM perfil WHERE id = ?";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        
        this.desconectar();
        
    }

    public Perfil carregarPorId(int id) throws Exception{
        
        Perfil perfil = new Perfil(); 
        String sql = "SELECT * FROM perfil WHERE id="+id;
        ResultSet rs;
        
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        
        if (rs.next()) {
         
            perfil.setId(rs.getInt("id"));
            perfil.setNome(rs.getString("nome"));
            perfil.setDescricao(rs.getString("descricao"));
            perfil.setMeusMenus(this.listarMenu(id));
            
        }
        
        this.desconectar();
        return perfil;
    }
    
    public void alterar(Perfil perfil) throws Exception{
        
        String sql = "UPDATE perfil SET nome = ?, descricao = ? WHERE id=?";
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setString(1, perfil.getNome());
        pstm.setString(2, perfil.getDescricao());
        pstm.setInt(3, perfil.getId());
        pstm.execute();
        
        this.desconectar();
    }
    
    
    //Métodos relacionados a tabela associativa Menu_Perfil.
    //Método para listar os menus relacionados a um perfil especifico.
    public ArrayList<Menu> listarMenu(int id_perfil) throws Exception{
        
        ArrayList<Menu> lista = new ArrayList<Menu>();
        
        String sql = "SELECT m.* FROM menu as m, perfil_menu as pm WHERE m.id=pm.id_menu AND "
                + "pm.id_perfil="+id_perfil;
        ResultSet rs;
        
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        
        while (rs.next()) {
            Menu menus = new Menu();
            menus.setId(rs.getInt("id"));
            menus.setTitulo(rs.getString("titulo"));
            menus.setLink(rs.getString("link"));
            menus.setIcone(rs.getString("icone"));
            lista.add(menus);
        }
        
        this.desconectar();
        return lista;
    }
    
    
    public ArrayList<Menu> listarNaoMenu(int id_perfil) throws Exception{
        
        ArrayList<Menu> lista = new ArrayList<Menu>();
      
        String sql = "SELECT * FROM menu WHERE id NOT IN(SELECT id_menu FROM perfil_menu WHERE id_perfil="+id_perfil+")";
        ResultSet rs;
        
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        
        while (rs.next()){
            Menu menus = new Menu();
            menus.setId(rs.getInt("id"));
            menus.setTitulo(rs.getString("titulo"));
            menus.setLink(rs.getString("link"));
            menus.setIcone(rs.getString("icone"));
            lista.add(menus);
        }
        
        this.desconectar();
        return lista;
    }

    public void vincular(int id_perfil, int id_menu) throws Exception {
        
        String sql = "INSERT INTO perfil_menu (id_perfil, id_menu) VALUES (?, ?)";
        
        this.conectar(); 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_perfil);
        pstm.setInt(2, id_menu);
        pstm.execute();
        
        this.desconectar();
    }

    public void desvincular(int id_perfil, int id_menu) throws Exception {
        
        String sql = "DELETE FROM perfil_menu WHERE id_perfil=? AND id_menu=?";
        
        this.conectar(); 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_perfil);
        pstm.setInt(2, id_menu);
        pstm.execute();
        
        this.desconectar();
    }
    
}
