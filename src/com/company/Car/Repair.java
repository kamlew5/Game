package com.company.Car;

import com.company.Human.Gamer;
import com.company.Human.Mechanic;

public class Repair {
    public Car car;
    public Gamer gamer;
    public Integer whatRepair;
    public Double price;
    public Mechanic mechanic;

    public Repair(Car car, Gamer gamer, Integer whatRepair, Double price, Mechanic mechanic) {
        this.car = car;
        this.gamer = gamer;
        this.whatRepair = whatRepair;
        this.price = price;
        this.mechanic = mechanic;
    }
     public String getPart(int v){
        switch(v){
            case 1:
                return "Silnik ";
            case 2:
                return "Hamulce ";
            case 3:
                return "Skrzynie Biegów ";
            case 4:
                return "Karoserie ";
            case 5:
                return "Zawieszenie ";
            default:
                return "Nie ma takiej opcji ";
        }
     }

    @Override
    public String toString() {
        return car.toString() +" naprawiono: "+getPart(whatRepair)+" za: "+price+" u: "+mechanic.getName();
    }
}
