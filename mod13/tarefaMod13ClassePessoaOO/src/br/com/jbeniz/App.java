package br.com.jbeniz;

public class App {
    public static void main(String[] args) {


        PessoaFisica pf1 = new PessoaFisica("Junior");
        pf1.setCpf(12345678901l);
        pf1.setDataNascimento("05/04/1994");
        imprimirPf(pf1);

        System.out.println();

        PessoaFisica pf2 = new PessoaFisica("Carol");
        pf2.setCpf(10987654321l);
        pf2.setDataNascimento("06/09/1996");
        imprimirPf(pf2);

        System.out.println();

        PessoaJuridica pj1 = new PessoaJuridica("Aranha LTDA", 12345678901234l, "24/07/2023");
        imprimirPj(pj1);

        System.out.println();

        PessoaJuridica pj2 = new PessoaJuridica("Beniz LTDA", 43210987654321l, "23/07/2023");
        imprimirPj(pj2);
    }

    public static void imprimirPf(PessoaFisica pessoa){
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("CPF: " + pessoa.getCpf());
        System.out.println("Data de Nascimento: " + pessoa.getDataNascimento());
    }


    public static void imprimirPj(PessoaJuridica pessoa){
        System.out.println("Nome: " + pessoa.getNome());
        System.out.println("CNPJ: " + pessoa.getCnpj());
        System.out.println("Data de Abertura: " + pessoa.getDataAbertura());
    }
}