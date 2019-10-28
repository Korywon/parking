package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.objects.Group;
import com.github.korywon.parking.objects.ParkingLot;
import com.github.korywon.parking.objects.Ticket;
import com.github.korywon.parking.utility.WriterDatabase;
import com.github.korywon.parking.utility.parsers.ParserDatabase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OpenCloseTicketsClosePay extends StateNode {
    List<Group> groupList;
    List<ParkingLot> parkingLotList;
    List<Ticket> ticketList;
    private int ticketIndex;

    public OpenCloseTicketsClosePay(int ticketIndex) {
        super();
        this.ticketIndex = ticketIndex;
    }

    @Override
    public void init() {
        ParserDatabase dbParser = new ParserDatabase("parking-data/parking-database.txt");
        groupList = dbParser.getGroupList();
        parkingLotList = dbParser.getParkingLotList();
        ticketList = dbParser.getTicketList();
    }

    @Override
    public void start() {
        // sets active ticket for local scope
        Ticket activeTicket = ticketList.get(ticketIndex);

        // prints UI
        System.out.println(
            "Amount due: " + activeTicket.getAmountDue() + "\n" +
            "\"" + activeTicket.getLicensePlateNumber() + "\" -- Pay and close ticket now?" + "\n" +
            "[ y ]" + "\t" + "Yes" + "\n" +
            "[ n ]" + "\t" + "No"
        );

        // validity input loop
        boolean valid = false;
        while (!valid) {
            // waits for command input from user
            String userInput = this.commandListener.promptForInput("Enter command: ");

            if (userInput.equals("y")) {
                // attempts to find parking lot name to set gate exit
                boolean found = false;
                for (ParkingLot parkingLot : parkingLotList) {
                    if (parkingLot.getParkingLotName().equals(activeTicket.getParkingLotName())) {
                        found = true;
                        activeTicket.setGateExit(parkingLot.getGateExit());
                    }
                }

                // if parking lot is not found, set gate exit to SYSTEM by default
                if (!found) {
                    System.out.println("Warning: Unable to find parking lot " + activeTicket.getParkingLotName() + ". "
                        + "Setting gate exit to SYSTEM.");
                    ticketList.get(ticketIndex).setGateExit("SYSTEM");
                }

                // rewrites list to the database file
                try {
                    WriterDatabase.writeToDatabase(groupList, parkingLotList, ticketList);

                    System.out.println("----- Receipt -----");
                    activeTicket.printInfo();

                } catch (Exception e) {
                    System.out.println("Error: Unable to write to file.");
                }

                this.nextNode = new OpenCloseTicketsMainMenu();
                valid = true;
            } else if (userInput.equals("n")) {
                this.nextNode = new OpenCloseTicketsMainMenu();
                valid = true;
            } else {
                System.out.println("Invalid command. Please try again.");
                valid = false;
            }
        }
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
