package org.example.creational.factory;

import org.example.creational.builder.Car;
import java.util.Scanner;

public class CarConfiguration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Interactive Car Builder ---");

        System.out.print("Enter Engine (e.g., V8, V6, Electric): ");
        String engine = scanner.nextLine();

        System.out.print("Enter Transmission (e.g., Automatic, Manual): ");
        String transmission = scanner.nextLine();

        System.out.print("Enter Color: ");
        String color = scanner.nextLine();

        System.out.print("Enter Interior (Leather/Fabric): ");
        String interior = scanner.nextLine();

        System.out.print("Add Sunroof? (true/false): ");
        boolean sunroof = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Add GPS? (true/false): ");
        boolean gps = Boolean.parseBoolean(scanner.nextLine());

        System.out.print("Add Safety Package? (true/false): ");
        boolean safety = Boolean.parseBoolean(scanner.nextLine());

        Car userCar = new Car.Builder()
                .setEngine(engine)
                .setTransmission(transmission)
                .setColor(color)
                .setInterior(interior)
                .setSunroof(sunroof)
                .setGPS(gps)
                .setSafetyPackage(safety)
                .build();

        System.out.print("\nSelect Report Format (pdf/html): ");
        String format = scanner.nextLine();

        DocumentFactory factory = new DocumentFactory();
        Document report = factory.createDocument(format, "Car Configuration: " + userCar.toString());
        System.out.println("\n--- Generating Report ---");
        report.open();
        report.save();

        System.out.println("Final Car Config: " + userCar);
    }
}