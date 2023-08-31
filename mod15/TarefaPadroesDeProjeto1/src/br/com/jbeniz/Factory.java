package br.com.jbeniz;

public abstract class Factory {

    public Car create(String requestedGrade){
        Car car = retrieveCar(requestedGrade);
        car = prepareCar(car);
        return car;
    }

    public Car prepareCar (Car car){
        car.startEngine();
        car.clean();
        car.mechanicCheck();
        car.fuelCar();
        return car;
    }

    abstract Car retrieveCar(String requestedGrade);

}
