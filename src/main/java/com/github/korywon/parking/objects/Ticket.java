package com.github.korywon.parking.objects;

public class Ticket {
    private String licensePlateNumber;
    private String parkingLotName;
    private String groupName;
    private int parkingSpace;
    private String gateEnter;
    private String gateExit;
    private float amountDue;

    public Ticket() {
        this.licensePlateNumber = "";
        this.parkingLotName = "";
        this.parkingSpace = -1;
        this.groupName = "";
        this.gateEnter = "";
        this.gateExit = "";
        this.amountDue = 0.0f;
    }

    public Ticket(
        String licensePlateNumber, String parkingLotName, String groupName, int parkingSpace, String gateEnter,
        String gateExit, float amountDue
    ) {
        this.licensePlateNumber = licensePlateNumber;
        this.parkingLotName = parkingLotName;
        this.groupName = groupName;
        this.parkingSpace = parkingSpace;
        this.gateEnter = gateEnter;
        this.gateExit = gateExit;
        this.amountDue = amountDue;
    }

    public String getLicensePlateNumber() {
        return licensePlateNumber;
    }

    public void setLicensePlateNumber(String licensePlateNumber) {
        this.licensePlateNumber = licensePlateNumber;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public int getParkingSpace() {
        return parkingSpace;
    }

    public void setParkingSpace(int parkingSpace) {
        this.parkingSpace = parkingSpace;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGateEnter() {
        return gateEnter;
    }

    public void setGateEnter(String gateEnter) {
        this.gateEnter = gateEnter;
    }

    public String getGateExit() {
        return gateExit;
    }

    public void setGateExit(String gateExit) {
        this.gateExit = gateExit;
    }

    public float getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(float amountDue) {
        this.amountDue = amountDue;
    }

    public void printInfo() {
        System.out.println(
            "------ Ticket -----" + "\n" +
            "License plate number: " + this.licensePlateNumber + "\n" +
            "Parking lot name: " + this.parkingLotName + "\n" +
            "Group name: " + this.licensePlateNumber + "\n" +
            "Parking space: " + this.parkingSpace + "\n" +
            "Gate enter: " + this.gateEnter + "\n" +
            "Gate exit: " + this.gateExit + "\n" +
            "Amount due: " + this.amountDue
        );
    }

    public boolean isOpen() {
        return (gateExit == null || gateExit.equals(""));
    }
}
