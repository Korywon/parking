package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.controller.state.nodes.app.AppMainMenu;

public class OpenCloseTicketsMainMenu extends StateNode {
    public OpenCloseTicketsMainMenu(String transitionCommand) {
        super(transitionCommand);
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        System.out.println(
            "===== Open/Close Tickets =====" + "\n" +
            "[ 1 ]" + "\t" + "Open Tickets" + "\n" +
            "[ 2 ]" + "\t" + "Close Tickets" + "\n" +
            "[ c ]" + "\t" + "Cancel"
        );

        boolean valid = true;
        do {
            String userInput = this.commandListener.promptForInput("Enter command: ");

            if (userInput.equals("1")) {
                this.nextNode = new OpenCloseTicketsOpen("");
                valid = true;
            }
            else if (userInput.equals("2")) {
                this.nextNode = new OpenCloseTicketsClose("");
                valid = true;
            }
            else if (userInput.equals("c")) {
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
