package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.objects.Ticket;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OpenCloseTicketsClosePay extends StateNode {
    private List<Ticket> ticketsList;
    private Ticket activeTicket;

    public OpenCloseTicketsClosePay(String transitionCommand, List<Ticket> ticketsList, int ticketIndex) {
        super();
        this.ticketsList = ticketsList;
        this.activeTicket = ticketsList.get(ticketIndex);
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        System.out.println(
            "Amount due: " + this.activeTicket.getAmountDue() + "\n" +
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
                    /*
                    BufferedWriter writer = new BufferedWriter(new FileWriter("parking-data/tickets/inactive.csv", true));
                    writer.newLine();
                    writer.write(
                    activeTicket.getLicensePlateNumber() + "," +
                        activeTicket.getGateEnter() + "," +
                        activeTicket.getGateExit() + "," +
                        activeTicket.getAmountDue()
                    );
                    writer.close();
                    */

                    System.out.println("----- Receipt -----");
                    activeTicket.printInfo();

                } catch (Exception e) {
                    System.out.println("Error: Unable to write to file.");
                }

                this.nextNode = new OpenCloseTicketsMainMenu("");
                valid = true;
            } else if (userInput.equals("n")) {
                this.nextNode = new OpenCloseTicketsMainMenu("");
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
