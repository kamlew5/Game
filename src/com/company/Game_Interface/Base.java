package com.company.Game_Interface;

import com.company.Car.Car;
import com.company.Car.CarGenerator;
import com.company.Car.RepairGenerator;
import com.company.Human.BuyerCreator;
import com.company.Human.Gamer;
import com.company.Human.Mechanic;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Base {
    public Integer nrTurn = 0;
    public void Menu(CarGenerator carGenerator, Gamer gamer, BuyerCreator buyerCreator, Mechanic janusz,
                     Mechanic mariusz, Mechanic adrain, TransactionGenerator transactionGenerator,
                     RepairGenerator repairGenerator){
        //Komunikat menu
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
        //Załącza funkcję wyboru
        ChoiceMenu(carGenerator, gamer, buyerCreator, janusz, mariusz, adrain, transactionGenerator, repairGenerator);
    }
    //Podstawowe przywitanie gracza
    public void Welcome(){
        System.out.println("Witam w Symulatorze Handlarza Aut");
    }
    public void ChoiceMenu(CarGenerator carGenerator, Gamer gamer, BuyerCreator buyerCreator, Mechanic janusz, Mechanic mariusz,
                           Mechanic adrian, TransactionGenerator transactionGenerator, RepairGenerator repairGenerator){
        //Switch służy do podstawowego wyboru pomiędzy opcjami gry
        switch (listen()){
            case 1:
                //Załączenie zakupu auta
                option1(carGenerator, gamer, transactionGenerator);
                break;
            case 2:
                option2(gamer);
                break;
            case 3:
                option3(gamer, janusz, mariusz, adrian, repairGenerator);
                break;
            case 4:
                buyerCreator.displayBuyers();
                wait4key();
                break;
            case 5:
                option5(gamer, buyerCreator, transactionGenerator);
                break;
            case 6:
                buyAd(gamer, buyerCreator);
                addTurn();
                break;
            case 7:
                System.out.println("Masz na koncie: "+gamer.cash);
                wait4key();
                break;
            case 8:
                transactionGenerator.displayTransaction();
                wait4key();
                break;
            case 9:
                repairGenerator.displayRepairs();
                wait4key();
                break;
            case 10:
                System.out.println("Wydałeś już: "+gamer.costs);
                wait4key();
                break;
            default:
                System.out.println("Nie ma takiej opcji, spróbuj ponownie");
                wait4key();
                break;
        }
    }
    //Nasłuchuje na liczbę
    private Integer listen(){
        Scanner console = new Scanner(System.in);
        return console.nextInt();
    }
    //Kupowanie reklamy
    private void buyAd(Gamer gamer, BuyerCreator buyerCreator){
        System.out.println("Wybierz reklamę jaką chcesz \n" +
                "1. Reklama Radiowa - 1000.0 \n" +
                "2. Reklama Internetowa 500.0 \n");
        switch (listen()){
            case 1:
                int a = 0;
                for(int i = 0; i<ThreadLocalRandom.current().nextInt(1, 10); i++){
                    buyerCreator.create();
                    a++;
                }
                System.out.println("Kupiłeś Reklamę Radiową. Dostałeś: "+a);
                gamer.cash-=1000.0;
                wait4key();
                break;
            case 2:
                buyerCreator.create();
                System.out.println("Kupiłeś Reklamę Internetową. Masz jednego klienta więcej");
                gamer.cash-=500.0;
                wait4key();
                break;
            default:
                System.out.println("Nie ma takiej opcji, nie umiesz czytać?");
                wait4key();
                break;
        }
    }
    private void wait4key(){
        System.out.println("Naciśnij przycisk, by kontynuować");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Double choiceHelper(Integer v, Car car){
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
    private void addTurn(){
        nrTurn++;
    }
    public void returnTurn(Double cash){
        System.out.println("Wygrałeś w " + nrTurn + " tur. Z ilością pieniędzy na koncie: " + cash);
    }
    //Wielkie opcje wywalone z switcha, aby tam nie tworzyć wielkiej choinki
    private void option1(CarGenerator carGenerator, Gamer gamer, TransactionGenerator transactionGenerator){
        carGenerator.displayCars();
        System.out.println("Wybierz numer od 1 do 10, by kupić auto, pozostałe by wyjść do menu");
        int helper = listen();
        if(helper<=carGenerator.availableCars.size())
        {
            int a = carGenerator.changeOwner(gamer, helper, transactionGenerator);
            if(a==1) {
                addTurn();
            }
            wait4key();
        }
        else{
            System.out.println("Źle wybrałeś...");
            wait4key();
        }
    }
    private void option2 (Gamer gamer){
        if(gamer.garage.size()<=0) {
            System.out.println("Nie masz nic w garażu");
            wait4key();
        }
        else{
            gamer.showCars();
            System.out.println("Wybierz samochód od 1 do "
                    +(gamer.garage.size())+
                    ", aby je umyć lub wybierz poza skalą, by wyjść");
            int ba = listen() - 1;
            if(ba < gamer.garage.size()){
                gamer.garage.get(ba).washCar(gamer);
                addTurn();
                wait4key();
            }
        }
    }
    private void option3 (Gamer gamer, Mechanic janusz, Mechanic mariusz, Mechanic adrian, RepairGenerator repairGenerator){
        if(gamer.garage.size()<=0) {
            System.out.println("Kup se samochód");
            wait4key();
        }
        else{
            gamer.displayGarage();
            System.out.println("Wybierz samochód: ");
            int lcas3 = listen() - 1;
            if(lcas3>=gamer.garage.size()){
                System.out.println("Nie ma takiego samochodu");
                wait4key();
            }
            else{
                System.out.println("Wybierz co naprawić: \n" +
                        "1. Silnik \n" +
                        "2. Hamulce \n" +
                        "3. Skrzynie Biegów \n" +
                        "4. Karoserie \n" +
                        "5. Zawieszenie ");
                Integer choiceRepair = listen();
                System.out.println("Wybierz mechanika: \n" +
                        "1. Janusz - \"ŁO PANIE! Kto Panu tak Spierd***ł!?\" cena: "
                        +choiceHelper(choiceRepair, gamer.garage.get(lcas3))*janusz.price+"\n" +
                        "2. Mariusz - \"Andrzeju nie denerwuj się...\" cena: "
                        +choiceHelper(choiceRepair, gamer.garage.get(lcas3))*mariusz.price+"\n" +
                        "3. Adrian - \"To się wyklepie\" cena: "
                        +choiceHelper(choiceRepair, gamer.garage.get(lcas3))*adrian.price);
                switch (listen()){
                    case 1:
                        choosedMechanic(janusz, gamer, lcas3, choiceRepair,repairGenerator);
                        break;
                    case 2:
                        choosedMechanic(mariusz, gamer, lcas3, choiceRepair, repairGenerator);
                        break;
                    case 3:
                        choosedMechanic(adrian, gamer, lcas3, choiceRepair, repairGenerator);
                        break;
                    default:
                        System.out.println("Nie ma takiej opcji");
                        wait4key();
                        break;
                }
            }
        }
    }
    private void option5(Gamer gamer, BuyerCreator buyerCreator, TransactionGenerator transactionGenerator){
        if(gamer.garage.size()<=0){
            System.out.println("Kup se samochód");
            wait4key();
        }
        else {
            gamer.displayGarage();
            int a = listen() - 1;
            buyerCreator.displayBuyers();
            System.out.println("Wybierz kupca:");
            int helperBuyers = listen() - 1;
            if(buyerCreator.buyers.get(helperBuyers).interestedCar1.equals(gamer.garage.get(a).getMark())||
                    buyerCreator.buyers.get(helperBuyers).interestedCar2.equals(gamer.garage.get(a).getMark())){
                if(buyerCreator.buyers.get(helperBuyers).cash<gamer.garage.get(a).price){
                    System.out.println("On nie ma na to kasy...");
                }
                else{
                    if(gamer.garage.get(a).brokeCarSuspension == 0 &&
                            gamer.garage.get(a).brokeCarBody == 0 &&
                            gamer.garage.get(a).brokeGearBox == 0 &&
                            gamer.garage.get(a).brokeEngine == 0 &&
                            gamer.garage.get(a).brokeBrakes == 0 &&
                            gamer.garage.get(a).washed == 1){
                        succesBuy(gamer, a, buyerCreator, helperBuyers, transactionGenerator);
                    }
                    else{
                        if(ThreadLocalRandom.current().nextInt(0,100 )>95){
                            succesBuy(gamer, a, buyerCreator, helperBuyers, transactionGenerator);
                        }
                        else
                            System.out.println("Musisz go najpierw uszykować, by go sprzedać!");
                    }
                }
            }
            else{
                System.out.println("Kupiec tego nie chce...");
                wait4key();
            }
        }
    }
    private void choosedMechanic(Mechanic mechanic, Gamer gamer, Integer v, Integer choiceRepair,
                                RepairGenerator repairGenerator){
        System.out.println("Wybrano " + mechanic.getName());
        mechanic.repair(gamer.garage.get(v),choiceRepair, gamer, repairGenerator);
        addTurn();
        wait4key();
    }
    private void succesBuy(Gamer gamer, Integer a, BuyerCreator buyerCreator,
                           Integer helperBuyers, TransactionGenerator transactionGenerator){
        gamer.cash += gamer.garage.get(a).price * 0.98;
        System.out.println("Sprzedałeś: "+gamer.garage.get(a).getMark()+" za: " +
                ""+gamer.garage.get(a).price*0.98);
        transactionGenerator.generate(gamer.garage.get(a).getMark(),gamer,
                gamer.garage.get(a).price,1);
        gamer.garage.remove(a);
        gamer.sortCars();
        buyerCreator.create();
        buyerCreator.create();
        buyerCreator.buyers.remove(helperBuyers);
        buyerCreator.sortBuyers();
        addTurn();
        wait4key();
    }
}
