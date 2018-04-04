package modelo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Produto {
    
    
    //Atributos.
    private int id;
    private String nome;
    private String sabor;
    private String volume;
    private Date fabricacao;
    private Date validade;
    private Double valor;
    private Double qtdExistente;
    private String situacao;

    ProdutoDAO pDAO = new ProdutoDAO();

    
    //Métodos gets e sets.
     public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

     
    public Date getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(Date fabricacao) {
        this.fabricacao = fabricacao;
    }

    public Date getValidade() {
        return validade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
    
    public Double getQtdExistente() {
        return qtdExistente;
    }

    public void setQtdExistente(Double qtdExistente) {
        this.qtdExistente = qtdExistente;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    
    public String mudaSituacao (double qtdExistente){
        if (qtdExistente >= 80){
            situacao = "Estoque Alto";
        }else
            if (qtdExistente <= 20){
                situacao = "Em Falta";
            }else
                if (qtdExistente > 20 && qtdExistente < 80){
                    situacao = "Estoque Baixo";
                }
        return situacao;
    }

    
    //Esses métodos chamam os métodos da DAO.
    public void inserir() throws Exception {
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.inserir(this);
    }
    
    public void alterar() throws Exception {
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.alterar(this);
    }
    
    public void excluir() throws Exception {
        ProdutoDAO pDAO = new ProdutoDAO();
        pDAO.excluir(id);
    }
    
    public ArrayList<Produto> listar() throws Exception {
        ProdutoDAO pDAO = new ProdutoDAO();
        return
            pDAO.listar();
    }

    public void carregarProduto(String volume, String sabor, String nome) throws Exception {
        pDAO.carregarProduto(nome, sabor, volume);
        
    }

    public void vincularProduto(int id_produto, double quantidade, double valor_unitario) throws Exception {
        pDAO.vincularProduto(id_produto, quantidade, valor_unitario);
    }

    public Produto carregarPorId(int id) throws Exception {
        return
                pDAO.carregarPorId(id);
                

    }

   
    
}
