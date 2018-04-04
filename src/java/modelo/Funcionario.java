package modelo;

import java.util.ArrayList;

public class Funcionario {
    
    //Atributos
    private int id;
    private String nome;
    private String cpf;
    private int telefone;
    private String endereco;
    private String email;
    private String senha;
    private Perfil perfil;
    FuncionarioDAO fDAO = new FuncionarioDAO();

    
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

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    
    //Esses métodos chamam os métodos da DAO.
    public void inserir() throws Exception {
        FuncionarioDAO fDAO = new FuncionarioDAO();
        fDAO.inserir(this);
    }
    
    public void alterar() throws Exception {
        FuncionarioDAO fDAO = new FuncionarioDAO();
        fDAO.alterar(this);
    }
    
    public void excluir() throws Exception {
        FuncionarioDAO fDAO = new FuncionarioDAO();
        fDAO.excluir(id);
    }
    
    public ArrayList<Funcionario> listar() throws Exception {
        FuncionarioDAO fDAO = new FuncionarioDAO();
        return
            fDAO.listar();
    }
    
    //Método usado para logar.
    public Funcionario logar(String cpf, String senha) throws Exception { 
        FuncionarioDAO fDAO = new FuncionarioDAO();
        return
                fDAO.logar(cpf, senha);    
    }

    public void alterarSenha(String senha_nova, String cpf) throws Exception{
        FuncionarioDAO fDAO = new FuncionarioDAO();
        fDAO.alterarSenha(senha_nova,cpf);
    }

    public Funcionario verificarFuncionario(String cpf) throws Exception {
        FuncionarioDAO fDAO = new FuncionarioDAO();
        return 
                fDAO.verificarFuncionario(cpf);
    }
    
}
