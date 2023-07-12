package br.com.jbeniz;
import java.util.Scanner;

public class TarefaMod9 {

    public static void main (String [] args) {

        Scanner input = new Scanner(System.in);
        int numPrimitivo;
        Double numWrapper;

        System.out.println("Insira um número inteiro para a classe do tipo primitivo:");
        numPrimitivo = input.nextInt();
        numWrapper = Double.valueOf(numPrimitivo);
        System.out.println("O número inserido convertido para a Wrapper Class Double é: " + numWrapper);

    }
}
