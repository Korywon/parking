package com.github.korywon.parking.controller;

import com.github.korywon.parking.controller.state.StateMachine;
import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.controller.state.nodes.app.AppMainMenu;
import com.github.korywon.parking.objects.*;

import java.util.List;

/**
 * Holds the main loop for the console application.
 */
public class MainController {
    StateMachine stateMachine;
    List<ParkingLot> parkingLotList;
    List<Car> carList;
    List<Ticket> ticketList;

    /**
     * Boolean flag that indicates that initialization was successful.
     */
    private boolean initSuccess;

    /**
     * TODO: Load parking lots list.
     * TODO: Load tickets list.
     * TODO: Parse parking lots, cars, and tickets.
     */
    void init() {
        System.out.println("Initializing application...");
        initSuccess = true;
    }

    void start() {
        if (initSuccess) {
            System.out.println("Starting application...");

            StateNode currentState = new AppMainMenu("");
        }
    }
}
