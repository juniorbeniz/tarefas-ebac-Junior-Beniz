package br.com.jbeniz.dao;

import br.com.jbeniz.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO {

    public Boolean cadastrar(Cliente cliente);
    public Cliente excluir(Long cpf);
    public void alterar(Cliente cliente);
    public Cliente consultar (Long cpf);
    public Collection<Cliente> buscarTodos();
}
