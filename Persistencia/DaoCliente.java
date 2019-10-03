package Persistencia;

import Entidade.Cliente;

import java.util.ArrayList;

public class DaoCliente {
    private ArrayList<Cliente> clientes;

    public DaoCliente(){ clientes = new ArrayList<Cliente>(); }

    public Cliente insere(int codigo, String cpf, String nome, String email, String senha, String endereco){
        Cliente cliente = new Cliente(codigo, cpf, nome, email, senha, endereco);
        clientes.add(cliente);
        return cliente;
    }

    public Cliente pesquisa(int codigo){
        for(Cliente c : clientes){
            if (c.get_codigo() == codigo)
                return c;
        }
        return null;
    }

    public boolean remove(int codigo){
        Cliente c = pesquisa(codigo);
        if(c!=null){
            clientes.remove(c);
            return true;
        }
        return false;
    }

    public Cliente altera(int codigo, String email, String senha, String endereco_novo, String endereco_antigo){
        Cliente c = pesquisa(codigo);
        if(c!=null){
            c.set_email(email);
            c.set_senha(senha);
            int posicao = c.procura_endereco(endereco_antigo);
            c.set_endereco(posicao, endereco_novo);
            return c;
        }
        return null;
    }

    public ArrayList<Cliente> lista_todos(){ return clientes; }
}
