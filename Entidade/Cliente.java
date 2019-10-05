package Entidade;

import java.util.ArrayList;

public class Cliente {
    private int codigo;
    private String cpf;
    private String nome;
    private String email;
    private String senha;
    private ArrayList<String> enderecos;

    public Cliente(int codigo, String cpf, String nome, String email, String senha, String endereco){
        this.enderecos = new ArrayList<String>();
        this.codigo = codigo;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        enderecos.add(endereco);
    }

    public int get_codigo(){ return codigo; }

    public String get_cpf() { return cpf; }

    public String get_nome() { return nome;}

    public String get_email(){ return email;}

    public void set_email(String email){
        this.email = email;
    }

    public String get_senha(){ return senha; }

    public void set_senha(String senha){
        this.senha = senha;
    }

    public ArrayList<String> get_enderecos(){ return enderecos; }

    public int procura_endereco(String endereco){
        for(int i = 0; i<enderecos.size(); i++){
            if(enderecos.get(i).equalsIgnoreCase(endereco) )
                return i;
        }
        return -1;
    }
    public String adiciona_endereco(String endereco){
        enderecos.add(endereco);
        return endereco;
    }

    public void remove_endereco(int index){
            enderecos.remove(index);
    }

    public void set_endereco(int index, String endereco){
        enderecos.set(index, endereco);
    }
}
