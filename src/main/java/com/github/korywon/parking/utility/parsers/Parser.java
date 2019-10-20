package com.github.korywon.parking.utility.parsers;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.lang.ref.Cleaner;

/**
 * Handles all file operations.
 */
public class Parser {
    protected String path;
    private File file;
    private BufferedReader bufferedReader;

    public Parser(String path) {
        this.path = path;

        file = new File(this.path);

        try {
            System.out.print("Loading \"" + this.path + "\" ... ");
            bufferedReader = new BufferedReader(new FileReader(this.file));
            System.out.print("[ DONE ]\n");
        }
        catch (Exception e) {
            System.out.print("[ FAIL ]\n");
        }
    }

    public String readFileLine() {
        try {
            return bufferedReader.readLine();
        }
        catch (Exception e) {
            System.out.println("Error: Unable to read line from \"" + this.path + "\"");
            return null;
        }
    }
}
