package com.github.korywon.parking.objects;

public class Car {
    private String licensePlateNumber;
    private String color;
    private String make;
    private String model;

    public Car(String licensePlateNumber, String color, String make, String model) {
        this.licensePlateNumber = licensePlateNumber;
        this.color = color;
        this.make = make;
        this.model = model;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
