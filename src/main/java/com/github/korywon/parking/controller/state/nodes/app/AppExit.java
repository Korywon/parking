package com.github.korywon.parking.controller.state.nodes.app;

import com.github.korywon.parking.controller.state.StateNode;

public class AppExit extends StateNode {
    private String transitionCommand;

    public AppExit(String transitionCommand) {
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
