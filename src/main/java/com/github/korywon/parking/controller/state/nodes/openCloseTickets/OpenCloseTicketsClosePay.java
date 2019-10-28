package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.objects.Group;
import com.github.korywon.parking.objects.ParkingLot;
import com.github.korywon.parking.objects.Ticket;
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
        Ticket activeTicket = ticketList.get(ticketIndex);

        System.out.println(
            "Amount due: " + activeTicket.getAmountDue() + "\n" +
            "\"" + activeTicket.getLicensePlateNumber() + "\" -- Pay and close ticket now?" + "\n" +
            "[ y ]" + "\t" + "Yes" + "\n" +
            "[ n ]" + "\t" + "No"
        );


        boolean valid = false;
        while (!valid) {
            String userInput = this.commandListener.promptForInput("Enter command: ");

            if (userInput.equals("y")) {
                activeTicket.setGateExit("");

                // Appends ticket to inactive.csv
                try {

                    BufferedWriter writer = new BufferedWriter(new FileWriter("parking-data/parking-database.txt"));

                    writer.write(
                    activeTicket.getLicensePlateNumber() + "," +
                        activeTicket.getGateEnter() + "," +
                        activeTicket.getGateExit() + "," +
                        activeTicket.getAmountDue()
                    );
                    writer.close();

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
