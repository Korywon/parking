package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.objects.ParkingLot;
import com.github.korywon.parking.utility.parsers.ParserDatabase;
import org.apache.commons.lang3.math.NumberUtils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class OpenCloseTicketsOpen extends StateNode {
    public List<ParkingLot> parkingLots;

    public OpenCloseTicketsOpen() {
        super();
    }

    @Override
    public void init() {
        // creates parser to parse parking database
        ParserDatabase dbParser = new ParserDatabase("parking-data/parking-database.txt");
        // Attempts to grab parking lot data
        parkingLots = dbParser.getParkingLotList();
    }

    @Override
    public void start() {
        System.out.println(
            "==== Open Ticket =====" + "\n" +
            "Please select a parking lot to open a ticket to."
        );

        for (int i = 0; i < this.parkingLots.size(); i++) {
            System.out.println(
                "[ " + (i+1) + " ]" + "\t" + this.parkingLots.get(i).getParkingLotName()
            );
        }

        System.out.println("[ c ]" + "\t" + "Cancel");

        boolean valid = true;
        do {
            String userInput = this.commandListener.promptForInput("Enter command: ");

            if (userInput.equals("c")) {
                this.nextNode = new OpenCloseTicketsMainMenu();
                valid = true;
            }
            else if (NumberUtils.isCreatable(userInput)) {
                try {
                    int userNumber = Integer.parseInt(userInput) - 1;
                    if (userNumber >= 0 && userNumber < parkingLots.size()) {
                        this.nextNode = new OpenCloseTicketsOpenAt(this.parkingLots.get(userNumber));
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
