package com.company.Human;
import java.util.concurrent.ThreadLocalRandom;

public class Mechanic extends Human {
    private Integer ChanceRepair;
    private Integer ChanceBroke;
    private Double price;

    public Mechanic(String name, Double cash, Integer chanceRepair, Integer chanceBroke, Double price) {
        super(name, cash);
        ChanceRepair = chanceRepair;
        ChanceBroke = chanceBroke;
        this.price = price;
    }
    public void Repair() {
        int randRepair = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        if(this.ChanceRepair >= randRepair) System.out.println("Dziala");
        else System.out.println("Nie działa");
        int randBroke = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        if(this.ChanceBroke <= randBroke) System.out.println("Dziala 2");
        else System.out.println("Nie działa 2");
    }
}
