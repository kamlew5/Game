package com.company;

import com.company.Car.CarGenerator;
import com.company.Car.RepairGenerator;
import com.company.Game_Interface.Base;
import com.company.Game_Interface.TransactionGenerator;
import com.company.Human.BuyerCreator;
import com.company.Human.Gamer;
import com.company.Human.Mechanic;

public class Main {

    public static void main(String[] args) {
        //Stworzenie mechaników
        Mechanic janusz = new Mechanic("Janusz", 100,0,1.3);
        Mechanic mariusz = new Mechanic("Mariusz",  90,0,1.0);
        Mechanic adrian = new Mechanic("Adrian",  80,2,0.7);
        //Podstawowe generatory
        CarGenerator carGenerator = new CarGenerator();
        BuyerCreator buyerCreator = new BuyerCreator();
        TransactionGenerator transactionGenerator = new TransactionGenerator();
        RepairGenerator repairGenerator = new RepairGenerator();
        //GamerCreator gamerCreator = new GamerCreator();
        Base base = new Base();
        //Stworzenie 10 samochodó i 10 klientów
        for (int i = 0; i < 10; i++) {
            carGenerator.generate();
            buyerCreator.create();
        }
        //Sortowanie aut
        carGenerator.sortCars();
        //Uruchomienie przywitania
        base.Welcome();
        Gamer gamer = new Gamer();
        gamer.getName();
        //Uruchomienie menu
        while (gamer.cash<20000.0||gamer.cash<=100)
            base.Menu(carGenerator, gamer, buyerCreator, janusz, mariusz, adrian, transactionGenerator, repairGenerator);
        if(gamer.cash<20000.0)
            base.returnTurn(gamer.cash);
        else
            if(gamer.cash<=100)
                System.out.println("Przegrałeś...");
        //Do zrobienia:
        //Sprzedaż
    }
}
