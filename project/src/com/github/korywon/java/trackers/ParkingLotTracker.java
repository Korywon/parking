package com.github.korywon.java.trackers;

import com.github.korywon.java.service.ParkingLot;

import java.io.File;
import java.util.List;

public class ParkingLotTracker {
    List<ParkingLot> openParkingLots;
    List<ParkingLot> closedParkingLots;

    File parkingLotsFile;

    public void addParkingLot(String title, int capacity, float cost, float fine, boolean active) {
        ParkingLot newParkingLot = new ParkingLot(title, capacity, 0, cost, fine, active);
    }

    public void editParkingLot(String title) {

    }

    public void removeParkingLot(String title) {

    }

    public void openParkingLot(String title) {

    }

    public void closeParkingLot(String title) {

    }
}
