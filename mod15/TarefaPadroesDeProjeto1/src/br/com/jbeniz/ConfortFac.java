package br.com.jbeniz;

public class ConfortFac extends Factory {
    public ConfortFac(Customer customer) {

    }

    @Override
    Car retrieveCar(String requestedGrade) {
        if ("A".equals(requestedGrade)) {
            return new CarFusion("Fusion Ecoboost",240, "Petrobrás Grid", "Azul");
            } else if ("B".equals(requestedGrade)){
            return new CarFocus("Focus Titanium",170, "Gasoline", "White");
        }
        return null;
    }
}
