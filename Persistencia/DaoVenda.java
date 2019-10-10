package Persistencia;

import Entidade.Cliente;
import Entidade.Produto;
import Entidade.StatusVenda;
import Entidade.Venda;

import java.util.ArrayList;

public class DaoVenda {
    private ArrayList<Venda> lista_vendas;

    public DaoVenda(){ lista_vendas = new ArrayList<Venda>(); }

    public Venda insere(int codigo, Cliente cliente, ArrayList<Produto> produtos, String data, StatusVenda status){
        Venda venda = new Venda(codigo, cliente, produtos, data, status);
        lista_vendas.add(venda);
        return venda;
    }

    public Venda pesquisa(int codigo){
        for(Venda v : lista_vendas){
            if(v.get_codigo() == codigo)
                return v;
        }
        return null;
    }

    public boolean remove(int codigo){
        Venda v = pesquisa(codigo);
        if(v!=null){
            lista_vendas.remove(v);
            return true;
        }
        return false;
    }

    public Venda altera(int codigo, ArrayList<Produto> produtos, ArrayList<Integer> qntd_cada_produto,
                        StatusVenda status){
        Venda v = pesquisa(codigo);
            if(v!=null){
                v.set_produtos(produtos);
                v.set_status(status);
                return v;
            }
            return null;
    }

    public ArrayList<Venda> lista_todas(){ return lista_vendas; }
}


