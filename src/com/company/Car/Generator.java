package com.company.Car;
import com.company.Game_Interface.TransactionGenerator;
import com.company.Human.Gamer;

import java.text.DecimalFormat;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.Math.*;

public class Generator{
    //Stringi do losowania podczas tworzenia aut
    private String[] carMarks = {"Saab 9.3", "Wieśwagen Pastuch", "Fiat Punto", "Mercedes AMG GT",
            "BMW 3", "Kia Stringer", "Seat Ibiza", "Mitsubishi Galant"};
    private String[] carColor = {"Różowy", "Czerwony", "Turkusowy", "WTF! Co to za kolor!", "Niebieski", "Zielony", "Jakiś"};
    private String[] carSegment = {"Mini", "Small", "Medium", "Large", "Exectutive", "Luxury", "Sport"};
    //Lista aut dostępnych do kupienia
    public ArrayList<Car> availableCars = new ArrayList<>();
    //Double z określoną ilością licz po przecinku
    private DecimalFormat df = new DecimalFormat("#######.##");

    //Funkcja do generowania zmiennych aut
    private String CarGenerator(String[] generateValue) {
        Random r = new Random();
        int randomNumber = r.nextInt(generateValue.length);
        return(generateValue[randomNumber]);
    }
    //funkcja do tworzenia uszkodzeń w autach
    private Integer CreateDefect(){
        return ThreadLocalRandom.current().nextInt(0, 1+1);
    }
    //tworzy cenę naprawy zależną od marki i od uszkodzonej części
    private Double CreatePrice(String mark, Integer type){
        double litlehelper;
        double secondlitlehelper;
        switch(mark){
            case "Saab 9.3":
            case "Mitsubishi Galant":
                litlehelper = 1.1;
            break;
            case "Mercedes AMG GT":
            case "BMW 3":
                litlehelper = 1.2;
            break;
            case "Wieśwagen Passat":
            case "Fiat Punto":
                litlehelper = 0.9;
            break;
            case "Kia Stringer":
                litlehelper = 1.15;
            break;
            default:
                litlehelper = 1.0;
            break;
        }
        switch (type){
            case 1:
                secondlitlehelper = 1000.0;
            break;
            case 2:
                secondlitlehelper = 400.0;
            break;
            case 3:
                secondlitlehelper = 750.0;
            break;
            case 4:
                secondlitlehelper = 700.0;
            break;
            case 5:
                secondlitlehelper = 500.0;
            break;
            default:
                secondlitlehelper = 2000.0;
            break;
        }
        return litlehelper*secondlitlehelper;
    }
    //cena auta zależna od marki
    private Double CreatePrice(String mark){
        double litlehelper;
        switch(mark){
            case "Saab 9.3":
            case "Mitsubishi Galant":
                litlehelper = 1.1;
                break;
            case "Mercedes AMG GT":
            case "BMW 3":
                litlehelper = 1.2;
                break;
            case "Wieśwagen Passat":
            case "Fiat Punto":
                litlehelper = 0.9;
                break;
            case "Kia Stringer":
                litlehelper = 1.15;
                break;
            default:
                litlehelper = 1.0;
                break;
        }
        return litlehelper*10000;
    }
    //tworzy auta
    public void Generate(){
        String a1 = CarGenerator(carMarks);
        String a2 = CarGenerator(carColor);
        String a3 = CarGenerator(carSegment);
        Integer b1 = CreateDefect();//silnik 2
        Integer b2 = CreateDefect();//hamulce 1.1
        Integer b3 = CreateDefect();//skrzynia 1.5
        Integer b4 = CreateDefect();//Karoseria 1.5
        Integer b5 = CreateDefect();//Zawieszenie 1.2
        Double c1 = CreatePrice(a1,1);
        Double c2 = CreatePrice(a1,2);
        Double c3 = CreatePrice(a1,3);
        Double c4 = CreatePrice(a1,4);
        Double c5 = CreatePrice(a1,5);
        //random z przebiegiem
        int carCourse = ThreadLocalRandom.current().nextInt(10000, 99999);
        //zmienić na cenę zależną od przebiegu
        Double p1 = CreatePrice(a1);
        if(b1==1) p1 -= p1 * 0.5;
        if(b2==1) p1 -= p1 * 0.9;
        if(b3==1) p1 -= p1 * 0.67;
        if(b4==1) p1 -= p1 * 0.67;
        if(b5==1) p1 -= p1 * 0.8;
        p1 = (double) (round(p1 * 100) / 100);
        availableCars.add(new Car(a1,a2,a3,carCourse,b1,c1,b2,c2,b3,c3,b4,c4,b5,c5,p1));
    }
    //wyświetla podstawowe rzeczy o zakupie auta
    public void DisplayCars(){
        for (int i = 0; i < availableCars.size(); i++) {
            System.out.println(i+1+" "+availableCars.get(i).Display());
        }
    }
    //sortuje autka
    public void SortCars(){
        availableCars.sort(Comparator.comparing(Car::getMark));
    }
    //zakup auta
    public void ChangeOwner(Gamer gamer, int helper, TransactionGenerator transactionGenerator){
        //odejmowanie o jeden by się zgadzały wartości z tablicą
        helper--;
        //sprawdza, czy nas stać na zakup + podatek
        if(gamer.cash<(availableCars.get(helper).getPrice()*1.02)){
            System.out.println("Za mało szmalu");
        }
        else {
            //przypisanie auta do gra
            gamer.garage.add(availableCars.get(helper));
            //usunięcie kasy
            gamer.cash -= (availableCars.get(helper).getPrice()*1.02);
            transactionGenerator.Generate(availableCars.get(helper).getMark(), gamer,availableCars.get(helper).getPrice()*1.02, 0);
            availableCars.remove(helper);
            System.out.println("Kupiłeś samochód");
        }
    }
}
