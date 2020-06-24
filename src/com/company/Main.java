package com.company;


import com.company.Car.Generator;
import com.company.Game_Interface.Base;
import com.company.Human.BuyerCreator;
import com.company.Human.Gamer;
import com.company.Human.GamerCreator;
import com.company.Human.Mechanic;
import com.company.Car.Generator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //Stworzenie mechaników
        //Mechanic janusz = new Mechanic("Janusz", 100,0,1.3);
        //Mechanic mariusz = new Mechanic("Mariusz",  90,0,1.0);
        //Mechanic adrian = new Mechanic("Adrian",  80,2,0.7);
        //Podstawowe generatory
        Generator carGenerator = new Generator();
        BuyerCreator buyerCreator = new BuyerCreator();
        //GamerCreator gamerCreator = new GamerCreator();
        Base base = new Base();
        //Podstawowe funkcje
        for (int i = 0; i < 10; i++) {
            carGenerator.Generate();
            buyerCreator.Create();
        }
        base.Welcome();
        //gamerCreator.Generate();
        Gamer gamer = new Gamer("Janusz",1000.0);
        //base.Menu(carGenerator, gamer);
        carGenerator.ChangeOwner(gamer);









    }
}
