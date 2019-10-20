package com.github.korywon.parking.controller.state.nodes.openCloseTickets;

import com.github.korywon.parking.controller.state.StateNode;
import com.github.korywon.parking.objects.Gate;
import com.github.korywon.parking.objects.Ticket;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OpenCloseTicketsClosePay extends StateNode {
    private Ticket activeTicket;

    public OpenCloseTicketsClosePay(String transitionCommand, Ticket activeTicket) {
        super(transitionCommand);
        this.activeTicket = activeTicket;
    }

    @Override
    public void init() {

    }

    @Override
    public void start() {
        System.out.println(
            "\"" + activeTicket.getLicensePlateNumber() + "\" -- Pay close ticket now?" + "\n" +
            "[ y ]" + "\t" + "Yes" + "\n" +
            "[ n ]" + "\t" + "No"
        );

        boolean valid = false;
        while (!valid) {
            String userInput = this.commandListener.promptForInput("Enter command: ");

            if (userInput.equals("y")) {
                Date date = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                activeTicket.setGateExit(new Gate("exit", ""));
                activeTicket.setTimeClose(formatter.format(date));

                try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("parking-data/tickets/inactive.csv", true));
                writer.newLine();
                writer.write(
                activeTicket.getLicensePlateNumber() + "," +
                    activeTicket.getGateEnter().getName() + "," +
                    activeTicket.getTimeEnter() + "," +
                    activeTicket.getGateExit().getName() + "," +
                    activeTicket.getTimeClose() + "," +
                    activeTicket.getAmountDue()
                );
                writer.close();

                System.out.println("----- Receipt -----");
                activeTicket.printInfo();

                } catch (Exception e) {
                    System.out.println("Error: Unable to write to file.");
                }

                this.nextNode = new OpenCloseTicketsMainMenu("");
                valid = true;
            } else if (userInput.equals("n")) {
                this.nextNode = new OpenCloseTicketsMainMenu("");
                valid = true;
            } else {
                System.out.println("Invalid command. Please try again.");
                valid = false;
            }
        }
    }

    @Override
    public StateNode exit() {
        return this.nextNode;
    }
}
