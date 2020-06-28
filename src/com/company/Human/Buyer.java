package com.company.Human;

import java.util.ArrayList;

public class Buyer{
    public String name;
    public Integer ifTruck;
    public String interestedCar1;
    public String interestedCar2;


    public Buyer(String name, String interestedCar1, String interestedCar2) {
            this.name = name;
            this.interestedCar1 = interestedCar1;
            this.interestedCar2 = interestedCar2;
    }

    @Override
    public String toString() {
        return name + " chce " + interestedCar1 + " lub " + interestedCar2;
    }
}
