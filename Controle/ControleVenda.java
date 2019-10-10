package Controle;

import Entidade.Cliente;
import Entidade.Produto;
import Entidade.StatusVenda;
import Entidade.Venda;
import Persistencia.DaoVenda;

import java.util.ArrayList;

public class ControleVenda {
    private DaoVenda daoVenda;

    public ControleVenda(){ daoVenda = new DaoVenda(); }

    public Venda pesquisa_venda(int codigo){ return daoVenda.pesquisa(codigo); }

    public Produto adiciona_produto_a_compra(int codigo, int quantidade, ControleProduto produtos_existentes){
        Produto p = produtos_existentes.procuraProduto(codigo);
        if(p!=null){
            if(p.get_qtd_estoque() < quantidade)
                System.out.println("Nao temos essa quantidade do produto em estoque");
            else{
                produtos_existentes.altera_estoque(codigo, -quantidade);
                Produto produto_comprado = new Produto(codigo, quantidade, p.get_descricao(), p.get_categoria(), p.get_preco());
                return produto_comprado;
            }
        }
        return null;
    }

    public Cliente verifica_cliente(int codigo_cliente, ControleCliente clientes_existentes){
        Cliente c = clientes_existentes.pesquisa_por_codigo(codigo_cliente);
        if(c!=null)
            return c;
        return null;
    }

    public Venda insere_Venda(int codigo, ArrayList<Produto> produtos_comprados, int codigo_cliente, String data,
                              ControleCliente clientes_existentes){
        Venda v = pesquisa_venda(codigo);
        int i = 0;
        if(v==null){
            Cliente comprador = verifica_cliente(codigo_cliente, clientes_existentes);
            if(comprador!=null){
                return daoVenda.insere(codigo, comprador, produtos_comprados, data, StatusVenda.PENDENTE);
            }
            System.out.println("Cliente nao existe");
        }
        return null;
    }
}
