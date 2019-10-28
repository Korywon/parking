package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.objects.Gate;
import com.github.korywon.parking.objects.ParkingLot;
import com.github.korywon.parking.objects.Ticket;
import com.github.korywon.parking.utility.parsers.ParserDatabase;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OpenCloseTicketsOpenAt extends StateNode {
    private ParkingLot parkingLot;

    public OpenCloseTicketsOpenAt(String transitionCommand, ParkingLot parkingLot) {
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

    }

    @Override
    public void start() {
        System.out.println("===== " + parkingLot.getParkingLotName() + " - Open New Ticket =====");

        // creates a new ticket
        Ticket newTicket = new Ticket();
        String userInput;

        // prompts user for license plate number input
        userInput = this.commandListener.promptForInput("Enter license plate number: ");
        newTicket.setLicensePlateNumber(userInput);

        // attempts to find an existing ticket
        ParserDatabase dbParser = new ParserDatabase("/parking-data/parking-database.txt");
        List<Ticket> ticketsList = dbParser.getTicketList();
        for (int i = 0; i < ticketsList.size(); i++) {
            if (ticketsList.get(i).getLicensePlateNumber().equals(userInput)) {
                System.out.println("\""+ userInput + "\" has an active ticket. Active ticket must be closed before opening a new one.");
                this.nextNode = new OpenCloseTicketsClosePay("", ticketsList, i);
                return;
            }
        }

        // sets exit gate and exit amount
        newTicket.setParkingLotName(this.parkingLot.getParkingLotName());
        newTicket.setGateEnter(this.parkingLot.getGateEnter());
        newTicket.setAmountDue(this.parkingLot.getPrice());

        // writes new ticket to the file using
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("parking-data/parking-database.txt", true));
            writer.newLine();
            writer.write(
                newTicket.getLicensePlateNumber() + "," +
                newTicket.getGateEnter() + "," +
                newTicket.getGateExit() + "," +
                newTicket.getAmountDue()
            );
            writer.close();

            System.out.println("----- Receipt -----");
            newTicket.printInfo();
            System.out.println("Note: Amount due will be charged when you exit the parking lot.");

        } catch (Exception e) {
            System.out.println("Error: Unable to write to file.");
        }

        this.nextNode = new OpenCloseTicketsOpen("");
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
