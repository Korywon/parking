package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;

public class OpenCloseTicketsOpen extends StateNode {
    public OpenCloseTicketsOpen(String transitionCommand) {
        super(transitionCommand);
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        System.out.println("==== Open Ticket =====");
        // TODO: Build menu using parking lots.
        System.out.println("[ c ]" + "\t" + "Cancel");


        // TODO: Implement open parking lot state.

        boolean valid = true;
        do {
            String userInput = this.commandListener.promptForInput("Enter command: ");

            if (userInput.equals("c")) {
                this.nextNode = new OpenCloseTicketsMainMenu("");
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
