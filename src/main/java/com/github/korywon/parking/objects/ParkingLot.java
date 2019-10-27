package com.github.korywon.parking.objects;

public class ParkingLot extends Group {
    private String parkingLotName;
    private int capacity;
    private String gateEnter;
    private String gateExit;
    private float parkingLotPrice;

    public ParkingLot() {}

    public ParkingLot(String parkingLotName, int capacity, String gateEnter, String gateExit, float parkingLotPrice) {
        this.parkingLotName = parkingLotName;
        this.capacity = capacity;
        this.gateEnter = gateEnter;
        this.gateExit = gateExit;
        this.parkingLotPrice = parkingLotPrice;
    }

    public ParkingLot(String groupName, float groupPrice, String parkingLotName, int capacity, String gateEnter, String gateExit, float parkingLotPrice) {
        super(groupName, groupPrice);
        this.parkingLotName = parkingLotName;
        this.capacity = capacity;
        this.gateEnter = gateEnter;
        this.gateExit = gateExit;
        this.parkingLotPrice = parkingLotPrice;
    }

    public String getParkingLotName() {
        return parkingLotName;
    }

    public void setParkingLotName(String parkingLotName) {
        this.parkingLotName = parkingLotName;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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

    public float getParkingLotPrice() {
        return this.parkingLotPrice;
    }

    public void setParkingLotPrice(float parkingLotPrice) {
        this.parkingLotPrice = parkingLotPrice;
    }

    public void printInfo() {
        System.out.println(
            "----- Parking Lot -----" + "\n" +
            "Parking lot name: " + this.parkingLotName + "\n" +
            "Group name: " + this.groupName + "\n" +
            "Capacity: " + this.capacity + "\n" +
            "Gate enter: " + this.gateEnter + "\n" +
            "Gate exit: " + this.gateExit
        );

        if (this.groupPrice > 0.0f) {
            System.out.println("Group price: " + this.groupPrice);
        }

        System.out.println("Default price: " + this.parkingLotPrice);

        System.out.println();
    }
}
