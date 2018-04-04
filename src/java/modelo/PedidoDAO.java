package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;



public class PedidoDAO extends Conexao{
    
    

 public void inserir(Pedido p) throws Exception{
        String sql="INSERT INTO pedido (dataPedido,dataEntrega,dataPagamento,qtdVendida,totalPagar,situacao,id_cliente,id_funcionario) "
                + "VALUES(?,?,?,?,?,?,?,?)";
        this.conectar();
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setDate(1, new Date (p.getDataPedido().getTime()));
        pstm.setDate(2, new Date (p.getDataEntrega().getTime()));
        pstm.setDate(3, new Date (p.getDataPagamento().getTime()));
        pstm.setDouble(4, p.getQtdVendida());
        pstm.setDouble(5, p.getTotalPagar());
        pstm.setString(6, p.getSituacao());
        pstm.setInt(7, p.getCliente().getId());
        pstm.setInt(8, p.getFuncionario().getId());
        pstm.execute();
        this.desconectar();
    }
 
    public ArrayList<Pedido> listar() throws Exception{
        ArrayList<Pedido> lista = new ArrayList<Pedido>();
        String sql = "SELECT * FROM pedido";
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        while (rs.next()) {
            Pedido p = new Pedido();
            p.setId(rs.getInt("id"));
            p.setDataPedido(rs.getDate("dataPedido"));
            p.setDataEntrega(rs.getDate("dataEntrega"));
            p.setDataPagamento(rs.getDate("dataPagamento"));
            p.setQtdVendida(rs.getDouble("qtdVendida"));
            p.setTotalPagar(rs.getDouble("totalPagar"));
            p.setSituacao(rs.getString("situacao"));
            ClienteDAO cDAO= new ClienteDAO();
            p.setCliente(cDAO.carregarPorId(rs.getInt("idCliente")));
            FuncionarioDAO fDAO = new FuncionarioDAO();
            p.setFuncionario(fDAO.carregarPorId(rs.getInt("idFuncionario")));
            lista.add(p);
        }
        this.desconectar();
        return lista;
    }
    


    public void finalizarPedido(Pedido p) throws Exception{
//        this.conectar();
//        PreparedStatement pstm = conn.prepareStatement(sql);
//        pstm.setInt(1, p.getId());
//        pstm.execute();
//        this.desconectar();
    }
    
//    public void alterar(Pedido p) throws Exception{
//        String sql="UPDATE pedido SET dataPedido=?, dataEntrega=?, dataPagamento=?, qtdVendida=?, totalPagar=?, "
//                + "situacao=?, id_cliente=?, id_funcionario=?) "
//                + "WHERE id=?";
//        this.conectar();
//        PreparedStatement pstm = conn.prepareStatement(sql);
//        pstm.setDate(1, p.getDataPedido());
//        pstm.setDate(2, p.getDataEntrega());
//        pstm.setDate(3, p.getDataPagamento());
//        pstm.setDouble(4, p.getQtdVendida());
//        pstm.setDouble(5, p.getTotalPagar());
//        pstm.setString(6, p.getSituacao());
//        pstm.setInt(7, p.getCliente().getId());
//        pstm.setInt(8, p.getFuncionario().getId());
//        pstm.setInt(9, p.getId());
//        pstm.execute();
//        this.desconectar();
//    }
    
    public Pedido carregarPorId(int id) throws Exception{
        Pedido p = new Pedido();
        String sql = "SELECT * FROM pedido WHERE id="+id;
        ResultSet rs;
        this.conectar();
        Statement stm = conn.createStatement();
        rs = stm.executeQuery(sql);
        if (rs.next()) {
            p.setId(rs.getInt("id"));
            p.setDataPedido(rs.getDate("dataPedido"));
            p.setDataEntrega(rs.getDate("dataEntrega"));
            p.setDataPagamento(rs.getDate("dataPagamento"));
            p.setQtdVendida(rs.getDouble("qtdVendida"));
            p.setTotalPagar(rs.getDouble("totalPagar"));
            p.setSituacao(rs.getString("situacao"));
            ClienteDAO cDAO= new ClienteDAO();
            p.setCliente(cDAO.carregarPorId(rs.getInt("idCliente")));
            FuncionarioDAO fDAO = new FuncionarioDAO();
            p.setFuncionario(fDAO.carregarPorId(rs.getInt("idFuncionario")));
        }
        this.desconectar();
        return p;
    }    
    

}

