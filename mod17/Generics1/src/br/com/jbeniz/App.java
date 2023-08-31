package br.com.jbeniz;

import br.com.jbeniz.dao.ClienteMapDAO;
import br.com.jbeniz.dao.IClienteDAO;
import br.com.jbeniz.domain.Cliente;

import javax.swing.*;

public class App {

    private static IClienteDAO iClienteDAO;
    public static void main (String [] args){
        iClienteDAO = new ClienteMapDAO();

        String opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro, " +
                        "2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                "Cadastro", JOptionPane.INFORMATION_MESSAGE);

        while (!isOpcaoValida(opcao)) {
            if ("".equals(opcao)) {
                sair();
            }
            opcao = JOptionPane.showInputDialog(null, "Opção Inválida. Digite 1 para cadastro, " +
                            "2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }

        while (isOpcaoValida(opcao)) {
            String dados = null;
            if (isOpcaoSair(opcao)) {
                sair();
            } else if (isOpcaoCadastro(opcao)) {
                dados = JOptionPane.showInputDialog(null, "Digite os dados do novo cliente separados " +
                                "por vírgula. Caso queria deixar algum campo vazio deixe um espaço " +
                                "em branco entre as vírgulas Ex:(Nome, CPF, Telefone, Endereço, Número, Cidade, Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                cadastrar(dados);
            } else if (isConsultar(opcao)) {
                String cpfConsulta = JOptionPane.showInputDialog(null, "Digite o CPF",
                        "Consulta", JOptionPane.INFORMATION_MESSAGE);

                consultar(cpfConsulta);
            } else if (isExcluir(opcao)){
                String cpfExcluir = JOptionPane.showInputDialog(null, "Digite o CPF",
                        "Exclusão", JOptionPane.INFORMATION_MESSAGE);
                excluir(cpfExcluir);
            } else if (isAlterar(opcao)){
                String atualizar = JOptionPane.showInputDialog(null, "Digite os novos dados cliente separados" +
                                "por vírgula. Caso queria deixar algum campo vazio deixe um espaço " +
                                "em branco entre as vírgulas Ex:(Nome, CPF, Telefone, Endereço, Número, Cidade, Estado",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                alterar(atualizar);
            }

            opcao = JOptionPane.showInputDialog(null, "Digite 1 para cadastro, " +
                            "2 para consultar, 3 para exclusão, 4 para alteração ou 5 para sair",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static boolean isAlterar(String opcao){
        if("4".equals(opcao)){
            return true;
        } return false;
    }
    private static boolean isExcluir(String opcao) {
        if("3".equals(opcao)){
            return true;
        } return false;
    }


    private static boolean isConsultar(String opcao) {
        if ("2".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoCadastro(String opcao) {
        if("1".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoSair(String opcao) {
        if("5".equals(opcao)){
            return true;
        }
        return false;
    }

    private static boolean isOpcaoValida(String opcao) {
        if(("1".equals(opcao)) || ("2".equals(opcao)) ||
                ("3".equals(opcao)) || ("4".equals(opcao)) || ("5".equals(opcao))){
            return true;
        } return false;
    }

    private static void sair() {
        JOptionPane.showInputDialog(null, "Até mais!",
                "Fechar", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }

    private static <T> void cadastrar(String dados) {
        String [] dadosIndividuais = dados.split(",");
        for (String dado : dadosIndividuais){
            if(dado.isEmpty()) {
                String escolha = JOptionPane.showInputDialog(null, "Existem espaços em branco. Deseja continuar sem os dados completos? Dados ausentes serão substituídos por 0. [Opções: 1: Sim | 2: Não]",
                        "Cadastro", JOptionPane.INFORMATION_MESSAGE);
                if ("2".equals(escolha)) {
                    sair();
                    /* Poderia ter feito um if para deixar o usuário decidir se sairia do programa ou tentaria novamente
                    mas o método ficaria muito grande */

                } else if ("1".equals(escolha)) {

                    //Pesquisei uma forma de alterar o espaço em branco para 0 dentro do cadastro.
                    for (int cont = 0; cont < dadosIndividuais.length; cont++) {
                        if ((dadosIndividuais[cont].isEmpty())) {
                            dadosIndividuais[cont] = "0";
                        }
                    }
                }
            }
        }

        Cliente cliente = new Cliente(dadosIndividuais[0],dadosIndividuais[1],dadosIndividuais[2],dadosIndividuais[3],dadosIndividuais[4],dadosIndividuais[5],dadosIndividuais[6]);

        Boolean isCadastrado = iClienteDAO.cadastrar(cliente);
        if (isCadastrado) {
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente já se encontra cadastrado.",
                    "Erro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void consultar(String cpfConsulta) {

        Cliente cliente = iClienteDAO.consultar(Long.parseLong(cpfConsulta));
        if(cliente != null){
            JOptionPane.showMessageDialog(null, "Cliente encontrado: " + cliente.getNome().toString(),
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!",
                    "Cadastro", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void excluir(String cpfExcluir){
        Cliente cliente = iClienteDAO.consultar(Long.parseLong(cpfExcluir));
        if(cliente != null){
            iClienteDAO.excluir(Long.valueOf(cpfExcluir));
            JOptionPane.showMessageDialog(null, "Cliente excluído!",
                    "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!",
                    "Exclusão", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private static void alterar( String atualizar){
        String [] dadosSeparados = atualizar.split(",");
        Cliente cliente = new Cliente(dadosSeparados[0],dadosSeparados[1],dadosSeparados[2],dadosSeparados[3],dadosSeparados[4],dadosSeparados[5],dadosSeparados[6]);
        iClienteDAO.alterar(cliente);
    }
}
