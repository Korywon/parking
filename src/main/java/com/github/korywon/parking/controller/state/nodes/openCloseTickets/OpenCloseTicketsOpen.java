package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;

public class OpenCloseTicketsOpen extends StateNode {
    public OpenCloseTicketsOpen(String transitionCommand) {
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
