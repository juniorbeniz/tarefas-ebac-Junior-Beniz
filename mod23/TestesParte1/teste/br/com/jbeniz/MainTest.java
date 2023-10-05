package br.com.jbeniz;

import br.com.jbeniz.Tarefa_Streams.Pessoa;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class MainTest extends TestCase {

    @Test
    public void testeListaFeminino() {
        Pessoa p1 = new Pessoa("João", "Masculino");
        Pessoa p2 = new Pessoa("Maria", "Feminino");
        Pessoa p3 = new Pessoa("Josefa", "Feminino");
        Pessoa p4 = new Pessoa("José", "Masculino");

        List<Pessoa> lista = new ArrayList<>();
        lista.add(p1);
        lista.add(p2);
        lista.add(p3);
        lista.add(p4);

        ArrayList<Pessoa> femList = (ArrayList)lista.stream()
                .filter((pessoax) -> {return pessoax.getSexo().equalsIgnoreCase("feminino");
                }).collect(Collectors.toCollection(ArrayList::new));

        Assert.assertTrue(femList.stream().allMatch(pessoa -> pessoa.getSexo().equalsIgnoreCase("feminino")));

    }
}