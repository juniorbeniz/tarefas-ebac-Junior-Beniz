package br.com.jbeniz.dao.Generic;

import br.com.jbeniz.domain.Cliente;

import java.util.Collection;

public interface IGenericDAO <T extends Persistente> {

    public Boolean cadastrar(T entity);
    public void excluir(Long valor);
    public void alterar(T entity);
    public T consultar (Long valor);
    public Collection<T> buscarTodos();

}
