package Domain;

import Generics.Persistence;

import java.util.Objects;

public class SportCar implements Persistence {

    private Long ID;
    private String montadora;
    private String modelo;
    private Long wHP;
    private Integer ano;

    public SportCar(String ID, String montadora, String modelo, String wHP, String ano){
        this.ID = Long.valueOf(ID);
        this.montadora = montadora;
        this.modelo = modelo;
        this.wHP = Long.valueOf(wHP);
        this.ano = Integer.parseInt(ano);
    }

    public String getMontadora() {
        return montadora;
    }

    public void setMontadora(String montadora) {
        this.montadora = montadora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getwHP() {
        return wHP;
    }

    public void setwHP(Long wHP) {
        this.wHP = wHP;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SportCar car = (SportCar) o;
        return Objects.equals(ID, car.ID) && Objects.equals(montadora, car.montadora) && Objects.equals(modelo, car.modelo) && Objects.equals(wHP, car.wHP) && Objects.equals(ano, car.ano);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, montadora, modelo, wHP, ano);
    }

    @Override
    public String toString() {
        return "Car{" + "ID = " + ID + ", Montadora =" + montadora + ", Modelo = " + modelo +", wHP = " + wHP + ", Ano = " + ano ;
    }
}
