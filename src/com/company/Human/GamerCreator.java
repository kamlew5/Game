package com.company.Human;

import java.util.ArrayList;
import java.util.Scanner;

public class GamerCreator {
    public ArrayList<Gamer> gamers = new ArrayList<>();
    private String getName(){
        Scanner console = new Scanner(System.in);
        System.out.print("Give me your name: ");
        return console.nextLine();
    }
    private Integer getNumber(){
        Scanner console = new Scanner(System.in);
        System.out.println("Give me number of players: ");
        return console.nextInt();
    }
    public void Generate(){
        int number = getNumber();
        for (int i = 0; i < number; i++) {
            gamers.add(new Gamer(getName(),10000.0));
        }
    }
}
