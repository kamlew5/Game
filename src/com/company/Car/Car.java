package com.company.Car;

public class Car {
    private String mark, color, segment;
    private Integer course, brokeEngine, brokeBrakes, brokeGearBox, brokeCarBody, brokeCarSuspension;
    private Double priceEngine, priceBrakes, priceGearBox, priceCarBody, priceCarSuspension, price;

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
    public String getProcent(){
        return ((100-(this.brokeCarSuspension+this.brokeCarBody+this.brokeGearBox+this.brokeEngine+this.brokeBrakes)*20))+"%";
    }
    private void WashCar(){
        System.out.println("Wash, Wash!");
    }

    public void diplayBrokes(){
        String a1 = "", a2 = "", a3 = "", a4 = "", a5 = "";
        if(this.brokeEngine==1){
            a1 = "*Silnik \n";
        }
        if(this.brokeBrakes==1){
            a2 = "*Hamulce \n";
        }
        if(this.brokeGearBox==1){
            a3 = "*Skrzynia \n";
        }
        if(this.brokeCarBody==1){
            a4 = "*Karoseria \n";
        }
        if(this.brokeCarSuspension==1){
            a5 = "*Zawieszenie \n";
        }
        if(a1.equals("")&&a2.equals("")&&a3.equals("")&&a4.equals("")&&a5.equals(""))
            System.out.println("Wszystko sprawne");
        else
            System.out.println("Do naprawy: \n"+a1+a2+a3+a4+a5);
    }

    public String getText(){
        return mark+", "+
                segment+", "+
                color+", "+
                course+", "+
                price+", "+
                ((100-(this.brokeCarSuspension+this.brokeCarBody+this.brokeGearBox+this.brokeEngine+this.brokeBrakes)*20))+"%";
    }
    @Override
    public String toString() {
        return "Marka='" + mark + '\'' +
                ", Kolor='" + color + '\'' +
                ", Segment='" + segment + '\'' +
                ", Przebieg=" + course +
                ", Cena=" + price;
    }
}
