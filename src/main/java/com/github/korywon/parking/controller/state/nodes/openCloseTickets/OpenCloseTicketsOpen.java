package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.objects.ParkingLot;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OpenCloseTicketsOpen extends StateNode {
    public List<ParkingLot> parkingLots;

    public OpenCloseTicketsOpen(String transitionCommand) {
        super();
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
        System.out.println(
            "==== Open Ticket =====" + "\n" +
            "Please select a parking lot to open a ticket to."
        );

        for (int i = 0; i < this.parkingLots.size(); i++) {
            System.out.println(
                "[ " + (i+1) + " ]" + "\t" + this.parkingLots.get(i).getName()
            );
        }

        System.out.println("[ c ]" + "\t" + "Cancel");

        boolean valid = true;
        do {
            String userInput = this.commandListener.promptForInput("Enter command: ");

            if (userInput.equals("c")) {
                this.nextNode = new OpenCloseTicketsMainMenu("");
                valid = true;
            } else if (NumberUtils.isCreatable(userInput)) {
                try {
                    int userNumber = Integer.parseInt(userInput) - 1;
                    if (userNumber >= 0 && userNumber < parkingLots.size()) {
                        this.nextNode = new OpenCloseTicketsOpenAt("", this.parkingLots.get(userNumber));
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
