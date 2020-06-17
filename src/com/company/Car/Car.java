package com.company.Car;

public class Car {
    private String mark;
    private String model;
    private String color;
    private String segment;
    private Double course;
    private Boolean brokeEngine;
    private Double priceEngine;
    private Boolean brokeBrakes;
    private Double priceBrakes;
    private Boolean brokeGearBox;
    private Double priceGearBox;
    private Boolean brokeCarBody;
    private Double priceCarBody;
    private Boolean brokeCarSuspension;
    private Double priceCarSuspension;

    public Car(String mark, String model, String color, String segment, Double course, Boolean brokeEngine, Double priceEngine, Boolean brokeBrakes, Double priceBrakes, Boolean brokeGearBox, Double priceGearBox, Boolean brokeCarBody, Double priceCarBody, Boolean brokeCarSuspension, Double priceCarSuspension) {
        this.mark = mark;
        this.model = model;
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
    }
}
