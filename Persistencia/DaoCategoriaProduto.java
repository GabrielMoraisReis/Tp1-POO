package Persistencia;

import Entidade.CategoriaProduto;

import java.util.ArrayList;

public class DaoCategoriaProduto {
    private ArrayList<CategoriaProduto> categorias;

    public DaoCategoriaProduto(){ categorias = new ArrayList<CategoriaProduto>(); }

    public CategoriaProduto insere(String nome, String caracteristica){
        CategoriaProduto categoria = new CategoriaProduto(nome, caracteristica);
        this.categorias.add(categoria);
        return categoria;
    }

    public CategoriaProduto pesquisa(String nome){
        for(CategoriaProduto c : categorias){
            if(c.get_nome().equalsIgnoreCase(nome))
                return c;
        }
        return null;
    }

    public boolean remove(String nome){
        CategoriaProduto c;
        c = pesquisa(nome);
        if(c!=null){
            categorias.remove(c);
            return true;
        }
        return false;
    }

    public CategoriaProduto altera(String nome, String caracteristica){
        CategoriaProduto c = pesquisa(nome);
        if(c!=null){
            c.set_caracteristica(caracteristica);
            return c;
        }
        return null;
    }

    public ArrayList<CategoriaProduto> lista_todos(){ return categorias;}
}
