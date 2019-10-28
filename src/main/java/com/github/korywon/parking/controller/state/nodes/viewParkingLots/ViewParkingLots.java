package com.github.korywon.parking.controller.state.nodes.viewParkingLots;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.controller.state.nodes.app.AppMainMenu;
import com.github.korywon.parking.objects.ParkingLot;
import com.github.korywon.parking.objects.Ticket;
import com.github.korywon.parking.utility.parsers.ParserDatabase;

import java.util.List;

public class ViewParkingLots extends StateNode {
    private List<ParkingLot> parkingLotList;
    private List<Ticket> ticketList;

    @Override
    public void init() {
        ParserDatabase dbParser = new ParserDatabase("parking-data/parking-database.txt");
        parkingLotList = dbParser.getParkingLotList();
        ticketList = dbParser.getTicketList();
    }

    @Override
    public void start() {
        for (ParkingLot parkingLot : parkingLotList) {
            parkingLot.printInfo();
            int ticketCount = 0;
            for (Ticket ticket : ticketList) {
                if (
                    ticket.getParkingLotName().equals(parkingLot.getParkingLotName()) &&
                    "".equals(ticket.getGateExit())
                ) {
                    ticketCount++;
                }
            }
            System.out.println("Number of parking spaces available: " + (parkingLot.getCapacity()-ticketCount) + "\n");
        }

        this.nextNode = new AppMainMenu();
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
