package com.github.korywon.java.service;

public class Gate {
    /**
     *
     */
    private String type;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private boolean active;

    /**
     * Constructor to create a new <code>Gate</code> object.
     * @param type Type of gate. Common types are "enter" and "exit".
     * @param name Name of the gate.
     * @param active True if gate is active (open) and false if gate is inactive (closed).
     */
    public Gate(String type, String name, boolean active) {
        this.type = type;
        this.name = name;
        this.active = active;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
