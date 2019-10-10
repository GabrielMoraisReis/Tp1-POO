package Entidade;

import jdk.net.SocketFlow;

import java.util.ArrayList;

public class Venda {
    private int codigo;
    private Cliente cliente;
    private ArrayList<Produto> produtos;
    private String data;
    private StatusVenda status;

    public Venda(int codigo, Cliente cliente, ArrayList<Produto> produtos, String data, StatusVenda status){
        this.cliente = cliente;
        this.data = data;
        this.produtos = new ArrayList<Produto>();
        this.produtos = produtos;
        this.status = StatusVenda.PENDENTE;
    }

    public int get_codigo(){ return codigo; }

    public Cliente get_cliente(){ return cliente; }

    public ArrayList<Produto> get_produtos(){ return produtos; }

    public void set_produtos(ArrayList<Produto> produtos){
        this.produtos = produtos;
    }

    public void add_produto(Produto produto){
        this.produtos.add(produto);
    }

    public void remove_produto(Produto produto){
        this.produtos.remove(produto);
    }

    public String get_data(){ return data; }

    public StatusVenda get_status(){ return status; }

    public void set_status(StatusVenda status){
        this.status = status;
    }

}
