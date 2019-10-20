package com.github.korywon.parking.controller;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.controller.state.nodes.app.AppMainMenu;
import com.github.korywon.parking.objects.*;

import java.util.List;

/**
 * Holds the main loop for the console application.
 */
public class MainController {
    List<ParkingLot> parkingLotList;
    List<Car> carList;
    List<Ticket> openTickets;
    List<Ticket> closedTickets;

    /**
     * Boolean flag that indicates that initialization was successful.
     */
    private boolean initSuccess;

    void init() {
        System.out.println("Initializing application...");
        initSuccess = true;
    }

    void start() {
        if (initSuccess) {
            System.out.println("Starting application...");

            StateNode currentState = new AppMainMenu("");
            do {
                currentState = currentState.launch();
            } while(currentState != null);

            System.out.println("Application loop terminated.");
        }
    }
}
