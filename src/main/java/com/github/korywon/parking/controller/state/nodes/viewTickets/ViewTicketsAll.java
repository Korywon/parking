package com.github.korywon.parking.controller.state.nodes.viewTickets;

import com.github.korywon.parking.controller.state.StateNode;

public class ViewTicketsAll extends StateNode {
    public ViewTicketsAll(String transitionCommand) {
        super();
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        // TODO: Implement start for view all tickets

        this.nextNode = new ViewTicketsMainMenu("");
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
