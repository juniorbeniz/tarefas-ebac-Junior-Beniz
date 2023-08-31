package br.com.jbeniz.dao;

import br.com.jbeniz.dao.Generic.IGenericDAO;
import br.com.jbeniz.domain.Cliente;

import java.util.Collection;

public interface IClienteDAO extends IGenericDAO<Cliente> {

    public Boolean cadastrar(Cliente cliente);
    public void excluir(Long cpf);
    public void alterar(Cliente cliente);
    public Cliente consultar(Long cpf);
    public Collection<Cliente> buscarTodos();
}
