package com.company.Human;

import com.company.Car.Car;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Gamer{
    //lista aut w garażu
    public ArrayList<Car> garage = new ArrayList<>();
    public Double cash = 10000.0;
    public Double costs = 0.0;
    public String name;

    //pokazuje co ma w garażu - z numerkami
    public void showCars(){
        for(int i = 0; i < this.garage.size(); i++){
            System.out.println(i+1+" "+this.garage.get(i).display());
        }
    }
    //2 funkcja do pokazywania garażu - bez numerków
    public void displayGarage(){
        for (Car car : this.garage) {
            System.out.println(car.display());
        }
    }
    //sortuje auta
    public void sortCars() {
        garage.sort(Comparator.comparing(Car::getMark));
    }
    //ustawia imię dla gracza
    public void getName(){
        Scanner console = new Scanner(System.in);
        System.out.print("Give me your name: ");
        this.name = console.nextLine();
    }

}
