package com.company.Human;

import java.util.ArrayList;
import java.util.Random;

public class BuyerCreator {
    public ArrayList<Buyer> buyers = new ArrayList<>();
    private String[] buyersNames = {"Adam", "Andrzej","Wojtek","Maciej","Karol","Alina","Zuzanna","Klaudia","Karolina",
    "Marzena","Mariusz","Marcin","Bartosz","Zygfryt","Zenek"};
    private String[] carMarks = {"Saab 9.3", "Wieśwagen Pastuch", "Fiat Punto", "Mercedes AMG GT",
            "BMW 3", "Kia Stringer", "Seat Ibiza", "Mitsubishi Galant"};
    private String HelperCreator(String[] generateValue) {
        Random r = new Random();
        int randomNumber = r.nextInt(generateValue.length);
        return(generateValue[randomNumber]);
    }
    public void Create(){
        buyers.add(new Buyer(HelperCreator(buyersNames),HelperCreator(carMarks)));
    }
    public void DisplayBuyers(){
        for (int i = 0; i < buyers.size(); i++) {
            System.out.println(i+1+" "+buyers.get(i).toString());
        }
    }
}
