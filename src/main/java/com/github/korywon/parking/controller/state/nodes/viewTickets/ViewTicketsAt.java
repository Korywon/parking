package com.github.korywon.parking.controller.state.nodes.viewTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.objects.ParkingLot;

public class ViewTicketsAt extends StateNode {
    private ParkingLot parkingLot;

    public ViewTicketsAt(String transitionCommand, ParkingLot parkingLot) {
        super();
        this.parkingLot = parkingLot;
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        // TODO: Implement start fo view tickets at

        this.nextNode = new ViewTicketsMainMenu("");
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
