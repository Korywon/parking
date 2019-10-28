package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.objects.Ticket;
import com.github.korywon.parking.utility.parsers.ParserDatabase;

import java.util.List;

public class OpenCloseTicketsClose extends StateNode {
    public OpenCloseTicketsClose(String transitionCommand) {
        super();
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        System.out.println("===== Close Ticket =====");

        // asks user for license plate number input
        String userInput = this.commandListener.promptForInput("Enter car's license plate number: ");

        // attempts to find an existing ticket with the user's ticket
        ParserDatabase dbParser = new ParserDatabase("parking-data/parking-database.txt");
        List<Ticket> ticketsList = dbParser.getTicketList();
        for (int i = 0; i < ticketsList.size(); i++) {
            if (ticketsList.get(i).getLicensePlateNumber().equals(userInput)) {
                System.out.println("\""+ userInput + "\" has an active ticket.");
                this.nextNode = new OpenCloseTicketsClosePay("", ticketsList, i);
                return;
            }
        }

        System.out.println("Unable to find ticket with license plate number: " + userInput);
        this.nextNode = new OpenCloseTicketsMainMenu("");
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
