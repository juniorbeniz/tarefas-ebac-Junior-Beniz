import Domain.Car;
import Domain.SportCar;
import Generics.IGenericDAO;


import javax.swing.*;

public class App {

    private static IGenericDAO CarMapDAO;
    private static IGenericDAO SportCarMapDAO;
    public static void main (String [] args){


         String opcao = JOptionPane.showInputDialog(null,
                "Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Green dinner", JOptionPane.INFORMATION_MESSAGE);

         while (!isOpcaoValida(opcao)){
             if("".equals(opcao)){
                 sair();
             }
             opcao = JOptionPane.showInputDialog(null,
                     "Opção Inválida! Digite 1 para cadastro, 2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                     "Green dinner", JOptionPane.INFORMATION_MESSAGE);

         }

         while(isOpcaoValida(opcao)){
             if(isOpcaoSair(opcao)){
                 sair();
             } else if (isCadastro(opcao)){
                 String dados = JOptionPane.showInputDialog(null,
                         "Digite os dados do carro separados por vígula, conforme exemplo: ID, Montadora, " +
                                 "Modelo, wHP, Ano",
                         "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                 cadastrar(dados);
             } else if (isConsultar(opcao)) {
                 String tipo = JOptionPane.showInputDialog(null,
                         "Selecione o tipo de carro que você deseja consultar: [1 - Esportivo / 2 - Passeio]",
                         "Consulta", JOptionPane.INFORMATION_MESSAGE);
                 String iDconsulta = JOptionPane.showInputDialog(null,
                         "Digite o ID do carro desejado",
                         "Consulta", JOptionPane.INFORMATION_MESSAGE);

                 if("1".equals(tipo)){
                     consultaEsportivo(iDconsulta);
                 } else if ("2".equals(tipo)){
                     consultaPasseio(iDconsulta);
                 }
             } else if(isOpcaoExcluir(opcao)){
                 String tipo = JOptionPane.showInputDialog(null,
                         "Selecione o tipo de carro que você deseja excluir: [1 - Esportivo / 2 - Passeio]",
                         "Excluir", JOptionPane.INFORMATION_MESSAGE);
                 String iDexcluir = JOptionPane.showInputDialog(null,
                         "Digite o ID do carro a ser excluído",
                         "Excluir", JOptionPane.INFORMATION_MESSAGE);

                 if("1".equals(tipo)){
                     excluirEsportivo(iDexcluir);
                 } else if ("2".equals(tipo)){
                     excluirPasseio(iDexcluir);
                 }
             } else if(isOpcaoAlterar(opcao)) {
                 String tipo = JOptionPane.showInputDialog(null,
                         "Selecione o tipo de carro que você deseja alerar: [1 - Esportivo / 2 - Passeio]",
                         "Alterar", JOptionPane.INFORMATION_MESSAGE);
                 String dados = JOptionPane.showInputDialog(null,
                         "Digite os dados do carro separados por vígula, conforme exemplo: ID, Montadora, " +
                                 "Modelo, wHP, Ano",
                         "Alteração", JOptionPane.INFORMATION_MESSAGE);
                 if ("1".equals(tipo)) {
                     alterarEsportivo(dados);
                 } else {
                     alterarPasseio(dados);
                 }
             }
         }

    }

    private static void alterarPasseio(String dados) {
        String[] dadosCar = dados.split(",");
        SportCar car1 = new SportCar(dadosCar[0], dadosCar[1], dadosCar[2], dadosCar[3], dadosCar[4]);
        CarMapDAO.alterar(car1);
        JOptionPane.showMessageDialog(null, "Carro de passeio alterado com sucesso ", "Sucesso!",JOptionPane.INFORMATION_MESSAGE);

    }

    private static void alterarEsportivo(String dados) {
        String[] dadosCar = dados.split(",");
        SportCar sportCar1 = new SportCar(dadosCar[0], dadosCar[1], dadosCar[2], dadosCar[3], dadosCar[4]);
        SportCarMapDAO.alterar(sportCar1);
        JOptionPane.showMessageDialog(null, "Carro esportivo alterado com sucesso ", "Sucesso!",JOptionPane.INFORMATION_MESSAGE);
    }

    private static boolean isOpcaoAlterar(String opcao) {
        if("4".equals(opcao)){
            return true;
        } return false;
    }

    private static void excluirPasseio(String iDexcluir) {
        Car carExcluir = (Car) CarMapDAO.excluir(Long.parseLong(iDexcluir));
        JOptionPane.showMessageDialog(null, "Cliente Excluido", "Sucesso",JOptionPane.INFORMATION_MESSAGE);

    }

    private static void excluirEsportivo(String iDexcluir) {
        SportCar carExcluir = (SportCar) SportCarMapDAO.excluir(Long.parseLong(iDexcluir));
        JOptionPane.showMessageDialog(null, "Cliente Excluido", "Sucesso",JOptionPane.INFORMATION_MESSAGE);

    }

    private static boolean isOpcaoExcluir(String opcao) {
        if("3".equals(opcao)){
            return true;
        } return false;
    }

    private static void consultaPasseio(String iDconsulta) {
        Car passeioConsulta = (Car) CarMapDAO.consultar(Long.parseLong(iDconsulta));
        if (passeioConsulta != null) {
            JOptionPane.showMessageDialog(null, "Carro encontrado com sucesso: " + passeioConsulta.toString(), "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Carro não encontrado", "ERRO",JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consultaEsportivo(String iDconsulta) {
        SportCar sportConsulta = (SportCar) SportCarMapDAO.consultar(Long.parseLong(iDconsulta));
        if (sportConsulta != null) {
            JOptionPane.showMessageDialog(null, "Carro encontrado com sucesso: " + sportConsulta.toString(), "Sucesso",JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Carro não encontrado", "ERRO",JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private static boolean isConsultar(String opcao) {
        if("2".equals(opcao)){
            return true;
        } return false;
    }

    private static void cadastrar(String dados) {
        String [] dadosCar = dados.split(",");
        Integer hP = Integer.parseInt(dadosCar[3]);
        if(hP > 149){
            SportCar sportCar1 = new SportCar(dadosCar[0], dadosCar[1], dadosCar[2], dadosCar[3], dadosCar[4]);
            Boolean isCadastrado = SportCarMapDAO.cadastro(sportCar1);

            if(isCadastrado){
                JOptionPane.showMessageDialog(null, "Carro esportivo cadastrado com sucesso ", "Sucesso!",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível concluir o cadastrado", "Falha!!",JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            Car car1 = new Car(dadosCar[0], dadosCar[1], dadosCar[2], dadosCar[3], dadosCar[4]);
            Boolean isCadastrado = CarMapDAO.cadastro(car1);
            if(isCadastrado){
                JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso ", "Sucesso!",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível concluir o cadastrado", "Falha!!",JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }

    private static boolean isCadastro(String opcao) {
        if("1".equals(opcao)){
            return true;
        } return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if("5".equals(opcao)){
            return true;
        } return false;
    }

    private static void sair() {
        JOptionPane.showMessageDialog(null, "Até logo! Fechando...");
        System.exit(0);
    }

    private static boolean isOpcaoValida(String opcao) {
        if ("1".equals(opcao) || "2".equals(opcao) || "3".equals(opcao) || "4".equals(opcao)
                || "5".equals(opcao)) {
            return true;
        } return false;
    }
}
