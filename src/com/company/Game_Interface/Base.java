package com.company.Game_Interface;

import com.company.Car.Generator;
import com.company.Human.BuyerCreator;
import com.company.Human.Gamer;
import com.company.Human.GamerCreator;
import com.company.Human.Mechanic;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Base {
    public void Menu(Generator carGenerator, Gamer gamer, BuyerCreator buyerCreator){
        System.out.println("Menu:");
        System.out.println("1. Auta do Kupienia");
        System.out.println("2. Zobacz Swoje Auta");
        System.out.println("3. Napraw Samochód");
        System.out.println("4. Sprawdź Klientów");
        System.out.println("5. Sprzedaj Samochód");
        System.out.println("6. Kup Reklamę");
        System.out.println("7. Stan Konta");
        System.out.println("8. Historia Transakcji");
        System.out.println("9. Historia Napraw Samochodu");
        System.out.println("10. Suma Napraw i Mycia Aut");
        System.out.println("Wybierz opcję od 1 do 10: ");
        ChoiceMenu(carGenerator, gamer, buyerCreator);
    }
    public void Welcome(){
        System.out.println("Witam w Symulatorze Handlarza Aut");
    }
    public void ChoiceMenu(Generator carGenerator, Gamer gamer, BuyerCreator buyerCreator){
        switch (Listen()){
            case 1:
                carGenerator.DisplayCars();
                System.out.println("Wybierz numer od 1 do 10, by kupić auto, pozostałem by wyjść do menu");
                int helper = Listen();
                if(helper<10)
                    {
                    carGenerator.ChangeOwner(gamer, helper);
                    carGenerator.Generate();
                    carGenerator.SortCars();
                    gamer.SortCars();
                    System.out.println("Naciśnij przycisk, by kontynuować");
                    try {
                        System.in.read();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
            case 2:
                if(gamer.garage.size()<=0)
                    System.out.println("Nie masz nic w garażu");
                else
                    gamer.ShowCars2();
                System.out.println("Naciśnij cokolwiek, by przejść dalej");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 3:
                if(gamer.garage.size()<=0)
                    System.out.println("Nie masz nic w garażu");
                else{
                    System.out.println(gamer.garage);
                    int lcas3 = Listen();
                    lcas3--;
                    if(lcas3>gamer.garage.size()){
                        System.out.println("Nie ma takiego samochodu");
                        try {
                            System.in.read();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    else{
                        System.out.println(gamer.garage.get(lcas3));
                        gamer.garage.get(lcas3).diplayBrokes();
                    }
                }
                break;
            case 4:
                    buyerCreator.DisplayBuyers();
                break;
            case 5:
                break;
            case 6:
                buyAd(gamer, buyerCreator);
                break;
            case 7:
                System.out.println("Masz na koncie: "+gamer.cash);
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                System.out.println("Wydałeś już: "+gamer.costs);
                break;
            default:
                System.out.println("Nie ma takiej opcji, spróbuj ponownie");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
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
                break;
            case 2:
                buyerCreator.Create();
                System.out.println("Kupiłeś Reklamę Internetową. Masz jednego klienta więcej");
                break;
            default:
                System.out.println("Nie ma takiej opcji, nie umiesz czytać? \n" +
                        "Naciśnij przycisk, by kontynuować");
                try {
                    System.in.read();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
        }
    }
}
