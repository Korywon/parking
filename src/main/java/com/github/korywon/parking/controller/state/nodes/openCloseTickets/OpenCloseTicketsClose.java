package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;

public class OpenCloseTicketsClose extends StateNode {
    public OpenCloseTicketsClose(String transitionCommand) {
        super(transitionCommand);
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        System.out.println("===== Close Ticket =====");

        String userInput = this.commandListener.promptForInput("Enter car's license plate number: ");

        // TODO: Search for ticket. If found, move to ClosePay state.

        System.out.println("Unable to find ticket with license plate number: " + userInput);
        this.nextNode = new OpenCloseTicketsMainMenu("");
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
