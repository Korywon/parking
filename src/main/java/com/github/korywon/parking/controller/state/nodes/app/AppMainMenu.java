package com.github.korywon.parking.controller.state.nodes.app;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.controller.state.nodes.openCloseTickets.OpenCloseTicketsMainMenu;

public class AppMainMenu extends StateNode {
    private String transitionCommand;

    public AppMainMenu(String transitionCommand) {
        super();
    }

    @Override
    public void init() {
    }

    @Override
    public void start() {
        System.out.println(
            "===== Parking Application =====" + "\n" +
            "[ 1 ]" + "\t" + "Open/Close Tickets" + "\n" +
            "[ x ]" + "\t" + "Exit System"
        );

        while(true) {
            String userInput = this.commandListener.promptForInput("Enter command: ");

            if (userInput.equals("1")) {
                this.nextNode = new OpenCloseTicketsMainMenu("");
                return;
            }
            else if (userInput.equals("x")) {
                this.nextNode = new AppExit("");
                return;
            }
            else {
                System.out.println("Invalid command. Try again.");
            }

        }
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
