package com.company.Human;

public class Buyer{
    public String name;
    private String InterestedCar;


    public Buyer(String name, String InterestedCar) {
            this.name = name;
            this.InterestedCar = InterestedCar;
    }

    @Override
    public String toString() {
        return name + " chce " + InterestedCar;
    }
}
