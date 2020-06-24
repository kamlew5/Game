package com.company.Game_Interface;

import com.company.Car.Generator;
import com.company.Human.BuyerCreator;
import com.company.Human.Gamer;
import com.company.Human.GamerCreator;
import com.company.Human.Mechanic;

import java.io.IOException;
import java.util.Scanner;

public class Base {
    public void Menu(Generator carGenerator, Gamer gamer){
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
        ChoiceMenu(carGenerator, gamer);
    }
    public void Welcome(){
        System.out.println("Witam w Symulatorze Handlarza Aut");
    }
    public void ChoiceMenu(Generator carGenerator, Gamer gamer){
        switch (Listen()){
            case 1:
                carGenerator.DisplayCars();
                System.out.println("Wybierz numer od 1 do 10, by kupić auto, pozostałem by wyjść do menu");
                int helper = Listen();
                if(helper>10)
                    Menu(carGenerator, gamer);
                else{
                    carGenerator.ChangeOwner(gamer, helper);
                    carGenerator.Generate();
                    carGenerator.SortCars();
                    gamer.SortCars();
                }
                break;
            case 2:
                gamer.ShowCars();
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
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
                ChoiceMenu(carGenerator, gamer);
                break;
        }
    }
    public Integer Listen(){
        Scanner console = new Scanner(System.in);
        return console.nextInt();
    }
}
