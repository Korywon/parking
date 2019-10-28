package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.objects.Gate;
import com.github.korywon.parking.objects.ParkingLot;
import com.github.korywon.parking.objects.Ticket;
import com.github.korywon.parking.utility.parsers.Parser;
import com.github.korywon.parking.utility.parsers.ParserDatabase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OpenCloseTicketsOpenAt extends StateNode {
    private ParkingLot parkingLot;
    private List<Ticket> ticketList;

    public OpenCloseTicketsOpenAt(ParkingLot parkingLot) {
        super();
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    @Override
    public void init() {
        // parses the database file and gets the ticket list
        ParserDatabase dbParser = new ParserDatabase("parking-data/parking-database.txt");
        ticketList = dbParser.getTicketList();
    }

    @Override
    public void start() {
        int availableSpace = ParkingLot.getLowestAvailableSpace(this.parkingLot, this.ticketList);
        if (availableSpace == -1) {
            System.out.println(this.parkingLot.getParkingLotName() + " has no available spaces.");
            this.nextNode = new OpenCloseTicketsOpen();
            return;
        }

        System.out.println("===== " + parkingLot.getParkingLotName() + " - Open New Ticket =====");

        // creates a new ticket
        Ticket newTicket = new Ticket();
        String userInput;

        // prompts user for license plate number input
        userInput = this.commandListener.promptForInput("Enter license plate number: ");
        newTicket.setLicensePlateNumber(userInput);

        // attempts to find an existing ticket
        ParserDatabase dbParser = new ParserDatabase("parking-data/parking-database.txt");
        List<Ticket> ticketsList = dbParser.getTicketList();
        for (int i = 0; i < ticketsList.size(); i++) {
            // if license plate found and gate exit is an empty string
            if (
                ticketsList.get(i).getLicensePlateNumber().equals(userInput) &&
                "".equals(ticketsList.get(i).getGateExit())
            ) {
                System.out.println("\""+ userInput + "\" has an active ticket. Active ticket must be closed before opening a new one.");
                this.nextNode = new OpenCloseTicketsClosePay(i);
                return;
            }
        }

        // sets exit gate and exit amount
        newTicket.setParkingLotName(this.parkingLot.getParkingLotName());
        newTicket.setGroupName(this.parkingLot.getGroupName());
        newTicket.setGateEnter(this.parkingLot.getGateEnter());
        newTicket.setParkingSpace(availableSpace);
        newTicket.setAmountDue(this.parkingLot.getPrice());

        // writes new ticket to the file using
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("parking-data/parking-database.txt", true));
            writer.newLine();
            writer.write(
                "Ticket" + "," +
                newTicket.getLicensePlateNumber() + "," +
                newTicket.getParkingLotName() + "," +
                newTicket.getGroupName() + "," +
                newTicket.getParkingSpace() + "," +
                newTicket.getGateEnter() + "," +
                newTicket.getGateExit() + "," +
                newTicket.getAmountDue()
            );
            writer.close();

            newTicket.printInfo();
            System.out.println("Note: Amount due will be charged when you exit the parking lot.");

        } catch (Exception e) {
            System.out.println("Error: Unable to write to file.");
        }

        this.nextNode = new OpenCloseTicketsOpen();
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
