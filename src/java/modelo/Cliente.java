package modelo;

import java.util.ArrayList;

public class Cliente {
    
    //Atributos.
    private int id;
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    ClienteDAO clienteDAO = new ClienteDAO();

  
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

   //Esses métodos chamam os métodos da DAO.
    public void inserir() throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.inserir(this);
    }
    
    public void alterar() throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.alterar(this);
    }
    
    public void excluir() throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.excluir(id);
    }
    
    public ArrayList<Cliente> listar() throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        return
            clienteDAO.listar();
    }
    
    public Cliente carregarPorNome(String nome) throws Exception {
        ClienteDAO clienteDAO = new ClienteDAO();
        
        return
                clienteDAO.carregarPorNome(nome);
    }
    
//    public void carregarPorNome(String nome) throws Exception{
//        this.id = clienteDAO.carregarPorNome(nome).getId();
//        this.nome = clienteDAO.carregarPorNome(nome).getNome();
//        this.cpf = clienteDAO.carregarPorNome(nome).getCpf();
//        this.endereco = clienteDAO.carregarPorNome(nome).getEndereco();
//        this.telefone = clienteDAO.carregarPorNome(nome).getTelefone();
//        
//        ClienteDAO cDAO = new ClienteDAO();
//        cDAO.carregarPorNome(nome);
//    }
}
