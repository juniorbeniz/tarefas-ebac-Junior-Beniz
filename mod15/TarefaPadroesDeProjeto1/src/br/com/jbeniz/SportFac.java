package br.com.jbeniz;

public class SportFac extends Factory{

    public SportFac(Customer customer) {
    }

    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new CarFocusRS("Focus RS",500,"Petrobrás Podium", "Metalic Blue");
        } else if ("B".equals(requestedGrade)){
            return new CarCivicTypeR("Civic Type R",400, "Petrobrás Podium", "Silver");
        }
        return null;
    }
}
