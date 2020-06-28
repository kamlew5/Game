package com.company.Car;

import com.company.Human.Gamer;
import com.company.Human.Mechanic;

import java.util.ArrayList;

public class RepairGenerator {
    ArrayList<Repair> repairs = new ArrayList<>();
    public void Generate(Car car, Gamer gamer, Integer whatRepair, Double price, Mechanic mechanic){
        repairs.add(new Repair(car, gamer, whatRepair, price, mechanic));
    }
    public void DisplayRepairs(){
        for (Repair repair : this.repairs) {
            System.out.println(repair);
        }
    }
}
