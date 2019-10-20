package com.github.korywon.parking.controller.state.nodes.viewTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.controller.state.nodes.app.AppMainMenu;

public class ViewTicketsMainMenu extends StateNode {
    public ViewTicketsMainMenu(String transitionCommand) {
        super(transitionCommand);
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        System.out.println("===== View Tickets Main Menu =====");
        // TODO: Build menu options by printing parking lots from file.
        System.out.println(
            "[ a ]" + "\t" + "View ALL tickets" + "\n" +
            "[ c ]" + "\t" + "Cancel"
        );

        // TODO: Implement view ticket name state.
        // TODO: Implement all open tickets state.

        boolean valid = true;
        do {
            String userInput = this.commandListener.promptForInput("Enter command: ");

            if (userInput.equals("c")) {
                this.nextNode = new AppMainMenu("");
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
}
