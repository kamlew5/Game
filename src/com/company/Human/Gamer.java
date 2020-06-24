package com.company.Human;

import com.company.Car.Car;
import java.util.ArrayList;

public class Gamer extends Human {
    public ArrayList<Car> garage = new ArrayList<>();
    private Double cash;
    public Gamer(String name, Double cash) {
        super(name);
        this.cash = cash;
    }
}
