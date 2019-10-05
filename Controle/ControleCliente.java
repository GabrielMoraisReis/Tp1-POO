package Controle;

import Entidade.Cliente;
import Persistencia.DaoCliente;

public class ControleCliente {
    private DaoCliente daoCliente;

    public ControleCliente(){ daoCliente = new DaoCliente(); }

    public Cliente pesquisa_por_codigo(int codigo){ return daoCliente.pesquisa_codigo(codigo); }
    public Cliente pesquisa_por_CPF(String cpf){return daoCliente.pesquisa_cpf(cpf); }

    public Cliente insere(int codigo, String cpf, String nome, String email, String senha, String endereco){
        Cliente c = daoCliente.pesquisa_codigo(codigo);
        Cliente c2 = daoCliente.pesquisa_cpf(cpf);
        Cliente c3 = daoCliente.pesquisa_email(email);
        if(c==null && c2 == null && c3 == null){
            return daoCliente.insere(codigo, cpf, nome, email, senha, endereco);
        }
        if(c != null)
            System.out.println("Codigo de cliente ja cadastrado");
        if(c2!=null)
            System.out.println("CPF ja cadastrado");
        if(c3!=null)
            System.out.println("Email ja cadastrado");
        return null;
    }

    public String insere_endereco(int codigo, String endereco, String senha){
        if(daoCliente.verifica_senha_codigo(codigo, senha))
            return daoCliente.insere_endereco(codigo, endereco);
        return null;
    }

    public boolean remove(int codigo){ return daoCliente.remove(codigo); }

    public boolean remove_endereco(int codigo, String endereco, String senha){
        if(daoCliente.verifica_senha_codigo(codigo, senha))
            return daoCliente.remove_endereco(codigo, endereco);
        return false;
    }

    public Cliente altera_por_codigo(int codigo, String email, String senha_nova, String endereco_novo,
                                     String endereco_antigo, String senha_inserida){
        if(daoCliente.verifica_senha_codigo(codigo, senha_inserida))
            return daoCliente.altera_por_codigo(codigo, email, senha_nova, endereco_novo, endereco_antigo);
        return null;
    }

    public Cliente altera_por_CPF(String cpf, String email, String senha_nova, String endereco_novo,
                                  String endereco_antigo, String senha_inserida){
        if(daoCliente.verifica_senha_cpf(cpf, senha_inserida))
            return daoCliente.altera_por_cpf(cpf, email, senha_nova, endereco_novo, endereco_antigo);
        return null;
    }

    public Cliente altera_senha(int codigo, String senha_nova, String senha_antiga){
        if(daoCliente.verifica_senha_codigo(codigo, senha_antiga))
            return daoCliente.altera_senha(codigo, senha_nova);
    return null;
    }
}
