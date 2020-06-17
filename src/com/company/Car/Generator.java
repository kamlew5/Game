package com.company.Car;
import java.util.Random;

public class Generator {

    public void CarGenerator() {
        String[] carMarks = {"Saab", "Wieśwagen", "Fiat", "Mercedes", "BMW", "Kia", "Seat", "Mitsubishi"};
        Random r = new Random();
        int randomNumber = r.nextInt(carMarks.length);
        System.out.println(carMarks[randomNumber]);
    }
}
