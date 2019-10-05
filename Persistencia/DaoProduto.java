package Persistencia;

import Entidade.CategoriaProduto;
import Entidade.Produto;

import java.util.ArrayList;

public class DaoProduto {
    private ArrayList<Produto> lista_produtos;

    public DaoProduto(){
        this.lista_produtos = new ArrayList<Produto>();
    }

    public Produto insere(int codigo, int qntd_estoque, String descricao, CategoriaProduto categoria, double preco){
        Produto produto = new Produto(codigo, qntd_estoque, descricao, categoria, preco);
        lista_produtos.add(produto);
        return produto;
    }

    public Produto pesquisa(int codigo){
        for(Produto p : lista_produtos){
            if(p.get_Codigo() == codigo)
                return p;
        }
        return null;
    }

    public boolean remove(int codigo){
        Produto produto = pesquisa(codigo);
        if(produto != null) {
            lista_produtos.remove(produto);
            return true;
        }
        return false;
    }

    public Produto altera_produto(int codigo, int qntd_estoque, String descricao, CategoriaProduto categoria, double preco ){
        Produto p = pesquisa(codigo);
        if (p!= null){
            p.set_categoria(categoria);
            p.set_descricao(descricao);
            p.set_estoque(qntd_estoque);
            p.set_preco(preco);
            return p;
        }
        return null;
    }

    public Produto altera_qntd_estoque(Produto p, int modificacao_estoque){
        p.set_estoque(modificacao_estoque);
        return p;
    }

    public ArrayList<Produto> lista_estoque(){ return lista_produtos; }
}
