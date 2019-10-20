package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.objects.Gate;
import com.github.korywon.parking.objects.ParkingLot;
import com.github.korywon.parking.objects.Ticket;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OpenCloseTicketsOpenAt extends StateNode {
    private ParkingLot parkingLot;

    public OpenCloseTicketsOpenAt(String transitionCommand, ParkingLot parkingLot) {
        super(transitionCommand);
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
        System.out.println("===== " + parkingLot.getName() + " - Open New Ticket =====");


        Ticket newTicket = new Ticket();
        String userInput;

        userInput = this.commandListener.promptForInput("Enter license plate number: ");
        newTicket.setLicensePlateNumber(userInput);

        // TODO: Search for license plate number in active.csv

        List<Gate> enterGates = parkingLot.getGatesEnter();
        for (int i = 0; i < enterGates.size(); i++) {
            System.out.println("[ " + (i+1) + " ]" + "\t" + enterGates.get(i).getName());
        }

        userInput = this.commandListener.promptForInput("Select gate: ");

        boolean valid = false;
        while (!valid) {
            try {
                int userNumber = Integer.parseInt(userInput) - 1;
                if (userNumber >= 0 && userNumber < enterGates.size()) {
                    newTicket.setGateEnter(enterGates.get(userNumber));
                    valid = true;
                }
            } catch (Exception e) {
                System.out.println("Invalid gate. Try again.");
            }
        }

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        newTicket.setTimeEnter(formatter.format(date));
        newTicket.setGateExit(new Gate("exit", ""));
        newTicket.setTimeClose("");

        newTicket.setAmountDue(this.parkingLot.getPrice());

        System.out.println("----- Receipt -----");
        newTicket.printInfo();
        System.out.println("Note: Amount due will be charged when you exit the parking lot.");

        // TODO: Save ticket to file.

        this.nextNode = new OpenCloseTicketsOpen("");
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
