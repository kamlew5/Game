package com.company.Human;

import com.company.Car.Car;
import java.util.ArrayList;
import java.util.Comparator;

public class Gamer{
    //lista aut w garażu
    public ArrayList<Car> garage = new ArrayList<>();
    public Double cash = 10000.0;
    public Double costs = 0.0;
    public String name;
    public Gamer(String name) {
        this.name = name;
    }

    public void ShowCars(){
        for(int i = 0; i < this.garage.size(); i++){
            System.out.println(i+1+" "+this.garage.get(i).Display());
        }
    }
    //sortuje auta
    public void SortCars() {
        garage.sort(Comparator.comparing(Car::getMark));
    }
    public void DisplayGarage(){
        for (Car car : this.garage) {
            System.out.println(car.Display());
        }
    }
}
