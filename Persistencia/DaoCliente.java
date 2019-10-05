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

    public boolean verifica_senha_codigo(int codigo, String senha_inserida){
        Cliente c = pesquisa_codigo(codigo);
        if(c.get_senha().equals(senha_inserida))
            return true;
        System.out.println("Senha invalida");
        return false;
    }

    public boolean verifica_senha_cpf(String cpf, String senha_inserida){
        Cliente c = pesquisa_cpf(cpf);
        if(c.get_senha().equals(senha_inserida))
            return true;
        System.out.println("Senha invalida");
        return false;
    }

    public String insere_endereco(int codigo, String endereco){
        Cliente c = pesquisa_codigo(codigo);
        if(c != null && c.procura_endereco(endereco)==(-1))
            return c.adiciona_endereco(endereco);
        else if(c!=null)
            System.out.println("Endereco ja cadastrado");
        else
            System.out.println("Cliente nao encontrado");
        return null;
    }

    public Cliente pesquisa_codigo(int codigo){
        for(Cliente c : clientes){
            if (c.get_codigo() == codigo)
                return c;
        }
        return null;
    }

    public Cliente pesquisa_cpf(String cpf){
        for(Cliente c : clientes){
            if(c.get_cpf().equals(cpf))
                return c;
        }
        return null;
    }

    public Cliente pesquisa_email(String email){
        for(Cliente c : clientes){
            if(c.get_email().equals(email)){
                return c;
            }
        }
        return null;
    }

    public boolean remove(int codigo){
        Cliente c = pesquisa_codigo(codigo);
        if(c!=null){
            clientes.remove(c);
            return true;
        }
        return false;
    }

    public boolean remove_endereco(int codigo, String endereco){
        Cliente c = pesquisa_codigo(codigo);
        if(c != null){
            int armazena = c.procura_endereco(endereco);
            if(armazena != (-1)){
                c.remove_endereco(armazena);
                return true;
            }
            else
                System.out.println("Endereco nao cadastrado");
        }
        else
            System.out.println("Cliente nao encontrado");
        return false;

    }

    public Cliente altera_por_codigo(int codigo, String email, String senha, String endereco_novo, String endereco_antigo){
        Cliente c = pesquisa_codigo(codigo);
        if(c!=null){
            c.set_email(email);
            c.set_senha(senha);
            int posicao = c.procura_endereco(endereco_antigo);
            c.set_endereco(posicao, endereco_novo);
            return c;
        }
        return null;
    }

    public Cliente altera_por_cpf(String cpf, String email, String senha, String endereco_novo, String endereco_antigo){
        Cliente c = pesquisa_cpf(cpf);
        if(c!=null){
            c.set_email(email);
            c.set_senha(senha);
            int posicao = c.procura_endereco(endereco_antigo);
            c.set_endereco(posicao, endereco_novo);
            return c;
        }
        return null;
    }

    public Cliente altera_senha(int codigo, String nova_senha){
        Cliente c = pesquisa_codigo(codigo);
        if(c!=null){
            c.set_senha(nova_senha);
            return c;
        }
        return null;
    }

    public ArrayList<Cliente> lista_todos(){ return clientes; }
}
