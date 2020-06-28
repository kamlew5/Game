package com.company.Human;

import java.util.ArrayList;
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
    public void Create(){
        String helper1, helper2;
        if(ThreadLocalRandom.current().nextInt(0, 1+1)==0) {
            helper1 = HelperCreator(carMarks);
        }
        else {
            helper1 = HelperCreator(truckMarks);
        }
        if(ThreadLocalRandom.current().nextInt(0, 1+1)==0) {
            helper2 = HelperCreator(carMarks);
        }
        else {
            helper2 = HelperCreator(truckMarks);
        }
        while (helper2.equals(helper1)) {
            if(ThreadLocalRandom.current().nextInt(0, 1+1)==0) {
                helper2 = HelperCreator(carMarks);
            }
            else {
                helper2 = HelperCreator(truckMarks);
            }
        }
        buyers.add(new Buyer(HelperCreator(buyersNames), helper1, helper2));
    }
    public void DisplayBuyers(){
        for (int i = 0; i < buyers.size(); i++) {
            System.out.println(i+1+" "+buyers.get(i).toString());
        }
    }
}
