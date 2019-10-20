package com.github.korywon.parking.controller;

import com.github.korywon.parking.objects.Ticket;
import com.github.korywon.parking.utility.parsers.Parser;
import com.github.korywon.parking.utility.parsers.ParserParkingLot;
import com.github.korywon.parking.utility.parsers.ParserTicket;

import java.util.List;

public class App {
    public static void main(String[] args) {
        ParserTicket ticketParser = new ParserTicket("active.csv");
        List<Ticket> ticketList = ticketParser.getTicketList();

        for (Ticket ticket : ticketList) {
            ticket.printInfo();
        }


        System.out.println("Beginning application launch...");
        // creates a new controller
        MainController controller = new MainController();
        // initializes the controller
        controller.init();
        // starts the controller
        controller.start();
    }
}
