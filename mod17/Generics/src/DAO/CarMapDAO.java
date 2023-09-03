package DAO;

import Domain.Car;
import Generics.IGenericDAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CarMapDAO implements IGenericDAO<Car> {

    Map<Long, Car> carMap;

    public CarMapDAO(){

        carMap = new HashMap<>();
    }

    @Override
    public Boolean cadastro(Car car) {
        if (carMap.containsKey(car.getID())){
            return false;
        }
        carMap.put(car.getID(), car);
        return true;
    }

    @Override
    public void excluir(Long ID) {
        Car carExcluir = carMap.get(ID);
        carMap.remove(carExcluir.getID(), carExcluir);
    }

    @Override
    public void alterar(Car car) {
        Car carAlterar = carMap.get(car.getID());
        carAlterar.setModelo(car.getModelo());
        carAlterar.setwHP(car.getwHP());
        carAlterar.setAno(car.getAno());
        carAlterar.setMontadora(car.getMontadora());

    }

    @Override
    public Car consultar(Long ID) {

        return this.carMap.get(ID);
    }

    @Override
    public Collection<Car> exibirTodos() {

        return this.carMap.values();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarMapDAO carMapDAO = (CarMapDAO) o;
        return Objects.equals(carMap, carMapDAO.carMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carMap);
    }
}
