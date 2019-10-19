package com.github.korywon.parking.controller.state.nodes.viewParkingLots;

import com.github.korywon.parking.controller.state.StateNode;

public class ViewParkingLotsMainMenu extends StateNode {
    public ViewParkingLotsMainMenu(String transitionCommand) {
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
