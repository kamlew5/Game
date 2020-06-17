package com.company;

import com.company.Human.Mechanic;

public class Main {

    public static void main(String[] args) {
        Mechanic janusz = new Mechanic("Janusz", 0.0, 100,0,130.0);
        Mechanic mariusz = new Mechanic("Mariusz", 0.0, 90,0,100.0);
        Mechanic adrian = new Mechanic("Adrian", 0.0, 80,2,70.0);

        janusz.Repair();
        mariusz.Repair();
        adrian.Repair();
    }
}
