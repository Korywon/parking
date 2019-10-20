package com.github.korywon.parking.utility.parsers;

import com.github.korywon.parking.objects.Gate;
import com.github.korywon.parking.objects.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParserParkingLot extends Parser {
    private ParkingLot parkingLot;

    public ParserParkingLot(String path) {
        super(path);
        this.parkingLot = parseParkingLots();
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    private ParkingLot parseParkingLots() {
        String line;
        int lineNumber = 1;
        boolean valid = false;
        ParkingLot newParkingLot = new ParkingLot();
        while ((line = this.readFileLine()) != null) {
            switch(lineNumber) {
                case 1:
                    newParkingLot.setName(line);
                    valid = true;
                    break;
                case 2:
                    try {
                        newParkingLot.setCapacity(Integer.parseInt(line));
                        valid = true;
                    } catch(Exception e) {
                        System.out.println("Error: (" + this.path + ") Invalid input at line " + lineNumber);
                        valid = false;
                    }
                    break;
                case 3:
                    newParkingLot.setGatesEnter(parseGateLine("enter", line));
                    valid = true;
                    break;
                case 4:
                    newParkingLot.setGatesExit(parseGateLine("exit", line));
                    valid = true;
                    break;
                case 5:
                    try {
                        newParkingLot.setPrice(Float.parseFloat(line));
                        valid = true;
                    } catch(Exception e) {
                        System.out.println("Error: (" + this.path + "): Invalid input at line " + lineNumber);
                        valid = false;
                    }
                    break;
                default:
                    break;
            }
            lineNumber++;

            if (!valid) {
                break;
            }
        }

        if (valid) {
            return newParkingLot;
        } else {
            System.out.println("Error: \"" + this.path + "\" rejected due to invalid input.");
            return null;
        }
    }

    private List<Gate> parseGateLine(String type, String line) {
        List<Gate> newGateList = new ArrayList<Gate>();

        String[] splitLine = line.split(",");
        if (splitLine.length != 0) {
            for (String gate : splitLine) {
                Gate newGate = new Gate(type, gate);
                newGateList.add(newGate);
            }
        }

        return newGateList;
    }
}
