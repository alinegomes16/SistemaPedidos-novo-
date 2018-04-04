package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ClienteDAO extends Conexao{
    
    public void inserir(Cliente c) throws Exception{
        String sql="INSERT INTO cliente (nome,cpf,endereco,telefone) VALUES(?,?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, c.getNome());
        pstm.setString(2, c.getCpf());
        pstm.setString(3, c.getEndereco());
        pstm.setString(4, c.getTelefone());
        pstm.execute();
        this.desconectar();
    }
    
    public ArrayList<Cliente> listar() throws Exception{
        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        String sql = "SELECT * FROM cliente";
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            Cliente c = new Cliente();
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setCpf(rs.getString("cpf"));
            c.setEndereco(rs.getString("endereco"));
            c.setTelefone(rs.getString("telefone"));
            lista.add(c);
        }
        this.desconectar();
        return lista;
    }

    public void alterar(Cliente c) throws Exception{
        String sql="UPDATE cliente SET nome=?,cpf=?,endereco=?,telefone=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, c.getNome());
        pstm.setString(2, c.getCpf());
        pstm.setString(3, c.getEndereco());
        pstm.setString(4, c.getTelefone());
        pstm.setInt(5, c.getId());
        pstm.execute();
        this.desconectar();
    }

    public void excluir(int id) throws Exception{
        String sql="DELETE FROM cliente WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    
    public Cliente carregarPorId(int id) throws Exception{
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE id="+id;
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        if (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setCpf(rs.getString("cpf"));
            c.setEndereco(rs.getString("endereco"));
            c.setTelefone(rs.getString("telefone"));
        }
        this.desconectar();
        return c;
    }
    
    public Cliente carregarPorNome(String nome) throws Exception{
        
        Cliente c = new Cliente();
        String sql = "SELECT * FROM cliente WHERE nome='"+nome+"'";
        ResultSet rs;
        
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        
        if (rs.next()){
            c.setId(rs.getInt("id"));
            c.setNome(rs.getString("nome"));
            c.setCpf(rs.getString("cpf"));
            c.setEndereco(rs.getString("endereco"));
            c.setTelefone(rs.getString("telefone"));
        }
        this.desconectar();
        return c;
    }
}
