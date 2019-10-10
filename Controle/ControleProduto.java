package Controle;

import Entidade.CategoriaProduto;
import Entidade.Produto;
import Persistencia.DaoProduto;
import java.util.ArrayList;


public class ControleProduto {
    private DaoProduto daoProduto;

    public ControleProduto(){
        daoProduto = new DaoProduto();
    }

    public Produto procuraProduto(int codigo){
        return daoProduto.pesquisa(codigo);
    }

    public Produto insere(int codigo, int qntd_estoque, String descricao, String nome_categoria, double preco,
                          ControleCategoriaProduto categorias_possiveis){
        Produto p = procuraProduto(codigo);
        CategoriaProduto c = categorias_possiveis.pesquisa(nome_categoria);
        if(c == null){
            System.out.println("Categoria invalida. Favor cria-la ou modifique o nome e tente novamente");
            return null;
        }
        else if(p==null)
            return daoProduto.insere(codigo, qntd_estoque, descricao, c, preco);
        else {
            System.out.println("Falha na insereção do produto. Ja existe um produto de codigo " + codigo);
            return null;
        }
    }

    public boolean remove(int codigo){ return daoProduto.remove(codigo); }

    public Produto altera_produto(int codigo, int qntd_estoque, String descricao, CategoriaProduto categoria, double preco ){
        return daoProduto.altera_produto(codigo, qntd_estoque, descricao, categoria, preco);
    }

   public Produto altera_estoque(int codigo, int modificacao_estoque){
        Produto p =  daoProduto.pesquisa(codigo);
        if(p!=null) {
            if (p.get_qtd_estoque() < modificacao_estoque) {
                System.out.println("O maximo que e possivel remover sao " + p.get_qtd_estoque() + " desse produto");
            }
            else{
                daoProduto.altera_qntd_estoque(p, modificacao_estoque);
            }
            return p;
        }
        return null;
    }


    public ArrayList<Produto> lista_todos(){ return daoProduto.lista_estoque(); }

}
