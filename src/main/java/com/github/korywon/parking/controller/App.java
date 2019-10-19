package com.github.korywon.parking.controller;

public class App {
    public static void main(String[] args) {
        System.out.println("Beginning application launch...");
        // creates a new controller
        MainController controller = new MainController();
        // initializes the controller
        controller.init();
        // starts the controller
        controller.start();
    }
}
