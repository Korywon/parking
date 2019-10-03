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
    private Car car;
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
     * The cost of the ticket.
     */
    private float cost;

    /**
     * Boolean flag to indicate if the cost has been paid.
     */
    private boolean costPaid;

    /**
     * Constructor to create a new <code>Ticket</code> object.
     * @param car Car object holding details of car.
     * @param parkingLotName Name of the parking lot.
     * @param gateEnter Gate that was entered through.
     * @param gateExit Gate that was exited through.
     * @param timestampOpen Timestamp when the ticket was opened.
     * @param timestampClose Timestamp when the ticket was closed.
     */
    Ticket(
        Car car, String parkingLotName,
        Gate gateEnter, Gate gateExit,
        Timestamp timestampOpen, Timestamp timestampClose, float cost, boolean costPaid
    ) {
        this.car = car;
        this.gateEnter = gateEnter;
        this.gateExit = gateExit;
        this.timestampOpen = timestampOpen;
        this.timestampClose = timestampClose;
        this.cost = cost;
        this.costPaid = costPaid;
    }

    public Car getCar() {
        return this.car;
    }

    public void setCar(Car car) {
        this.car = car;
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
