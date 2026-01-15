package org.example.creational.factory;

import org.example.creational.builder.Car;

public class CarConfiguration {
    public static void main(String[] args) {

        // create a custom car
        Car sportCar = new Car.CarBuilder("V8 Turbo", "Automatic")
                .setColor("Red")
                .setInterior("Leather")
                .setGPS(true)
                .setSunroof(true)
                .build();

        Car familyCar = new Car.CarBuilder("V6 Hybrid", "Automatic")
                .setColor("Silver")
                .setSafetyPackage(true)
                .build();

        // I use the DocumentFactory to generate a report about the car we just built.

        System.out.println("\nGenerating Order Reports");

        Document sportCarReport = DocumentFactory.createDocument("pdf", sportCar.toString());
        Document familyCarReport = DocumentFactory.createDocument("html", familyCar.toString());

        System.out.println("\n[Report 1]");
        sportCarReport.open();
        System.out.println(sportCarReport.getContent());
        sportCarReport.save();

        System.out.println("\n[Report 2]");
        familyCarReport.open();
        System.out.println(familyCarReport.getContent());
        familyCarReport.save();
    }
}