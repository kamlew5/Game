package com.company.Car;

import com.company.Human.Gamer;

public class Car {
    private String mark, color, segment;
    public Integer course, brokeEngine, brokeBrakes, brokeGearBox, brokeCarBody, brokeCarSuspension;
    public Double priceEngine, priceBrakes, priceGearBox, priceCarBody, priceCarSuspension, price;
    public Integer washed = 0;

    public Car(String mark, String color, String segment, Integer course, Integer brokeEngine, Double priceEngine, Integer brokeBrakes,
               Double priceBrakes, Integer brokeGearBox, Double priceGearBox, Integer brokeCarBody, Double priceCarBody,
               Integer brokeCarSuspension, Double priceCarSuspension, Double price) {
        this.mark = mark;
        this.color = color;
        this.segment = segment;
        this.course = course;
        this.brokeEngine = brokeEngine;
        this.priceEngine = priceEngine;
        this.brokeBrakes = brokeBrakes;
        this.priceBrakes = priceBrakes;
        this.brokeGearBox = brokeGearBox;
        this.priceGearBox = priceGearBox;
        this.brokeCarBody = brokeCarBody;
        this.priceCarBody = priceCarBody;
        this.brokeCarSuspension = brokeCarSuspension;
        this.priceCarSuspension = priceCarSuspension;
        this.price = price;
    }
    public String getMark() {
        return mark;
    }
    public Double getPrice() {
        return price;
    }
//    public String getProcent(){
//        return ((100-(this.brokeCarSuspension+this.brokeCarBody+this.brokeGearBox+this.brokeEngine+this.brokeBrakes)*20))+"%";
//    }
    public void WashCar(Gamer gamer){
        if(this.washed == 1){
            System.out.println("Jest już umyty");
        }
        else {
            this.washed = 1;
            System.out.println("Myju, Myju!");
            gamer.cash -= 100.0;
            gamer.costs += 100.0;
        }
    }

    public String diplayBrokes(){
        String a1, a2, a3, a4, a5;
        if(this.brokeEngine==1){
            a1 = "Silnik - popsuty, ";
        }
        else
            a1 = "Silnik - sprawny, ";
        if(this.brokeBrakes==1){
            a2 = "Hamulce - popsute, ";
        }
        else
            a2 = "Hamulce - sprawne, ";
        if(this.brokeGearBox==1){
            a3 = "Skrzynia - sprawna, ";
        }
        else
            a3 = "Skrzynia - sprawna, ";
        if(this.brokeCarBody==1){
            a4 = "Karoseria - popsuta,";
        }
        else
            a4 = "Karoseria - cała, ";
        if(this.brokeCarSuspension==1){
            a5 = " Zawieszenie - posute";
        }
        else
            a5 = " Zawieszenie - sprawne";
        return a1+a2+a3+a4+a5;
    }

    public String getText(){
        return mark+", "+
                segment+", "+
                color+", "+
                course+", "+
                price+", "+
                ((100-(this.brokeCarSuspension+this.brokeCarBody+this.brokeGearBox+this.brokeEngine+this.brokeBrakes)*20))+"%";
    }
    public String Display(){
        return mark+", "+
                segment+", "+
                color+", "+
                course+", "+
                price+", " +
                washedif()+", "+
                diplayBrokes();
    }
    @Override
    public String toString() {
        return "Marka='" + mark + '\'' +
                ", Kolor='" + color + '\'' +
                ", Segment='" + segment + '\'' +
                ", Przebieg=" + course +
                ", Cena=" + price;
    }
    public String washedif(){
        if(washed==1)
            return "umyty";
        else
            return "trzeba umyć";
    }
}
