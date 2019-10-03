package Entidade;

import jdk.net.SocketFlow;

import java.util.ArrayList;

public class Venda {
    private int codigo;
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    private ArrayList<Integer> qntd_cada_produto; //posições correspondentes entre um produto e sua quantidade vendida
    private String data;
    private StatusVenda status;

    public Venda(int codigo, Cliente cliente, ArrayList<Produto> produtos, ArrayList<Integer> qntd_cada_produto,
                 String data, StatusVenda status){
        this.cliente = cliente;
        this.data = data;
        this.produtos = new ArrayList<Produto>();
        this.produtos = produtos;
        this.qntd_cada_produto = new ArrayList<Integer>();
        this.qntd_cada_produto = qntd_cada_produto;
        this.status = StatusVenda.PENDENTE;
    }

    public int get_codigo(){ return codigo; }

    public Cliente get_cliente(){ return cliente; }

    public ArrayList<Produto> get_produtos(){ return produtos; }

    public void set_produtos(ArrayList<Produto> produtos){
        this.produtos = produtos;
    }

    public void add_produto(Produto produto, int qntd_cada_produto){
        this.produtos.add(produto);
    }

    public void remove_produto(Produto produto){
        this.produtos.add(produto);
    }

    public ArrayList<Integer> get_qntd_produtos(){ return qntd_cada_produto; }

    public void set_qntd_produtos(ArrayList<Integer> qntd_cada_produto){
        this.qntd_cada_produto = qntd_cada_produto;
    }

    public void add_qntd_produtos(int qntd_produto){
        qntd_cada_produto.add(qntd_produto);
    }

    public void dimiui_qntd_produtos(int qntd_produto, int index){
        qntd_cada_produto.set(index, qntd_produto);
    }

    public void remove_qntd_produto(int index){
        qntd_cada_produto.remove(index);
    }

    public String get_data(){ return data; }

    public StatusVenda get_status(){ return status; }

    public void set_status(StatusVenda status){
        this.status = status;
    }

}
