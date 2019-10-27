package com.github.korywon.parking.utility.parsers;

import com.github.korywon.parking.objects.Group;
import com.github.korywon.parking.objects.ParkingLot;
import com.github.korywon.parking.objects.Ticket;

import java.util.ArrayList;
import java.util.List;

public class ParserDatabase extends Parser {

    List<Group> groupList;
    List<ParkingLot> parkingLotList;
    List<Ticket> ticketList;

    public ParserDatabase(String path) {
        super(path);

        this.groupList = new ArrayList<Group>();
        this.parkingLotList = new ArrayList<ParkingLot>();
        this.ticketList = new ArrayList<Ticket>();

        // parses the "database" text file
        this.parseDatabase();
        // assigns groups prices to each parking lot if avaiable
        this.assignGroupPrices();
    }

    public List<Group> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Group> groupList) {
        this.groupList = groupList;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public List<Ticket> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<Ticket> ticketList) {
        this.ticketList = ticketList;
    }

    /**
     * Parses the entire "database" text file line by line.
     */
    private void parseDatabase() {
        // string to hold the line content
        String line;
        // string array to hold elements of the split string
        String[] splitLine;
        // holds the current line number of the file
        int lineNumber = 0;
        while ((line = this.readFileLine()) != null) {
            splitLine = line.split(",");
            if (splitLine[0].equals("Group")) {
                Group group = this.parseGroupLine(line);
                if (group != null) {
                    this.groupList.add(group);
                } else {
                    System.out.println(this.path + ": Invalid group entry at line " + lineNumber);
                }
            }
            else if (splitLine[0].equals("ParkingLot")) {
                ParkingLot parkingLot = this.parseParkingLotLine(line);
                if (parkingLot != null) {
                    this.parkingLotList.add(parkingLot);
                } else {
                    System.out.println(this.path + ": Invalid parking lot entry at line " + lineNumber);
                }
            }
            else if (splitLine[0].equals("Ticket")) {
                Ticket ticket = this.parseTicketLine(line);
                if (ticket != null) {
                    this.ticketList.add(ticket);
                } else {
                    System.out.println(this.path + ": Invalid ticket entry at line " + lineNumber);
                }
            }
            else {
                System.out.println(this.path + ": Unknown entry at line " + lineNumber);
            }
        }

        lineNumber++;
    }

    private void assignGroupPrices() {
        for (ParkingLot parkingLot : parkingLotList) {
            String groupName = parkingLot.getGroupName();
            for (Group group : groupList) {
                if (group.getGroupName().equals(groupName)) {
                    parkingLot.setGroupPrice(group.getGroupPrice());
                }
            }
        }
    }

    /**
     * Parses each line associated to the group type.
     * @param line
     * @return
     */
    private Group parseGroupLine(String line) {
        Group newGroup = null;

        String[] splitLine = line.split(",");
        if (splitLine.length == 3 && splitLine[0].equals("Group")) {
            String groupName = splitLine[1];
            float groupPrice;
            try {
                groupPrice = Float.parseFloat(splitLine[2]);
                if (groupPrice < 0) {
                    return null;
                }
            } catch (Exception e) {
                return null;
            }
            newGroup = new Group(groupName, groupPrice);
        }

        return newGroup;
    }

    /**
     * Parses entire line associated with the ParkingLot type.
     * @param line
     * @return
     */
    private ParkingLot parseParkingLotLine(String line) {
        ParkingLot newParkingLot = null;

        String[] splitLine = line.split(",");
        if (splitLine.length == 7 && splitLine[0].equals("ParkingLot")) {
            String parkingLotName = splitLine[1];
            String groupName = splitLine[2];

            // attempts to parse capacity entry as an integer
            int capacity;
            try {
                capacity = Integer.parseInt(splitLine[3]);
                if (capacity < 0) {
                    return null;
                }
            } catch (Exception e) {
                return null;
            }

            String gateEnter = splitLine[4];
            String gateExit = splitLine[5];

            // attempts to parse default price as a float
            float defaultPrice;
            try {
                defaultPrice = Float.parseFloat(splitLine[6]);
                if (defaultPrice < 0) {
                    return null;
                }
            } catch (Exception e) {
                return null;
            }

            newParkingLot = new ParkingLot(parkingLotName, capacity, gateEnter, gateExit, defaultPrice);
            newParkingLot.setGroupName(groupName);
            newParkingLot.setGroupPrice(0.0f);
        }

        return newParkingLot;
    }

    /**
     * Parses entire line associated with the ticket type.
     * @param line
     * @return
     */
    private Ticket parseTicketLine(String line) {
        Ticket newTicket = null;

        String[] splitLine = line.split(",");
        if (splitLine.length == 8 && splitLine[0].equals("Ticket")) {
            String licensePlateNumber = splitLine[1];
            String parkingLotName = splitLine[2];
            String groupName = splitLine[3];

            // attempts to parse index 3 element into an integer
            int parkingSpace;
            try {
                parkingSpace = Integer.parseInt(splitLine[4]);
                if (parkingSpace < 0) {
                    return null;
                }
            }
            catch (Exception e) {
                return null;
            }
            String enterGate = splitLine[5];
            String exitGate = splitLine[6];

            // attempts to parse 7th element into a float
            float price;
            try {
                price = Float.parseFloat(splitLine[7]);
                if (price < 0) {
                    return null;
                }
            } catch (Exception e) {
                return null;
            }

            newTicket = new Ticket(
                licensePlateNumber, parkingLotName, groupName, parkingSpace, enterGate, exitGate, price
            );
        }

        return newTicket;
    }

    public void printGroups() {

    }

    public void printParkingLots() {

    }

    public void printTickets() {

    }
}
