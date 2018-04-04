package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class ProdutoDAO extends Conexao{
    
    public void inserir(Produto p) throws Exception{
        String sql="INSERT INTO produto (nome,sabor,volume,fabricacao,validade,valor,qtd_existente,situacao) VALUES(?,?,?,?,?,?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        
        
        pstm.setString(1, p.getNome());
        pstm.setString(2, p.getSabor());
        pstm.setString(3, p.getVolume());
        pstm.setDate(4, new Date (p.getFabricacao().getTime()));
        pstm.setDate(5, new Date (p.getValidade().getTime()));
        pstm.setDouble(6, p.getValor());
        pstm.setDouble(7, p.getQtdExistente());
        
        p.mudaSituacao(p.getQtdExistente());
        pstm.setString(8, p.getSituacao());
        
        pstm.execute();
        this.desconectar();
    }
    
    public ArrayList<Produto> listar() throws Exception{
        ArrayList<Produto> lista = new ArrayList<Produto>();
        String sql = "SELECT * FROM produto";
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        
                
        while (rs.next()) {
            Produto p = new Produto();
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setSabor(rs.getString("sabor"));
            p.setVolume(rs.getString("volume"));
            p.setFabricacao(rs.getDate("fabricacao"));
            p.setValidade(rs.getDate("validade"));
            p.setValor(rs.getDouble("valor"));
            p.setQtdExistente(rs.getDouble("qtd_existente"));
            p.setSituacao(rs.getString("situacao"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }
    
    public ArrayList<Produto> listarNome() throws Exception{
        ArrayList<Produto> lista = new ArrayList<Produto>();
        String sql = "SELECT DISTINCT nome FROM produto";
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        
                
        while (rs.next()) {
            Produto p = new Produto();
            p.setNome(rs.getString("nome"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }
    
    public ArrayList<Produto> listarSabor() throws Exception{
        ArrayList<Produto> lista = new ArrayList<Produto>();
        String sql = "SELECT DISTINCT sabor FROM produto";
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        
                
        while (rs.next()) {
            Produto p = new Produto();
            p.setSabor(rs.getString("sabor"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }
    
    public ArrayList<Produto> listarVolume() throws Exception{
        ArrayList<Produto> lista = new ArrayList<Produto>();
        String sql = "SELECT DISTINCT volume FROM produto";
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        
                
        while (rs.next()) {
            Produto p = new Produto();
            p.setVolume(rs.getString("volume"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }
    
    public ArrayList<Produto> listarValor() throws Exception{
        ArrayList<Produto> lista = new ArrayList<Produto>();
        String sql = "SELECT DISTINCT valor FROM produto";
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        
                
        while (rs.next()) {
            Produto p = new Produto();
            p.setValor(rs.getDouble("valor"));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }
    

    public void alterar(Produto p) throws Exception{
        String sql="UPDATE produto SET nome=?,sabor=?,volume=?,fabricacao=?,validade=?,valor=?,qtd_existente=?,situacao=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, p.getNome());
        pstm.setString(2, p.getSabor());
        pstm.setString(3, p.getVolume());
        pstm.setDate(4, new Date (p.getFabricacao().getTime()));
        pstm.setDate(5, new Date (p.getValidade().getTime()));
        pstm.setDouble(6, p.getValor());
        pstm.setDouble(7, p.getQtdExistente());
        pstm.setString(8, p.getSituacao());
        pstm.setInt(9, p.getId());
        pstm.execute();
        this.desconectar();
    }

    public void excluir(int id) throws Exception{
        String sql="DELETE FROM produto WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    
    public Produto carregarPorId(int id) throws Exception{
        Produto p = new Produto();
        String sql = "SELECT * FROM produto WHERE id="+id;
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setSabor(rs.getString("sabor"));
            p.setVolume(rs.getString("volume"));
            p.setFabricacao(rs.getDate("fabricacao"));
            p.setValidade(rs.getDate("validade"));
            p.setValor(rs.getDouble("valor"));
            p.setQtdExistente(rs.getDouble("qtd_existente"));
            p.setSituacao(rs.getString("situacao"));
        }
        this.desconectar();
        return p;
        
    }
    
    public Produto carregarProduto(String nome, String sabor, String volume) throws Exception{
        Produto p = new Produto();
        String sql = "SELECT * FROM produto WHERE nome='"+nome+"' AND sabor='"+sabor+"' AND volume='"+volume+"'";
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setNome(rs.getString("nome"));
            p.setSabor(rs.getString("sabor"));
            p.setVolume(rs.getString("volume"));
            p.setFabricacao(rs.getDate("fabricacao"));
            p.setValidade(rs.getDate("validade"));
            p.setValor(rs.getDouble("valor"));
            p.setQtdExistente(rs.getDouble("qtd_existente"));
            p.setSituacao(rs.getString("situacao"));
        }
        this.desconectar();
        return p;
        
    }

    public void vincularProduto(int id_produto, double quantidade, double valor_unitario) throws Exception{
        String sql = "INSERT INTO pedido_produto (id_produto, quantidade, valor_unitario) VALUES (?, ?, ?)";
        
        this.conectar(); 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id_produto);
        pstm.setDouble(2, quantidade);
        pstm.setDouble(3, valor_unitario);
        pstm.execute();
        
        this.desconectar();
    }
}
