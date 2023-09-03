package DAO;

import Domain.SportCar;
import Generics.IGenericDAO;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
    public void excluir(Long ID) {
        SportCar carExcluir = sportCarMap.get(ID);
        sportCarMap.remove(carExcluir.getID(), carExcluir);
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
