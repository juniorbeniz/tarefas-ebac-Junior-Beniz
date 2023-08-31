package br.com.jbeniz;

public abstract class Car {

     private String nome;
     private int horsePower;
     private String fuelSource;
     private String color;

     public Car (String nome, int horsePower, String fuelSource, String color){
         this.horsePower = horsePower;
         this.fuelSource = fuelSource;
         this.color = color;
         this.nome = nome;
     }

     public void startEngine () {
         System.out.println("The engine of your "+nome+" has been started, and is ready to rock'n'roll!");
     }
     public void clean(){
         System.out.println(("Car has been cleaned, and the "+color.toLowerCase()+" is shining!"));
     }

     public void mechanicCheck(){
         System.out.println("All mechanics checked. Your "+ horsePower+" horses are ready to run!");
     }

     public void fuelCar(){
         System.out.println("Your car is fully fuelled with " + fuelSource);
     }


}
