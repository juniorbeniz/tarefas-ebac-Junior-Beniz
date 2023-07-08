package br.com.jbeniz;
import java.util.Scanner;

public class Media {

    Scanner input = new Scanner(System.in);

    private double nota;
    private double media;

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public void notas(){

        int numNota = 1;
        double somaNota = 0;
            for (int cont = 0; cont <= 3; cont++){
            System.out.println("Digite a " + numNota + "ª nota:" );
            double notaAtual = input.nextDouble();
            setNota(somaNota += notaAtual);
            numNota++;
            }
        double mediaFinal = getNota()/4;
        setMedia(mediaFinal);
    }

}
