package Generics;

import Domain.Car;

import java.util.Collection;

public interface IGenericDAO<C extends Persistence > {


    public Boolean cadastro(C entity);
    public C excluir(Long ID);
    public void alterar (C entity);
    public C consultar(Long ID);
    public Collection<C> exibirTodos();

}
