package com.company.Human;
import com.company.Car.Car;
import com.company.Car.RepairGenerator;

import java.util.concurrent.ThreadLocalRandom;

public class Mechanic {
    private String name;
    private Integer ChanceRepair;
    private Integer ChanceBroke;
    public Double price;

    public Mechanic(String name, Integer chanceRepair, Integer chanceBroke, Double price) {
        this.name = name;
        this.ChanceRepair = chanceRepair;
        this.ChanceBroke = chanceBroke;
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void Repair(Car car, int helper, Gamer gamer, RepairGenerator repairGenerator) {
        switch (helper){
            case 1:
                if(car.brokeEngine==0)
                    System.out.println("Przecież nie jest popsute");
                else{
                    car.brokeEngine = checkCash(car, gamer, car.priceEngine, 1);
                    car.price *=2;
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
    public Integer subRepair(){
        if(this.ChanceRepair>=RadomHelper()) {
            System.out.println("Naprawiono");
            return 0;
        }
        else {
            System.out.println("Nie naprawiono");
            return 1;
        }
    }
    public void subBroke(Car car, int a){
        if(RadomHelper()<=this.ChanceBroke){
           int h = ThreadLocalRandom.current().nextInt(1, 5 + 1);
           if (h==a)
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
    public Integer RadomHelper(){
        return ThreadLocalRandom.current().nextInt(0, 100 + 1);
    }
}
