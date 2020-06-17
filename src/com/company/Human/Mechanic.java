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
}
