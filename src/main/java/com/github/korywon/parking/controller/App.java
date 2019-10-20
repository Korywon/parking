package com.github.korywon.parking.controller;

import com.github.korywon.parking.objects.Ticket;
import com.github.korywon.parking.utility.parsers.Parser;
import com.github.korywon.parking.utility.parsers.ParserParkingLot;
import com.github.korywon.parking.utility.parsers.ParserTicket;

import java.util.List;

public class App {
    public static void main(String[] args) {
        System.out.println("Beginning application launch...");
        // creates a new controller
        MainController controller = new MainController();
        // initializes the controller
        controller.init();
        // starts the controller
        controller.start();
    }
}
