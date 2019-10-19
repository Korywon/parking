package com.github.korywon.parking.objects;

import java.sql.Timestamp;

public class Ticket {
    private Car car;
    private Gate gateEnter;
    private Gate gateExit;
    private Timestamp timeEnter;
    private Timestamp timeClose;
    private float amountPaid;
}
