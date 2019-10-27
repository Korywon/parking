package com.github.korywon.parking.controller.state.nodes.viewTickets;

import com.github.korywon.parking.controller.state.StateNode;

public class ViewTicketsType extends StateNode {
    public ViewTicketsType(String transitionCommand) {
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
