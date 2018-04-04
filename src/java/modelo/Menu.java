
package modelo;

import java.util.ArrayList;

public class Menu {
    
    //Atributos.
    private int id;
    private String titulo;
    private String link;
    private String icone;
    MenuDAO mDAO = new MenuDAO();
    
    //Métodos gets e sets.
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getIcone() {
        return icone;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }
    
    
    //Esses métodos chamam os métodos da DAO.
    public void inserir() throws Exception {
        MenuDAO mDAO = new MenuDAO();
        mDAO.inserir(this);
    }
    
    public void alterar() throws Exception {
        MenuDAO mDAO = new MenuDAO();
        mDAO.alterar(this);
    }
    
    public void excluir() throws Exception {
        MenuDAO mDAO = new MenuDAO();
        mDAO.excluir(id);
    }
    
    public ArrayList<Menu> listar() throws Exception {
        MenuDAO mDAO = new MenuDAO();
        return
            mDAO.listar();
    }
}
