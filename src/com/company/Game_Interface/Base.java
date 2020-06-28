package com.company.Game_Interface;

import com.company.Car.Car;
import com.company.Car.Generator;
import com.company.Car.RepairGenerator;
import com.company.Human.BuyerCreator;
import com.company.Human.Gamer;
import com.company.Human.GamerCreator;
import com.company.Human.Mechanic;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Base {
    public void Menu(Generator carGenerator, Gamer gamer, BuyerCreator buyerCreator, Mechanic janusz,
                     Mechanic mariusz, Mechanic adrain, TransactionGenerator transactionGenerator,
                     RepairGenerator repairGenerator){
        System.out.println("Menu: \n" +
                "1. Auta do Kupienia \n" +
                "2. Zobacz Swoje Auta i umyj je\n" +
                "3. Napraw Samochód\n" +
                "4. Sprawdź Klientów\n" +
                "5. Sprzedaj Samochód\n" +
                "6. Kup Reklamę\n" +
                "7. Stan Konta\n" +
                "8. Historia Transakcji\n" +
                "9. Historia Napraw Samochodów\n" +
                "10. Suma Napraw i Mycia Aut\n" +
                "Wybierz opcję od 1 do 10: ");
        ChoiceMenu(carGenerator, gamer, buyerCreator, janusz, mariusz, adrain, transactionGenerator, repairGenerator);
    }
    public void Welcome(){
        System.out.println("Witam w Symulatorze Handlarza Aut");
    }
    public void ChoiceMenu(Generator carGenerator, Gamer gamer, BuyerCreator buyerCreator, Mechanic janusz, Mechanic mariusz,
                           Mechanic adrian, TransactionGenerator transactionGenerator, RepairGenerator repairGenerator){
        switch (Listen()){
            case 1:
                carGenerator.DisplayCars();
                System.out.println("Wybierz numer od 1 do 10, by kupić auto, pozostałem by wyjść do menu");
                int helper = Listen();
                if(helper<10)
                    {
                    carGenerator.ChangeOwner(gamer, helper, transactionGenerator);
                    carGenerator.Generate();
                    carGenerator.SortCars();
                    gamer.SortCars();
                    System.out.println("Naciśnij przycisk, by kontynuować");
                    wait4key();
                }
                break;
            case 2:
                if(gamer.garage.size()<=0)
                    System.out.println("Nie masz nic w garażu");
                else
                    gamer.ShowCars();
                System.out.println("Wybierz samochód od 1 do "
                        +(gamer.garage.size())+
                        ", aby je umyć lub wybierz poza skalą, by wyjść");
                int ba = Listen() - 1;
                if(ba < gamer.garage.size()){
                    gamer.garage.get(ba).WashCar(gamer);
                }
                break;
            case 3:
                if(gamer.garage.size()<=0)
                    System.out.println("Kup se samochód");
                else{
                    gamer.DisplayGarage();
                    System.out.println("Wybierz samochód: ");
                    int lcas3 = Listen();
                    lcas3--;
                    if(lcas3>gamer.garage.size()){
                        System.out.println("Nie ma takiego samochodu");
                        wait4key();
                    }
                    else{
//                        gamer.garage.get(lcas3).diplayBrokes();
                        System.out.println("Wybierz co naprawić: \n" +
                                "1. Silnik \n" +
                                "2. Hamulce \n" +
                                "3. Skrzynie Biegów \n" +
                                "4. Karoseria \n" +
                                "5. Zawieszenie ");
                        Integer choiceRepair = Listen();
                        System.out.println("Wybierz mechanika: \n" +
                                "1. Janusz - \"ŁO PANIE! Kto Panu tak Spierd***ł!?\" cena: "+choiceHelper(choiceRepair, gamer.garage.get(lcas3))*janusz.price+"\n" +
                                "2. Mariusz - \"Andrzeju nie denerwuj się...\" cena: "+choiceHelper(choiceRepair, gamer.garage.get(lcas3))*mariusz.price+"\n" +
                                "3. Adrian - \"To się wyklepie\" cena: "+choiceHelper(choiceRepair, gamer.garage.get(lcas3))*adrian.price);
                        switch (Listen()){
                            case 1:
                                System.out.println("Wybrano Janusza");
                                janusz.Repair(gamer.garage.get(lcas3),choiceRepair, gamer, repairGenerator);
                                wait4key();
                                break;
                            case 2:
                                System.out.println("Wybrano Mariusza");
                                mariusz.Repair(gamer.garage.get(lcas3),choiceRepair, gamer, repairGenerator);
                                wait4key();
                                break;
                            case 3:
                                System.out.println("Wybrano Adriana");
                                adrian.Repair(gamer.garage.get(lcas3),choiceRepair, gamer, repairGenerator);
                                wait4key();
                                break;
                            default:
                                System.out.println("Nie ma takiej opcji");
                        }
                    }
                }
                break;
            case 4:
                    buyerCreator.DisplayBuyers();
                    wait4key();
                break;
            case 5:
                gamer.DisplayGarage();
                int a = Listen();
                a--;
                buyerCreator.DisplayBuyers();
                System.out.println("Wybierz kupca:");
                int helperBuyers = Listen();
                if(buyerCreator.buyers.get(helperBuyers).interestedCar1.equals(gamer.garage.get(a).getMark())||
                buyerCreator.buyers.get(helperBuyers).interestedCar2.equals(gamer.garage.get(a).getMark())){
                    if(gamer.garage.get(a).brokeCarSuspension == 0 &&
                            gamer.garage.get(a).brokeCarBody == 0 &&
                            gamer.garage.get(a).brokeGearBox == 0 &&
                            gamer.garage.get(a).brokeEngine == 0 &&
                            gamer.garage.get(a).brokeBrakes == 0){
                        gamer.cash += gamer.garage.get(a).price * 0.98;
                        System.out.println("Sprzedałeś: "+gamer.garage.get(a).getMark()+" za: "+gamer.garage.get(a).price*0.98);
                        gamer.garage.remove(a);
                        gamer.SortCars();
                        transactionGenerator.Generate(gamer.garage.get(a).getMark(),gamer, gamer.garage.get(a).price,1);
                }
                    else{
                        if(ThreadLocalRandom.current().nextInt(0,100 )>95){
                            System.out.println("Udało się go sprzedać nie naprawionym");
                            gamer.cash += gamer.garage.get(a).price * 0.98;
                            System.out.println("Sprzedałeś: "+gamer.garage.get(a).getMark()+" za: "+gamer.garage.get(a).price*0.98);
                            gamer.garage.remove(a);
                            gamer.SortCars();
                            transactionGenerator.Generate(gamer.garage.get(a).getMark(),gamer, gamer.garage.get(a).price,1);
                        }
                        else
                            System.out.println("Musisz go najpierw uszykować, by go sprzedać!");
                    }
                }
                else{
                    System.out.println("On tego nie chce...");
                }
                break;
            case 6:
                buyAd(gamer, buyerCreator);
                break;
            case 7:
                System.out.println("Masz na koncie: "+gamer.cash);
                wait4key();
                break;
            case 8:
                transactionGenerator.DisplayTransaction();
                wait4key();
                break;
            case 9:
                repairGenerator.DisplayRepairs();
                wait4key();
                break;
            case 10:
                System.out.println("Wydałeś już: "+gamer.costs);
                break;
            default:
                System.out.println("Nie ma takiej opcji, spróbuj ponownie");
                wait4key();
                break;
        }
    }
    public Integer Listen(){
        Scanner console = new Scanner(System.in);
        return console.nextInt();
    }
    //Kupowanie reklamy
    public void buyAd(Gamer gamer, BuyerCreator buyerCreator){
        System.out.println("Wybierz reklamę jaką chcesz \n" +
                "1. Reklama Radiowa - 1000.0 \n" +
                "2. Reklama Internetowa 500.0 \n");
        switch (Listen()){
            case 1:
                int a = 0;
                for(int i = 0; i<ThreadLocalRandom.current().nextInt(1, 10); i++){
                    buyerCreator.Create();
                    a++;
                }
                System.out.println("Kupiłeś Reklamę Radiową. Dostałeś: "+a);
                gamer.cash-=1000.0;
                break;
            case 2:
                buyerCreator.Create();
                System.out.println("Kupiłeś Reklamę Internetową. Masz jednego klienta więcej");
                gamer.cash-=500.0;
                break;
            default:
                System.out.println("Nie ma takiej opcji, nie umiesz czytać? \n" +
                        "Naciśnij przycisk, by kontynuować");
                wait4key();
                break;
        }
    }
    public void wait4key(){
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Double choiceHelper(Integer v, Car car){
        switch (v){
            case 1:
                return car.priceEngine;
            case 2:
                return car.priceBrakes;
            case 3:
                return car.priceGearBox;
            case 4:
                return car.priceCarBody;
            case 5:
                return car.priceCarSuspension;
            default:
                return 0.0;
        }
    }
}
