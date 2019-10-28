package com.github.korywon.parking.controller.state.nodes.viewGroups;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.controller.state.nodes.app.AppMainMenu;
import com.github.korywon.parking.objects.Group;
import com.github.korywon.parking.objects.ParkingLot;
import com.github.korywon.parking.utility.parsers.ParserDatabase;

import java.util.List;

public class ViewGroups extends StateNode {
    private List<Group> groupList;
    private List<ParkingLot> parkingLotList;

    @Override
    public void init() {
        ParserDatabase dbParser = new ParserDatabase("parking-data/parking-database.txt");
        groupList = dbParser.getGroupList();
        parkingLotList = dbParser.getParkingLotList();
    }

    @Override
    public void start() {
        for (Group group : groupList) {
            group.printInfo();
            System.out.println("Parking lots: ");
            for (ParkingLot parkingLot : parkingLotList) {
                if (parkingLot.getGroupName().equals(group.getGroupName())) {
                    System.out.println("\t" + parkingLot.getParkingLotName());
                }
            }
            System.out.println();
        }

        this.nextNode = new AppMainMenu();
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
