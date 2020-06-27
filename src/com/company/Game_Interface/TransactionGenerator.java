package com.company.Game_Interface;

import com.company.Car.Car;
import com.company.Human.Gamer;

import java.util.ArrayList;

public class TransactionGenerator {
    public ArrayList<Transaction> transactions = new ArrayList<>();

    public void Generate(String carName, Gamer gamer, Double cash, Integer typeTransaction){
        transactions.add(new Transaction(gamer.name, carName, cash, typeTransaction));
    }
    public void DisplayTransaction(){
        if(transactions.size()!=0)
            for(Transaction transaction : this.transactions){
                System.out.println(transaction);
            }
        else
            System.out.println("Nie masz jeszcze żadnej transakcji");
    }
}
