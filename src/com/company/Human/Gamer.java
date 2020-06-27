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
    //dziedziczenie z klasy human
    public Gamer(String name) {
        this.name = name;
    }

    //stara funkcja do wypisywania aut
    public void ShowCars(){
        System.out.println(this.garage);
    }
    //sortuje auta
    public void SortCars(){
        garage.sort(Comparator.comparing(Car::getMark));
    }
    //poprawiona funkcja do wypisywania aut
    public void ShowCars2(){
        for (Car car : garage) {
            System.out.println(car.getText());
        }
    }
    public void DisplayGarage(){
        for (Car car : this.garage) {
            System.out.println(car.Display());
        }
    }
}
