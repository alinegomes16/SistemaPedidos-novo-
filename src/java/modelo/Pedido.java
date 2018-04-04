package modelo;

import java.util.Date;

public class Pedido {
    
    //Atributos.
    private int id;
    private Date dataPedido;
    private Date dataEntrega;
    private Date dataPagamento;
    private double qtdVendida;
    private double totalPagar;
    private String situacao;
    private Cliente cliente;
    private Funcionario funcionario;
    PedidoDAO pDAO = new PedidoDAO();
    
    
    //Métodos gets e sets.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(Date dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }
    
    public Date getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public double getQtdVendida() {
        return qtdVendida;
    }

    public void setQtdVendida(double qtdVendida) {
        this.qtdVendida = qtdVendida;
    }


    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double totalPagar) {
        this.totalPagar = totalPagar;
    }

     public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    
    //Esses métodos chamam os métodos da DAO.
    public void inserir() throws Exception {
        PedidoDAO pDAO = new PedidoDAO();
        pDAO.inserir(this);
    }
    public void finalizarPedido() throws Exception{
        PedidoDAO pDAO = new PedidoDAO();
        pDAO.finalizarPedido(this);
        
    }
    
}
