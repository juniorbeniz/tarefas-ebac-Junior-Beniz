package br.com.jbeniz.dao.Generic;

import br.com.jbeniz.domain.Cliente;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public abstract class GenericDAO <T extends Persistente> implements IGenericDAO <T>{

    private  Map<Class, Map<Long, T>> map;

    public GenericDAO() {

        this.map = new HashMap<>();
    }

    @Override
    public Boolean cadastrar(T entity) {
        return null;
    }

    @Override
    public void excluir(Long valor) {

    }

    @Override
    public void alterar(T entity) {

    }

    @Override
    public T consultar(Long valor) {
        return null;
    }

    @Override
    public Collection<T> buscarTodos() {
        return null;
    }
}
