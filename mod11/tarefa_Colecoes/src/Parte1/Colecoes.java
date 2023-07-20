package Parte1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Colecoes {

    public static void main (String [] args) {

        Scanner input = new Scanner(System.in);
        List<String> lista = new ArrayList<>();

        System.out.println("Insira os nomes separados por virgula a serem adicionados a lista:");
        String nomes = input.nextLine();

        //Criação de Array de String para receber os nomes separados pelo método Split.
        String [] nomesSeparados = nomes.split(",");

        /**Criação de loop usando for e uma String para receber cada nome do Array
        e os inserir os nomes separados dentro da lista.
        **/
        for (String nome : nomesSeparados){
            lista.add(nome);
        }

        Collections.sort(lista);
        System.out.println(lista);
    }
}

//Vale notar que a ordenação prioriza as letras maiúsculas.