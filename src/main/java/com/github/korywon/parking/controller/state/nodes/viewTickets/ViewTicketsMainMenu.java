package com.github.korywon.parking.controller.state.nodes.viewTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.controller.state.nodes.app.AppMainMenu;
import com.github.korywon.parking.controller.state.nodes.openCloseTickets.OpenCloseTicketsMainMenu;
import com.github.korywon.parking.controller.state.nodes.openCloseTickets.OpenCloseTicketsOpenAt;
import com.github.korywon.parking.objects.ParkingLot;
import com.github.korywon.parking.utility.parsers.ParserParkingLot;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ViewTicketsMainMenu extends StateNode {
    List<ParkingLot> parkingLots;

    public ViewTicketsMainMenu(String transitionCommand) {
        super(transitionCommand);
    }

    @Override
    public void init() {
        // Attempts to grab parking lot data
        parkingLots = new ArrayList<ParkingLot>();
        File parkingDataParkingLots = new File("parking-data/parking-lots/");
        if (parkingDataParkingLots.exists()) {
            String[] filesList = parkingDataParkingLots.list();
            assert filesList != null;
            if (filesList.length > 0) {
                for (int i = 0; i < filesList.length; i++) {
                    ParserParkingLot parkingLotParser = new ParserParkingLot("parking-data/parking-lots/" + filesList[i]);
                    ParkingLot parkingLot = parkingLotParser.getParkingLot();
                    parkingLots.add(parkingLot);
                }

            } else {
                System.out.println("Warning: No data found for parking lots...");
            }
        } else {
            System.out.println("Warning: No data found for parking lots...");
        }
    }

    @Override
    public void start() {
        System.out.println("===== View Tickets Main Menu =====");

        for (int i = 0; i < this.parkingLots.size(); i++) {
            System.out.println(
                "[ " + (i+1) + " ]" + "\t" + this.parkingLots.get(i).getName()
            );
        }

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
                this.nextNode = new ViewTicketsMainMenu("");
                valid = true;
            }
            else if (userInput.equals("a")) {
                this.nextNode = new ViewTicketsAll("");
            }
            else if (NumberUtils.isCreatable(userInput)) {
                try {
                    int userNumber = Integer.parseInt(userInput) - 1;
                    if (userNumber >= 0 && userNumber < parkingLots.size()) {
                        this.nextNode = new ViewTicketsAt("", this.parkingLots.get(userNumber));
                        valid = true;
                    }
                } catch (Exception e) {
                    System.out.println("Invalid command. Try again.");
                    valid = false;
                }
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
