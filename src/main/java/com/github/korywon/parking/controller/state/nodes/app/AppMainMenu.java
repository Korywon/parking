package com.github.korywon.parking.controller.state.nodes.app;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.controller.state.nodes.openCloseTickets.OpenCloseTicketsMainMenu;
import com.github.korywon.parking.controller.state.nodes.viewParkingLots.ViewParkingLotsMainMenu;
import com.github.korywon.parking.controller.state.nodes.viewTickets.ViewTicketsMainMenu;

import java.util.List;

public class AppMainMenu extends StateNode {
    private String transitionCommand;

    public AppMainMenu(String transitionCommand) {
        super(transitionCommand);
        this.transitionNodes.add(new OpenCloseTicketsMainMenu("1"));
        this.transitionNodes.add(new ViewTicketsMainMenu("2"));
        this.transitionNodes.add(new ViewParkingLotsMainMenu("3"));
        this.transitionNodes.add(new AppMainMenu("X"));
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        System.out.println(
            "===== Parking Application =====" + "\n" +
            "[ 1 ]" + "\t" + "Open/Close Tickets" + "\n" +
            "[ 2 ]" + "\t" + "View Tickets" + "\n" +
            "[ 3 ]" + "\t" + "View Parking Lots" + "\n" +
            "[ X ]" + "\t" + "Exit System"
        );

        String userInput = this.commandListener.promptForInput("Enter command: ");
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }

    public String getTransitionCommand() {
        return transitionCommand;
    }

    public void setTransitionCommand(String transitionCommand) {
        this.transitionCommand = transitionCommand;
    }
}
