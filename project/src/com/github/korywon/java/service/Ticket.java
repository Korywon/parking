package com.github.korywon.java.service;

import java.sql.Timestamp;

/**
 * <code>Ticket</code> class that holds the information related to ticket being issued for a driver.
 *
 * @author Alvin Huynh
 */
public class Ticket {
    /**
     * License plate number the ticket is associated with.
     */
    private String licensePlateNumber;
    /**
     * Name of the parking lot number.
     */
    private String parkingLotName;
    /**
     * Gate that the car entered through.
     */
    private Gate gateEnter;
    /**
     * Gate that the car exited through.
     */
    private Gate gateExit;

    /**
     * Timestamp when the ticket was opened.
     */
    private Timestamp timestampOpen;

    /**
     * Timestamp when the ticket was closed.
     */
    private Timestamp timestampClose;

    /**
     * Creates a new Ticket object.
     * @param licensePlateNumber License plate number of the driver's car.
     * @param parkingLotName Name of the parking lot.
     * @param gateEnter Gate that was entered through.
     * @param gateExit Gate that was exited through.
     * @param timestampOpen Timestamp when the ticket was opened.
     * @param timestampClose Timestamp when the ticket was closed.
     */
    Ticket(
        String licensePlateNumber, String parkingLotName,
        Gate gateEnter, Gate gateExit,
        Timestamp timestampOpen, Timestamp timestampClose
    ) {
        this.licensePlateNumber = licensePlateNumber;
        this.gateEnter = gateEnter;
        this.gateExit = gateExit;
        this.timestampOpen = timestampOpen;
        this.timestampClose = timestampClose;
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

    public Gate getGateEnter() {
        return gateEnter;
    }

    public void setGateEnter(Gate gateEnter) {
        this.gateEnter = gateEnter;
    }

    public Gate getGateExit() {
        return gateExit;
    }

    public void setGateExit(Gate gateExit) {
        this.gateExit = gateExit;
    }

    public Timestamp getTimestampOpen() {
        return timestampOpen;
    }

    public void setTimestampOpen(Timestamp timestampOpen) {
        this.timestampOpen = timestampOpen;
    }

    public Timestamp getTimestampClose() {
        return timestampClose;
    }

    public void setTimestampClose(Timestamp timestampClose) {
        this.timestampClose = timestampClose;
    }
}
