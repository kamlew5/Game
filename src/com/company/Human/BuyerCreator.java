package com.company.Human;

import com.company.Car.Car;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class BuyerCreator {
    public ArrayList<Buyer> buyers = new ArrayList<>();
    private String[] buyersNames = {"Adam", "Andrzej","Wojtek","Maciej","Karol","Alina","Zuzanna","Klaudia","Karolina",
    "Marzena","Mariusz","Marcin","Bartosz","Zygfryt","Zenek"};
    private String[] carMarks = {"Saab 9.3", "Wieśwagen Pastuch", "Fiat Punto", "Mercedes AMG GT",
            "BMW 3", "Kia Stringer", "Seat Ibiza", "Mitsubishi Galant"};
    private String[] truckMarks = {"Mercedes Sprinter", "Renault Trafic", "Fiat Ducato", "Iveco Daily", "Opel Vivaro",
            "Wieśwagen T5", "Ford Transit", "Citroen Berlingo"};
    private String HelperCreator(String[] generateValue) {
        Random r = new Random();
        int randomNumber = r.nextInt(generateValue.length);
        return(generateValue[randomNumber]);
    }
    //tworzy kupca uzależnionego od tego czy chce dostawczaka i nie pozwala na dwie identyczne marki
    public void create(){
        String helper1, helper2;
        if(ThreadLocalRandom.current().nextInt(0, 9)<7) {
            helper1 = HelperCreator(carMarks);
        }
        else {
            helper1 = HelperCreator(truckMarks);
        }
        if(ThreadLocalRandom.current().nextInt(0, 9)<7) {
            helper2 = HelperCreator(carMarks);
        }
        else {
            helper2 = HelperCreator(truckMarks);
        }
        while (helper2.equals(helper1)) {
            if(ThreadLocalRandom.current().nextInt(0, 9)<7) {
                helper2 = HelperCreator(carMarks);
            }
            else {
                helper2 = HelperCreator(truckMarks);
            }
        }
        double cash = ThreadLocalRandom.current().nextInt(15000, 25000);
        buyers.add(new Buyer(HelperCreator(buyersNames), helper1, helper2, cash));
    }
    //Wyświetla kupców
    public void displayBuyers(){
        for (int i = 0; i < buyers.size(); i++) {
            System.out.println(i+1+" "+buyers.get(i).toString());
        }
    }
    //Po sprzedaży sortuje kupców
    public void sortBuyers() {
        buyers.sort(Comparator.comparing(Buyer::getName));
    }
}
