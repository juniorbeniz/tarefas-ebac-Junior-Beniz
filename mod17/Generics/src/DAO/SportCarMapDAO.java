package DAO;

import Domain.Car;
import Domain.SportCar;
import Generics.IGenericDAO;


import java.util.*;

public class SportCarMapDAO implements IGenericDAO <SportCar> {

    private Map<Long, SportCar> sportCarMap;

    public SportCarMapDAO(){

        sportCarMap = new HashMap<>();
    }

    @Override
    public Boolean cadastro(SportCar sportCar) {
        if (sportCarMap.containsKey(sportCar.getID())){
            return false;
        }
        sportCarMap.put(sportCar.getID(), sportCar);
        return true;
    }

    @Override
    public SportCar excluir(Long ID) {
        SportCar carExcluir = sportCarMap.get(ID);
        sportCarMap.remove(carExcluir.getID(), carExcluir);

        return null;
    }

    @Override
    public void alterar(SportCar sportCar) {
        SportCar carAlterar = sportCarMap.get(sportCar.getID());
        carAlterar.setModelo(sportCar.getModelo());
        carAlterar.setwHP(sportCar.getwHP());
        carAlterar.setAno(sportCar.getAno());
        carAlterar.setMontadora(sportCar.getMontadora());
    }

    @Override
    public SportCar consultar(Long ID) {
        return this.sportCarMap.get(ID);
    }

    @Override
    public Collection<SportCar> exibirTodos() {
        return this.sportCarMap.values();
    }
}
