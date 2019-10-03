package Entidade;

public class Produto {
    private int codigo;
    private int qtd_estoque;
    private String descricao;
    private CategoriaProduto categoria;
    private double preco;

    public Produto(int codigo, int qtd_estoque, String descricao, CategoriaProduto categoria, double preco){
        this.codigo = codigo;
        this.qtd_estoque = qtd_estoque;
        this.descricao = descricao;
        this.categoria = categoria;
        this.preco = preco;
    }

    public int get_qtd_estoque(){ return qtd_estoque; }

    public void set_estoque(int modificacao_estoque){
        qtd_estoque = qtd_estoque + modificacao_estoque;
    }

    public int get_Codigo(){ return codigo; }

    public String get_descricao(){ return descricao; }

    public void set_descricao(String descricao){
        this.descricao = descricao;
    }

    public CategoriaProduto get_categoria(){ return categoria; }

    public void set_categoria (CategoriaProduto categoria){
        this.categoria = categoria;
    }

    public double get_preco(){ return preco; }

    public void set_preco(double preco){
        this.preco = preco;
    }
}
