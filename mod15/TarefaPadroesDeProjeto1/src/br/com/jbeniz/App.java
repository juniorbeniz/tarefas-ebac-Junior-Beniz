package br.com.jbeniz;

public class App {
    public static void main(String[] args) {


        Customer customerOne = new Customer("A", true);
        Factory factory = getCarFactory(customerOne);
        factory.create(customerOne.gradeRequest());


    }

    private static Factory getCarFactory(Customer customer) {
        if(customer.typeSport()){
            return new SportFac(customer);
        } else {
            return new ConfortFac(customer);
        }
    }
}