package com.company.Car;

public class Car {
    private String mark;
    private String color;
    private String segment;
    private Integer course;
    private Integer brokeEngine;
    private Double priceEngine;
    private Integer brokeBrakes;
    private Double priceBrakes;
    private Integer brokeGearBox;
    private Double priceGearBox;
    private Integer brokeCarBody;
    private Double priceCarBody;
    private Integer brokeCarSuspension;
    private Double priceCarSuspension;
    private Double price;

    public Car(String mark, String color, String segment, Integer course, Integer brokeEngine, Double priceEngine, Integer brokeBrakes,
               Double priceBrakes, Integer brokeGearBox, Double priceGearBox, Integer brokeCarBody, Double priceCarBody, Integer brokeCarSuspension, Double priceCarSuspension,
               Double price) {
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
    private void WashCar(){
        System.out.println("Wash, Wash!");
    }
    @Override
    public String toString() {
        return "Car" +
                "mark='" + mark + '\'' +
                ", color='" + color + '\'' +
                ", segment='" + segment + '\'' +
                ", course=" + course +
                ", price=" + price;
    }
}
