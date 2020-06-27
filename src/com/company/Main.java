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
        Mechanic janusz = new Mechanic("Janusz", 100,0,1.3);
        Mechanic mariusz = new Mechanic("Mariusz",  90,0,1.0);
        Mechanic adrian = new Mechanic("Adrian",  80,2,0.7);
        //Podstawowe generatory
        Generator carGenerator = new Generator();
        BuyerCreator buyerCreator = new BuyerCreator();
        //GamerCreator gamerCreator = new GamerCreator();
        Base base = new Base();
        //Stworzenie 10 samochodó i 10 klientów
        for (int i = 0; i < 10; i++) {
            carGenerator.Generate();
            buyerCreator.Create();
        }
        //Sortowanie aut
        carGenerator.SortCars();
        //Uruchomienie przywitania
        base.Welcome();
        //gamerCreator.Generate();
        //Tymczasowe ręczne stworzenie gracza, męczy ciągłe wpisywanie
        Gamer gamer = new Gamer("Janusz");
        //Uruchomienie menu
        while (gamer.cash<20000.0)
            base.Menu(carGenerator, gamer, buyerCreator);

    }
}
