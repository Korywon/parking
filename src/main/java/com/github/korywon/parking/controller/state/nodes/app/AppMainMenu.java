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
            "[ x ]" + "\t" + "Exit System"
        );

        boolean valid = true;
        do {
            String userInput = this.commandListener.promptForInput("Enter command: ");

            if (userInput.equals("1")) {
                this.nextNode = new OpenCloseTicketsMainMenu("");
                valid = true;
            }
            else if (userInput.equals("2")) {
                this.nextNode = new ViewTicketsMainMenu("");
                valid = true;
            }
            else if (userInput.equals("3")) {
                this.nextNode = new ViewParkingLotsMainMenu("");
                valid = true;
            }
            else if (userInput.equals("x")) {
                this.nextNode = new AppExit("");
                valid = true;
            }
            else {
                System.out.println("Invalid command. Try again.");
                valid = false;
            }

        } while(!valid);
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
