package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.objects.Ticket;
import com.github.korywon.parking.utility.parsers.ParserTicket;

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

        String userInput = this.commandListener.promptForInput("Enter car's license plate number: ");

        // TODO: Search for ticket. If found, move to ClosePay state.
        ParserTicket ticketParser = new ParserTicket("parking-data/tickets/active.csv");
        List<Ticket> ticketsList = ticketParser.getTicketList();
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
