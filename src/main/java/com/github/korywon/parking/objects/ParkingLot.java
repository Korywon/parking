package com.github.korywon.parking.objects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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


    /**
     * Gets the definitive price of the parking lot. If the group price is more than 0, than the group price is
     * returned. Else the parking lot price is returned.
     * @return
     */
    public float getPrice() {
        if (this.groupPrice > 0.0f) {
            return this.groupPrice;
        } else {
            return this.parkingLotPrice;
        }
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
    }

    /**
     * Returns the number of available parking spaces for a given parking lot and ticket list.
     * @param parkingLot
     * @param ticketList
     * @return
     */
    public static int getAvailableSpaces(ParkingLot parkingLot, List<Ticket> ticketList) {
        int ticketCount = 0;
        for (Ticket ticket : ticketList) {
            if (
                ticket.getParkingLotName().equals(parkingLot.getParkingLotName()) &&
                    "".equals(ticket.getGateExit())
            ) {
                ticketCount++;
            }
        }

        return parkingLot.getCapacity() - ticketCount;
    }

    /**
     * Gets the lowest parking space available in the parking lot based on the given parking lot and ticket list.
     * Returns a -1 if there are no open spaces available.
     * @param parkingLot
     * @param ticketList
     * @return
     */
    public static int getLowestAvailableSpace(ParkingLot parkingLot, List<Ticket> ticketList) {
        List<Integer> occupiedSpaces = new ArrayList<Integer>();
        for (Ticket ticket : ticketList) {
            if (
                ticket.getParkingLotName().equals(parkingLot.getParkingLotName()) &&
                !"".equals(ticket.getGateExit())
            ) {
                occupiedSpaces.add(ticket.getParkingSpace());
            }
        }

        Collections.sort(occupiedSpaces);

        for (int i = 0; i < parkingLot.getCapacity(); i++) {
            int index = occupiedSpaces.indexOf(i);
            if (index != -1) {
                return i;
            }
        }

        return -1;
    }

    public static int indexOfParkingLotList(List<ParkingLot> parkingLotList, String parkingLotName) {
        for (int i = 0 ; i < parkingLotList.size(); i++) {
            if (parkingLotList.get(i).getParkingLotName().equals(parkingLotName)) {
                return i;
            }
        }
        return -1;
    }
}
