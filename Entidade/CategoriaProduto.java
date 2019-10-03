package Entidade;

public class CategoriaProduto {
    private String nome;
    private String caracteristica;

    public CategoriaProduto(String nome, String caracteristica){
        this.nome = nome;
        this.caracteristica = caracteristica;
    }

    public String get_nome(){ return nome; }

    public String get_caracteristica(){ return caracteristica; }

    public void set_caracteristica(String caracteristica){
        this.caracteristica = caracteristica;
    }
}
