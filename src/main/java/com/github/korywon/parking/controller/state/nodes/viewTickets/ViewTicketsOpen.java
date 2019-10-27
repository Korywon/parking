package com.github.korywon.parking.controller.state.nodes.viewTickets;

import com.github.korywon.parking.controller.state.StateNode;

public class ViewTicketsOpen extends StateNode {
    public ViewTicketsOpen(String transitionCommand) {
        super();
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {

    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
