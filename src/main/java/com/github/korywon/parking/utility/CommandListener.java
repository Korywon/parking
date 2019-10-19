package com.github.korywon.parking.utility;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class CommandListener {
    private BufferedReader bufferedReader;
    private InputStreamReader inputStreamReader;

    public CommandListener() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Prompts the user for an input.
     * @param prompt Prints a prompt message before the input.
     * @return Returns the string that the user entered in.
     */
    public String promptForInput(String prompt) {
        System.out.print(prompt);
        try {
            return bufferedReader.readLine();
        }
        catch (Exception ignored) { return ""; }
    }
}
