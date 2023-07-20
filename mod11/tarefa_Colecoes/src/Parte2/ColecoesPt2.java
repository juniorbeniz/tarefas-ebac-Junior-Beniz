package Parte2;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ColecoesPt2 {

    public static void main (String [] args) {

        Scanner input = new Scanner(System.in);
        List<String> masc = new ArrayList<>();
        List<String> fem = new ArrayList<>();

        System.out.println("Insira os nomes com sexo separados por virgula a serem adicionados a lista: [Modelo: 'Junior-M']");
        String nomes = input.nextLine();

        //Criação de Array de String para receber os nomes separados pelo método Split.
        String [] nomesSeparados = nomes.split(",");

        /**
         * Criação de loop para dividir a informação 'nome' e 'sexo' em outro array e
         * condicional para observar o index correspondente ao sexo adicionando o nome na Lista desejada.
         */
        for (String pessoas : nomesSeparados){
            String[] pessoa = pessoas.split("-");
            String nome = pessoa[0];
            String sexo = pessoa[1];

            if ("m".equalsIgnoreCase(sexo)){
                masc.add(nome);
            } else if("f".equalsIgnoreCase(sexo)){
                fem.add(nome);
            }
        }

        Collections.sort(masc);
        Collections.sort(fem);

        System.out.println("**** LISTA FEMININA ****");
        System.out.println(fem);
        System.out.println("");
        System.out.println("**** LISTA MASCULINA ****");
        System.out.println(masc);


    }
}

