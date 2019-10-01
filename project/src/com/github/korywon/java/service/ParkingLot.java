package com.github.korywon.java.service;

import com.github.korywon.java.trackers.TicketTracker;

/**
 * Parking lot object to track each instance of a parking lot.
 */
public class ParkingLot {
    /**
     * Title to identify the parking lot.
     */
    private String title;

    /**
     * Maximum capacity of the parking lot.
     */
    private int capacity;

    /**
     * Current number of vacant spots of the parking lot.
     */
    private int vacantSpots;

    /**
     * Cost of the parking.
     */
    private float cost;

    /**
     * Cost of the fine for having an expired ticket.
     */
    private float fine;

    /**
     * Indicates if the parking lot is active or not.
     */
    private boolean active;

    /**
     * Ticket tracker object to track the tickets of the current parking lot.
     */
    TicketTracker ticketTracker;


    /**
     * Constructor to create a new parking lot object.
     * @param title Title to identify the parking lot.
     * @param capacity Maximum capacity of the parking lot.
     * @param vacantSpots Number of vacant spots.
     * @param cost Cost of the parking lot.
     * @param fine Cost of the fines for the parking lot.
     * @param active Boolean flag to indicate if parking lot is active or not.
     */
    public ParkingLot(String title, int capacity, int vacantSpots, float cost, float fine, boolean active) {
        this.title = title;
        this.capacity = capacity;
        this.vacantSpots = vacantSpots;
        this.cost = cost;
        this.fine = fine;
        this.active = active;
    }
}
