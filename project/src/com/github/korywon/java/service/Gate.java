package com.github.korywon.java.service;

public class Gate {
    private String type;
    private String title;
    private boolean active;

    public Gate(String type, String title, boolean active) {
        this.type = type;
        this.title = title;
        this.active = active;
    }
}
