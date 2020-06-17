package com.company.Human;

import com.company.Car.Car;

import java.util.ArrayList;

public class Gamer extends Human {
    private ArrayList<Car> garage;
    public Gamer(String name, Double cash, ArrayList<Car> garage) {
        super(name, cash);
        this.garage = garage;
    }
}
