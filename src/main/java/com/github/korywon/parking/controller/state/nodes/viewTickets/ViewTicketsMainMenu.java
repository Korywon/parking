package com.github.korywon.parking.controller.state.nodes.viewTickets;

import com.github.korywon.parking.controller.state.StateNode;

public class ViewTicketsMainMenu extends StateNode {
    public ViewTicketsMainMenu(String transitionCommand) {
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
        return this.nextNode;
    }
}
