import java.util.Scanner;
public class Carro extends Distancia{

    Scanner input = new Scanner(System.in);

    private String modelo;
    private String combustivel;
    private double consumo;


    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        this.consumo = consumo;
    }

    /**
     * @author Junior Beniz
     * @since Versão 1.0
     * Método criado para coletar informações do usuário no terminal.
     *
     * @see Distancia
     */
    public void dialogo(){
        System.out.println("Insira o modelo do seu carro:");
        String modelo = input.nextLine();
        setModelo(modelo);
        System.out.println("Insira o combustível do seu carro: (Alcool, Gasolina ou Diesel)");
        String comb = input.nextLine();
        setCombustivel(comb);
        System.out.println("Qual o consumo médio do seu carro?");
        Double consumo = input.nextDouble();
        setConsumo(consumo);
        System.out.println("Qual distância em Km você deseja percorrer?");
        Double distancia = input.nextDouble();
        setDistancia(distancia);

    }

    /**
     * @author Junior Beniz
     * @since Versão 1.0
     * Método criado para calcular quantos litros serão necessários
     * para a distância informada e para mostrar as informações e o
     * resultado no terminal.
     * @see Distancia
     */
    public void resultado(){
        double litros;
        litros  = (getDistancia())/(getConsumo());

        System.out.println("Para uma viagem de " + (getDistancia()) +
                "km o seu " + (getModelo()) + " precisará de " + litros
                + " litros de " + (getCombustivel()));
    }

}
