package modelo;

import java.util.ArrayList;


public class Perfil {
    
    //Atributos.
    private int id;
    private String nome;
    private String descricao;
    private ArrayList<Menu> meusMenus;
    PerfilDAO pDAO = new PerfilDAO();
    

    
    //Métodos gets sets.
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public ArrayList<Menu> getMeusMenus() {
        return meusMenus;
    }

    public void setMeusMenus(ArrayList<Menu> meusMenus) {
        this.meusMenus = meusMenus;
    }
    
    
    
    //Esses métodos chamam os métodos da DAO.
    public void inserir() throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        pDAO.inserir(this);
    }
    
    public void alterar() throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        pDAO.alterar(this);
    }
    
    public void excluir() throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        pDAO.excluir(id);
    }
    
    public ArrayList<Perfil> listar() throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        return
            pDAO.listar();
    }
    
    
    public void carregarPorId(int id) throws Exception{
        this.id = pDAO.carregarPorId(id).getId();
        this.nome = pDAO.carregarPorId(id).getNome();
        this.descricao = pDAO.carregarPorId(id).getDescricao();
        this.meusMenus = pDAO.carregarPorId(id).getMeusMenus();
    }
    

    public ArrayList<Menu> listarMenu(int id_perfil) throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        return
            pDAO.listarMenu(id_perfil);
    }
    
    public ArrayList<Menu> listarNaoMenu(int id_perfil) throws Exception {
        PerfilDAO pDAO = new PerfilDAO();
        return
            pDAO.listarNaoMenu(id_perfil);
    }

    public void vincularMenu(int id_perfil, int id_menu) throws Exception {
        pDAO.vincular(id_perfil, id_menu);
    }

    public void desvincularMenu(int id_perfil, int id_menu) throws Exception {
        pDAO.desvincular(id_perfil, id_menu);
    }
}
