package com.company.Human;
import com.company.Car.Car;
import com.company.Car.RepairGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Mechanic {
    private String name;
    private Integer chanceRepair;
    private Integer chanceBroke;
    public Double price;

    public Mechanic(String name, Integer chanceRepair, Integer chanceBroke, Double price) {
        this.name = name;
        this.chanceRepair = chanceRepair;
        this.chanceBroke = chanceBroke;
        this.price = price;
    }
    //zwraca imię mechanika
    public String getName() {
        return name;
    }
    //funkcja do naprawiania aut
    public void repair(Car car, int helper, Gamer gamer, RepairGenerator repairGenerator) {
        switch (helper){
            case 1:
                // sprawdza czy nie jest popsute
                if(car.brokeEngine==0)
                    System.out.println("Przecież nie jest popsute");
                else{
                    //naprawia samochód
                    car.brokeEngine = checkCash(car, gamer, car.priceEngine, 1);
                    //zwiększa cenę auta
                    car.price *=2;
                    //tworzy naprawę
                    repairGenerator.Generate(car, gamer, helper, car.priceEngine, this);
                }
                break;
            case 2:
                if(car.brokeBrakes==0)
                    System.out.println("Przecież nie jest popsute");
                else{
                    car.brokeBrakes = checkCash(car, gamer, car.priceBrakes, 2);
                    car.price*=1.1;
                    repairGenerator.Generate(car, gamer, helper, car.priceEngine, this);
                }
                break;
            case 3:
                if(car.brokeGearBox==0)
                    System.out.println("Przecież nie jest popsute");
                else{
                    car.brokeGearBox = checkCash(car, gamer, car.priceGearBox, 3);
                    car.price*=1.5;
                    repairGenerator.Generate(car, gamer, helper, car.priceEngine, this);
                }
                break;
            case 4:
                if(car.brokeCarBody==0)
                    System.out.println("Przecież nie jest popsute");
                else{
                    car.brokeCarBody = checkCash(car, gamer, car.priceCarBody, 4);
                    car.price*=1.5;
                    repairGenerator.Generate(car, gamer, helper, car.priceEngine, this);
                }
                break;
            case 5:
                if(car.brokeCarSuspension==0)
                    System.out.println("Przecież nie jest popsute");
                else{
                    car.brokeCarSuspension = checkCash(car, gamer, car.priceCarSuspension, 5);
                    car.price*=1.2;
                    repairGenerator.Generate(car, gamer, helper, car.priceEngine, this);
                }
                break;
            default:
                break;
        }
    }
    //funkcja sprawdza czy ma się kasę i odpala naprawa i możliwe uszkodzenie
    public Integer checkCash(Car car, Gamer gamer, Double pricePart, Integer helper){
        if(pricePart*this.price>gamer.cash){
            System.out.println("Nie masz kasy");
            return 1;
        }
        else{
            gamer.cash -=pricePart*this.price;
            gamer.costs =pricePart*this.price;
            subBroke(car, helper);
            return subRepair();
        }
    }
    //sprawdza czy da się naprawić
    public Integer subRepair(){
        if(this.chanceRepair >=RadomHelper()) {
            System.out.println("Naprawiono");
            return 0;
        }
        else {
            System.out.println("Nie naprawiono");
            return 1;
        }
    }
    //psuje
    public void subBroke(Car car, int a){
        if(chanceBroke!=0) {
            if (RadomHelper() <= this.chanceBroke) {
                //losuje co popsuć
                int h = ThreadLocalRandom.current().nextInt(1, 5 + 1);
                //nie pozwala popsuć tego samego
                if (h == a)
                    h = ThreadLocalRandom.current().nextInt(1, 5 + 1);
                switch (h) {
                    case 1:
                        car.brokeEngine = 1;
                        System.out.println("Popsuto Silnik");
                        break;
                    case 2:
                        car.brokeBrakes = 1;
                        System.out.println("Popsuto Hamulce");
                        break;
                    case 3:
                        car.brokeGearBox = 1;
                        System.out.println("Popsuto Skrzynię Biegów");
                        break;
                    case 4:
                        car.brokeCarBody = 1;
                        System.out.println("Popsuto Karoserie");
                        break;
                    case 5:
                        car.brokeCarSuspension = 1;
                        System.out.println("Popsuto Zawieszenie");
                        break;
                }
            }
        }
    }
    //funkcja do losowania liczby
    public Integer RadomHelper(){
        return ThreadLocalRandom.current().nextInt(0, 100 + 1);
    }
}
