package br.com.jbeniz;

import java.util.*;

public class ColecoesParte2 {

    public static void main (String [] args){

        List<String> masc = new ArrayList<>();
        List<String> fem = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        String resposta;

        do {
            System.out.println("Digite o nome de uma pessoa:");
            String pessoa = input.next();
            System.out.println("Digite o sexo dessa pessoa: (Masculino/Feminino)");
            String sexo = input.next();

            if (sexo.equalsIgnoreCase("masculino")){
                masc.add(pessoa);
            } else if (sexo.equalsIgnoreCase("feminino")) {
                fem.add(pessoa);
            }

            System.out.println("Deseja inserir outra pessoa na lista?  (S/N)");
            resposta = input.next();

        } while (resposta.equalsIgnoreCase("s"));

        Collections.sort(masc);
        Collections.sort(fem);

        System.out.println("***** Lista de Nomes Masculinos *****");
        for(String impListaMasc : masc){
            System.out.println(impListaMasc);
        }

        System.out.println("***** Lista de Nomes Femininos *****");
        for(String impListaFem : fem){
            System.out.println(impListaFem);
        }


    }
}
