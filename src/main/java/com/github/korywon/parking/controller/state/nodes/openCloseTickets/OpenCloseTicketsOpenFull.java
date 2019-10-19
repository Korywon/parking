package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;

public class OpenCloseTicketsOpenFull extends StateNode {
    public OpenCloseTicketsOpenFull(String transitionCommand) {
        super(transitionCommand);
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {

    }

    @Override
    public StateNode exit() {
        return null;
    }
}
