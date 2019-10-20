package com.github.korywon.parking.controller.state.nodes.viewParkingLots;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.controller.state.nodes.app.AppMainMenu;

public class ViewParkingLotsMainMenu extends StateNode {
    public ViewParkingLotsMainMenu(String transitionCommand) {
        super(transitionCommand);
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        System.out.println("===== View Parking Lots Main Menu =====");
        // TODO: Build menu options by printing parking lots from file
        System.out.println(
            "[ a ]" + "\t" + "Add new parking lot" + "\n" +
            "[ c ]" + "\t" + "Cancel"
        );


        // TODO: View parking lot name state.
        // TODO: Implement add new parking lot state.
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
