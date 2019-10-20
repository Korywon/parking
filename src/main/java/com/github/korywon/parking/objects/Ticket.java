package com.github.korywon.parking.objects;

import java.util.Date;

public class Ticket {
    private String licensePlateNumber;
    private Gate gateEnter;
    private String timeEnter;
    private Gate gateExit;
    private String timeClose;
    private float amountDue;

    public Ticket() { }

    public Ticket(String licensePlateNumber, Gate gateEnter, String timeEnter, Gate gateExit, String timeClose, float amountDue) {
        this.licensePlateNumber = licensePlateNumber;
        this.gateEnter = gateEnter;
        this.timeEnter = timeEnter;
        this.gateExit = gateExit;
        this.timeClose = timeClose;
        this.amountDue = amountDue;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public Gate getGateEnter() {
        return gateEnter;
    }

    public void setGateEnter(Gate gateEnter) {
        this.gateEnter = gateEnter;
    }

    public String getTimeEnter() {
        return timeEnter;
    }

    public void setTimeEnter(String timeEnter) {
        this.timeEnter = timeEnter;
    }

    public Gate getGateExit() {
        return gateExit;
    }

    public void setGateExit(Gate gateExit) {
        this.gateExit = gateExit;
    }

    public String getTimeClose() {
        return timeClose;
    }

    public void setTimeClose(String timeClose) {
        this.timeClose = timeClose;
    }

    public float getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(float amountDue) {
        this.amountDue = amountDue;
    }

    public void printInfo() {
        System.out.println(
          "-----" + this.licensePlateNumber + "-----" + "\n" +
          "Gate enter: " + this.gateEnter.getName() + "\n" +
          "Time enter: " + this.timeEnter + "\n" +
          "Gate exit: " + this.gateExit.getName() + "\n" +
          "Time exit: " + this.timeClose + "\n" +
          "Amount due: " + this.amountDue
        );
    }

    public boolean isOpen() {
        return (gateExit == null || this.timeClose.equals(""));
    }
}
