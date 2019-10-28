package com.github.korywon.parking.controller.state.nodes.app;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.controller.state.nodes.openCloseTickets.OpenCloseTicketsMainMenu;
import com.github.korywon.parking.controller.state.nodes.viewGroups.ViewGroups;
import com.github.korywon.parking.controller.state.nodes.viewParkingLots.ViewParkingLots;

public class AppMainMenu extends StateNode {
    private String transitionCommand;

    public AppMainMenu() {
        super();
    }

    @Override
    public void init() { }

    @Override
    public void start() {
        System.out.println(
            "===== Parking Application =====" + "\n" +
            "[ 1 ]" + "\t" + "Open/Close Tickets" + "\n" +
            "[ 2 ]" + "\t" + "View Parking Lots" + "\n" +
            "[ 3 ]" + "\t" + "View Groups" + "\n" +
            "[ x ]" + "\t" + "Exit System"
        );

        while(true) {
            String userInput = this.commandListener.promptForInput("Enter command: ");

            switch (userInput) {
                case "1":
                    this.nextNode = new OpenCloseTicketsMainMenu();
                    return;
                case "2":
                    this.nextNode = new ViewParkingLots();
                    return;
                case "3":
                    this.nextNode = new ViewGroups();
                    return;
                case "x":
                    this.nextNode = new AppExit();
                    return;
                default:
                    System.out.println("Invalid command. Try again.");
                    break;
            }
        }
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
