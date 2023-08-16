package br.com.jbeniz;

public class Customer {
    private String gradeRequest;
    private boolean typeSport;

    public Customer(String gradeRequest, boolean typeSport) {
        this.gradeRequest = gradeRequest;
        this.typeSport = typeSport;
    }
    public boolean typeSport (){
        return typeSport;
    }

    public String gradeRequest () {
        return gradeRequest;
    }

}
