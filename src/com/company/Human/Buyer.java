package com.company.Human;

public class Buyer extends Human {
    private String InterestedCar;
    public Buyer(String name, Double cash, String InterestedCar) {
        super(name, cash);
        this.InterestedCar = InterestedCar;
    }
}
