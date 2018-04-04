package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FuncionarioDAO extends Conexao{

    public void inserir(Funcionario f) throws Exception{
        String sql="INSERT INTO funcionario (nome,cpf,telefone,endereco,email,senha,id_perfil) VALUES(?,?,?,?,?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, f.getNome());
        pstm.setString(2, f.getCpf());
        pstm.setInt(3, f.getTelefone());
        pstm.setString(4, f.getEndereco());
        pstm.setString(5, f.getEmail());
        pstm.setString(6, f.getSenha());
        pstm.setInt(7, f.getPerfil().getId());
        pstm.execute();
        this.desconectar();
    }
    public ArrayList<Funcionario> listar() throws Exception{
        ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
        String sql = "SELECT * FROM funcionario";
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            Funcionario f = new Funcionario();
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setCpf(rs.getString("cpf"));
            f.setTelefone(rs.getInt("telefone"));
            f.setEndereco(rs.getString("endereco"));
            f.setEmail(rs.getString("email"));
            f.setSenha(rs.getString("senha"));
            PerfilDAO pDAO = new PerfilDAO();
            f.setPerfil(pDAO.carregarPorId(rs.getInt("id_perfil")));
            lista.add(f);
        }
        this.desconectar();
        return lista;
    }

    public void alterar(Funcionario f) throws Exception{
        String sql="UPDATE funcionario SET nome=?,cpf=?,telefone=?,endereco=?,email=?,senha=?,id_perfil=? WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, f.getNome());
        pstm.setString(2, f.getCpf());
        pstm.setInt(3, f.getTelefone());
        pstm.setString(4, f.getEndereco());
        pstm.setString(5, f.getEmail());
        pstm.setString(6, f.getSenha());
        pstm.setInt(7, f.getPerfil().getId());
        pstm.setInt(8, f.getId());
        pstm.execute();
        this.desconectar();
    }

    public void excluir(int id) throws Exception{
        String sql="DELETE FROM funcionario WHERE id=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, id);
        pstm.execute();
        this.desconectar();
    }
    public Funcionario carregarPorId(int id) throws Exception{
        Funcionario f = new Funcionario();
        String sql = "SELECT * FROM funcionario WHERE id="+id;
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        if (rs.next()) {
            f.setId(rs.getInt("id"));
            f.setNome(rs.getString("nome"));
            f.setCpf(rs.getString("cpf"));
            f.setTelefone(rs.getInt("telefone"));
            f.setEndereco(rs.getString("endereco"));
            f.setEmail(rs.getString("email"));
            f.setSenha(rs.getString("senha"));
            PerfilDAO pDAO = new PerfilDAO();
            f.setPerfil(pDAO.carregarPorId(rs.getInt("id_perfil")));
        }
        this.desconectar();
        return f;
    }

    public Funcionario logar(String cpf, String senha) throws Exception{
               
        String sql ="SELECT * FROM funcionario WHERE cpf=?";
        Funcionario f = new Funcionario();
        ResultSet rs;
        
        
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, cpf);
        rs = pstm.executeQuery();
        
        if(rs.next()){
            if(rs.getString("senha").equals(senha)){
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setCpf(rs.getString("cpf"));
                f.setSenha(rs.getString("senha"));
                
                PerfilDAO pDAO = new PerfilDAO();
                f.setPerfil(pDAO.carregarPorId(rs.getInt("id_perfil")));
            }
        }
        
        this.desconectar();
        return f;
    }

    
    
    public Funcionario verificarFuncionario(String cpf) throws Exception{
         
        Funcionario f = new Funcionario();
        String sql = "SELECT * FROM funcionario WHERE cpf="+cpf;
        
        ResultSet rs;
        
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        
        if (rs.next()) {
            f.setId(rs.getInt("id"));
            f.setSenha(rs.getString("senha"));
            f.setCpf(rs.getString("cpf"));
        }
        this.desconectar();
        return f;
    }
    
    public void alterarSenha(String senha_nova, String cpf) throws Exception{
        
        String sql = "UPDATE funcionario SET senha=? WHERE cpf=?";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setString(1, senha_nova);
        pstm.setString(2, cpf);
        pstm.execute();
        this.desconectar();
        
    }
    
 
}
