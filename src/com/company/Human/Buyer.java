package com.company.Human;

public class Buyer extends Human {
    private String InterestedCar;
    public Buyer(String name, String InterestedCar) {
        super(name);
        this.InterestedCar = InterestedCar;
    }
}
