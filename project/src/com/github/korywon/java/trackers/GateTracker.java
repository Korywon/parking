package com.github.korywon.java.trackers;

import com.github.korywon.java.service.Gate;

import java.util.List;

public class GateTracker {
    List<Gate> openGates;
    List<Gate> closedGates;

    public void addGate(String type, String title, boolean active) {
        Gate newGate = new Gate(type, title, active);
    }

    public void editGate(String title) {
        
    }

    public void removeGate(String title) {

    }

    public void openGate(String title) {

    }

    public void closeGate(String title) {

    }
}
