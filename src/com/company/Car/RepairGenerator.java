package com.company.Car;

import com.company.Human.Gamer;
import com.company.Human.Mechanic;

import java.util.ArrayList;

public class RepairGenerator {
    //Lista z naprawami
    ArrayList<Repair> repairs = new ArrayList<>();
    //tworzy naprawy
    public void Generate(Car car, Gamer gamer, Integer whatRepair, Double price, Mechanic mechanic){
        repairs.add(new Repair(car, gamer, whatRepair, price, mechanic));
    }
    //wyświetla je
    public void displayRepairs(){
        if(repairs.size()!=0)
            for(Repair repair : this.repairs){
                System.out.println(repair);
            }
    }
}
