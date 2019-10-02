package com.github.korywon.java.service;

import com.github.korywon.java.trackers.GateTracker;
import com.github.korywon.java.trackers.TicketTracker;

/**
 * Parking lot object to track each instance of a parking lot.
 */
public class ParkingLot {
    /**
     * Name to identify the parking lot.
     */
    private String name;

    /**
     * Maximum capacity of the parking lot.
     */
    private int capacity;

    /**
     * Current number of vacant spots of the parking lot.
     */
    private int vacantSpots;

    /**
     * Cost for a parking ticket.
     */
    private float cost;

    /**
     * Indicates if the parking lot is active or not.
     */
    private boolean active;

    /**
     * Ticket tracker object to track the tickets of the current parking lot.
     */
    TicketTracker ticketTracker;

    /**
     * Object to track the tickets associated with the parking lot.
     */
    GateTracker gateTracker;

    /**
     * Constructor to create a new parking lot object.
     * @param name Title to identify the parking lot.
     * @param capacity Maximum capacity of the parking lot.
     * @param vacantSpots Number of vacant spots.
     * @param cost Cost of the parking lot.
     * @param fine Cost of the fines for the parking lot.
     * @param active Boolean flag to indicate if parking lot is active or not.
     */
    public ParkingLot(String name, int capacity, int vacantSpots, float cost, float fine, boolean active) {
        this.name = name;
        this.capacity = capacity;
        this.vacantSpots = vacantSpots;
        this.cost = cost;
        this.active = active;
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

    public int getVacantSpots() {
        return vacantSpots;
    }

    public void setVacantSpots(int vacantSpots) {
        this.vacantSpots = vacantSpots;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
