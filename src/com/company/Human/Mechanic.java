package com.company.Human;

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
        if(this.ChanceRepair == 100) System.out.println("Dziala");
        else System.out.println("Nie działa");
        if(this.ChanceBroke == 0) System.out.println("Dziala 2");
        else System.out.println("Nie działa 2");
    }
}
