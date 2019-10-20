package com.github.korywon.parking.objects;

import java.util.List;

public class ParkingLot {
    private String name;
    private int capacity;
    private List<Gate> gatesEnter;
    private List<Gate> gatesExit;
    private float price;

    public ParkingLot() {}

    public ParkingLot(String name, int capacity, List<Gate> gatesEnter, List<Gate> gatesExit, float price) {
        this.name = name;
        this.capacity = capacity;
        this.gatesEnter = gatesEnter;
        this.gatesExit = gatesExit;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Gate> getGatesEnter() {
        return gatesEnter;
    }

    public void setGatesEnter(List<Gate> gatesEnter) {
        this.gatesEnter = gatesEnter;
    }

    public List<Gate> getGatesExit() {
        return gatesExit;
    }

    public void setGatesExit(List<Gate> gatesExit) {
        this.gatesExit = gatesExit;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void printInfo() {
        System.out.println(
          "----- " + this.name + " -----" + "\n" +
          "Capacity: " + this.capacity
        );

        System.out.print("Enter gates: ");
        for (Gate gate : gatesEnter) {
            System.out.print("\"" + gate.getName() + "\" ");
        }
        System.out.println();

        System.out.print("Exit gates: ");
        for (Gate gate : gatesExit) {
            System.out.print("\"" + gate.getName() + "\" ");
        }
        System.out.println();

        System.out.println("Price: " + this.name);
    }
}
