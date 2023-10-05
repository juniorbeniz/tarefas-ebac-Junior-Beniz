package br.com.jbeniz.Tarefa_Streams;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Pessoa> lista = new ArrayList();

        int opcao;
        do {
            System.out.println("Digite um nome e o sexo da pessoa para cadastro: (Ex.: nome,sexo)");
            String pessoa = input.nextLine();
            String[] dadosPessoa = pessoa.trim().split(",");
            if (dadosPessoa.length == 2) {
                String nome = dadosPessoa[0].trim();
                String sexo = dadosPessoa[1].trim();
                Pessoa pessoa1 = new Pessoa(dadosPessoa[0], dadosPessoa[1]);
                lista.add(pessoa1);
                System.out.println("Cadastro feito com sucesso.");
            } else {
                System.out.println("Formato incorreto. Use do formato: nome,sexo");
            }

            System.out.println("Deseja adicionar outra pessoa no cadastro? 1 - Sim / 2 - Não ");
            opcao = input.nextInt();
            input.nextLine();
        } while(opcao == 1);

        ArrayList<Pessoa> femList = (ArrayList)lista.stream()
                .filter((pessoax) -> {return pessoax.getSexo().equalsIgnoreCase("feminino");
        }).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(femList);
    }

}
