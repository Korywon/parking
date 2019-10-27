package com.github.korywon.parking.controller.state.nodes.app;

import com.github.korywon.parking.controller.state.StateNode;

public class AppExit extends StateNode {
    private String transitionCommand;

    public AppExit(String transitionCommand) {
        super();
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        System.out.println("Exiting system...");
        this.nextNode = null;
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
