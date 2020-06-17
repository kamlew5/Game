package com.company;


import com.company.Car.Generator;
import com.company.Human.Mechanic;
import com.company.Car.Generator;

public class Main {

    public static void main(String[] args) {
        Mechanic janusz = new Mechanic("Janusz", 0.0, 100,0,1.3);
        Mechanic mariusz = new Mechanic("Mariusz", 0.0, 90,0,1.0);
        Mechanic adrian = new Mechanic("Adrian", 0.0, 80,2,0.7);

        //janusz.Repair();
        //mariusz.Repair();
        //adrian.Repair();
        Generator carGenerator = new Generator();
        carGenerator.Generate();
        //carGenerator.Generate();
        //carGenerator.Generate();
        //carGenerator.Generate();
        System.out.println(carGenerator.availableCars.size());
        System.out.println(carGenerator.availableCars);
       // carGenerator.availableCars.get(1);
    }
}
