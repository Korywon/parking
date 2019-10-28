package com.github.korywon.parking.utility;

import com.github.korywon.parking.objects.Group;
import com.github.korywon.parking.objects.ParkingLot;
import com.github.korywon.parking.objects.Ticket;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.List;

public class WriterDatabase {
    public static void writeToDatabase(List<Group> groupList, List<ParkingLot> parkingLotList, List<Ticket> ticketList) {

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("parking-data/parking-database.txt"));

            for (Group group : groupList) {
                writer.write(
                    "Group" + "," +
                    group.getGroupName() + "," +
                    group.getGroupPrice()
                );
                writer.newLine();
            }
            for (ParkingLot parkingLot : parkingLotList) {
                writer.write(
                    "ParkingLot" + "," +
                    parkingLot.getParkingLotName() + "," +
                    parkingLot.getGroupName() + "," +
                    parkingLot.getCapacity() + "," +
                    parkingLot.getGateEnter() + "," +
                    parkingLot.getGateExit() + "," +
                    parkingLot.getParkingLotPrice()
                );
                writer.newLine();
            }
            for (Ticket ticket : ticketList) {
                writer.write(
                "Ticket" + "," +
                    ticket.getLicensePlateNumber() + "," +
                    ticket.getGroupName() + "," +
                    ticket.getParkingSpace() + "," +
                    ticket.getGateEnter() + "," +
                    ticket.getGateExit() + "," +
                    ticket.getAmountDue() + ","
                );
                writer.newLine();
            }
            writer.close();
        }
        catch (Exception e) {
            System.out.println("Error: Unable to write to database text file.");
        }
    }
}
