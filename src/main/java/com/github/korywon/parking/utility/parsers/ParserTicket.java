package com.github.korywon.parking.utility.parsers;

import com.github.korywon.parking.objects.Gate;
import com.github.korywon.parking.objects.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ParserTicket extends Parser {
    private List<Ticket> ticketList;

    public ParserTicket(String path) {
        super(path);
        this.ticketList = this.parseTickets();
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    private List<Ticket> parseTickets() {
        List<Ticket> tickets = new ArrayList<Ticket>();

        int lineNumber = 1;
        String line;
        while ((line = this.readFileLine()) != null) {
            Ticket ticketEntry = this.parseTicketLine(line);
            if (ticketEntry != null) {
                tickets.add(ticketEntry);
            } else {
                System.out.println("Error: (" + this.path + ") Ticket entry invalid at line " + lineNumber);
            }

            lineNumber++;
        }

        return tickets;
    }

    private Ticket parseTicketLine(String line) {
        Ticket newTicket = new Ticket();
        String[] splitLine = line.split(",");

        if (splitLine.length == 6) {
            newTicket.setLicensePlateNumber(splitLine[0]);
            newTicket.setGateEnter(new Gate("enter", splitLine[1]));
            newTicket.setTimeEnter(splitLine[2]);
            newTicket.setGateExit(new Gate("exit", splitLine[3]));
            newTicket.setTimeClose(splitLine[4]);
            try {
                newTicket.setAmountDue(Float.parseFloat(splitLine[5]));
            } catch (Exception e) {
                System.out.println("Error: Unable to convert " + splitLine[5] + " to float.");
            }
            return newTicket;
        } else {
            System.out.println("Error: Skipping " + line);
            return null;
        }
    }
}
