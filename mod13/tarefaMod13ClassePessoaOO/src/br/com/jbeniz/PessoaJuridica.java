package br.com.jbeniz;

public class PessoaJuridica extends Pessoa {

    private Long cnpj;

    private String dataAbertura;

    public PessoaJuridica(String nome, Long cnpj, String dataAbertura) {
        super(nome);
        this.cnpj = cnpj;
        this.dataAbertura = dataAbertura;
    }


    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(String dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

}
