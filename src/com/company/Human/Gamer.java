package com.company.Human;

import com.company.Car.Car;
import java.util.ArrayList;
import java.util.Comparator;

public class Gamer extends Human {
    public ArrayList<Car> garage = new ArrayList<>();
    public Double cash = 10000.0;
    public Double costs = 0.0;
    public Gamer(String name) {
        super(name);
    }

    public void ShowCars(){
        System.out.println(this.garage);
    }

    public void SortCars(){
        garage.sort(Comparator.comparing(Car::getMark));
    }
}
