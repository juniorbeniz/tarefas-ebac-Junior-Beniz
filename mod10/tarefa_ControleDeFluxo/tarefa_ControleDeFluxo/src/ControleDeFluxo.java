public class ControleDeFluxo {

    public static void main (String [] args){

        Media media = new Media();
        Double mediaFluxo;

        media.notas();

        mediaFluxo = media.getMedia();
        System.out.println("Sua média é: " + mediaFluxo);

        if (mediaFluxo >= 7){
            System.out.println("Aprovado");
        } else if (mediaFluxo >= 5){
            System.out.println("Recuperação");
        } else {
            System.out.println("Reprovado");
        }
    }
}
