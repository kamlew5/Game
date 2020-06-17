package com.company;


import com.company.Car.Generator;
import com.company.Human.BuyerCreator;
import com.company.Human.Gamer;
import com.company.Human.GamerCreator;
import com.company.Human.Mechanic;
import com.company.Car.Generator;

public class Main {

    public static void main(String[] args) {
        Mechanic janusz = new Mechanic("Janusz", 100,0,1.3);
        Mechanic mariusz = new Mechanic("Mariusz",  90,0,1.0);
        Mechanic adrian = new Mechanic("Adrian",  80,2,0.7);
        Generator carGenerator = new Generator();
        BuyerCreator buyerCreator = new BuyerCreator();
        GamerCreator gamerCreator = new GamerCreator();
        for (int i = 0; i < 10; i++) {
            carGenerator.Generate();
            buyerCreator.Create();
        }
        gamerCreator.Generate();


    }
}
