package Controle;

import Entidade.CategoriaProduto;
import Entidade.Produto;
import Persistencia.DaoCategoriaProduto;

import java.util.ArrayList;

public class ControleCategoriaProduto {
    private DaoCategoriaProduto daoCategoriaProduto;

    public ControleCategoriaProduto(){ daoCategoriaProduto = new DaoCategoriaProduto(); }

    public CategoriaProduto insere(String nome, String descricao){
        CategoriaProduto c = pesquisa(nome);
        if (c==null){
            return daoCategoriaProduto.insere(nome, descricao);
        }
        System.out.println("Categoria ja existe");
        return null;
    }

    public CategoriaProduto pesquisa(String nome){
        return daoCategoriaProduto.pesquisa(nome);
    }

    public CategoriaProduto altera(String nome, String descricao){
            return daoCategoriaProduto.altera(nome, descricao);
    }

    public ArrayList<CategoriaProduto> lista_categoris(){ return daoCategoriaProduto.lista_todos();}


}
