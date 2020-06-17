package com.company.Human;

public class Human {
    private String name;

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                '}';
    }

    public Human(String name) {
        this.name = name;
    }
}
