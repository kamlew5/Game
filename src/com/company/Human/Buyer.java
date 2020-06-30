package com.company.Human;

public class Buyer{
    public String name;
    public String interestedCar1;
    public String interestedCar2;
    public Double cash;


    public Buyer(String name, String interestedCar1, String interestedCar2, Double cash) {
            this.name = name;
            this.interestedCar1 = interestedCar1;
            this.interestedCar2 = interestedCar2;
            this.cash = cash;
    }
    //zwraca imię kupca
    public String getName() {
        return name;
    }

    //wyświetla co chce kupiec
    @Override
    public String toString() {
        return name + " chce " + interestedCar1 + " lub " + interestedCar2 + " ma ze sobą: " + cash + " PLN";
    }
}
