package br.com.jbeniz.projetocadastroclienteswing.DAO;


import br.com.jbeniz.projetocadastroclienteswing.domain.Cliente;
import java.util.*;
import java.util.Iterator;


public class ClienteSetDAO implements IClienteDAO {
    
    
    private Set<Cliente> set;

    public ClienteSetDAO () { this.set = new HashSet<>(); }

    @Override
    public Boolean cadastrar(Cliente cliente) {
        if (this.set.contains(cliente)){
            return false;
        }
        this.set.add(cliente);
        return true;
    }

    @Override
    public Cliente excluir(Long cpfExlcuir) {
        Iterator<Cliente> iterator = set.iterator();
        while (iterator.hasNext()) {
            Cliente clienteCadastrado = iterator.next();
            if (clienteCadastrado.getCpf().equals(cpfExlcuir)) {
                this.set.remove(clienteCadastrado);
                return clienteCadastrado;
            }
        }
        return null;
    }

    @Override
    public void alterar(Cliente cliente) {
        for (Cliente clienteCadastrado : set) {
            if (clienteCadastrado.getCpf().equals(cliente.getCpf())) {
                clienteCadastrado.setNome(cliente.getNome());
                clienteCadastrado.setTel(cliente.getTel());
                clienteCadastrado.setNumero(cliente.getNumero());
                clienteCadastrado.setEnd(cliente.getEnd());
                clienteCadastrado.setCidade(cliente.getCidade());
                clienteCadastrado.setEstado(cliente.getEstado());
                break;
            }
        }
    }



    @Override
    public Cliente consultar(Long cpf) {
        Iterator<Cliente> iterator = set.iterator();
        while (iterator.hasNext()) {
            Cliente clienteCadastrado = iterator.next();
            if (clienteCadastrado.getCpf().equals(cpf)) {
                this.set.contains(clienteCadastrado);
                return clienteCadastrado;
            }
        }
        return null;
    }

    @Override
    public Collection<Cliente> buscarTodos() {

        return null;
    }



    
}
