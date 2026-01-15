package org.example.creational.builder;

import lombok.Getter;

@Getter
public class Car {
    private final String engine;
    private final String transmission;

    private final String interior;
    private final String color;
    private final boolean hasSunroof;
    private final boolean hasGPS;
    private final boolean hasSafetyPackage;

    private Car(CarBuilder builder) {
        this.engine = builder.engine;
        this.transmission = builder.transmission;
        this.interior = builder.interior;
        this.color = builder.color;
        this.hasSunroof = builder.hasSunroof;
        this.hasGPS = builder.hasGPS;
        this.hasSafetyPackage = builder.hasSafetyPackage;
    }

    @Override
    public String toString() {
        return "Car Configuration: [Engine=" + engine + ", Transmission=" + transmission +
                ", Color=" + color + ", Interior=" + interior +
                ", Sunroof=" + hasSunroof + ", GPS=" + hasGPS +
                ", SafetyPackage=" + hasSafetyPackage + "]";
    }

    public static class CarBuilder {

        private final String engine;
        private final String transmission;

        private String interior = "Standard Fabric";
        private String color = "White";
        private boolean hasSunroof = false;
        private boolean hasGPS = false;
        private boolean hasSafetyPackage = false;

        public CarBuilder(String engine, String transmission) {
            this.engine = engine;
            this.transmission = transmission;
        }

        public CarBuilder setInterior(String interior) {
            this.interior = interior;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setSunroof(boolean hasSunroof) {
            this.hasSunroof = hasSunroof;
            return this;
        }

        public CarBuilder setGPS(boolean hasGPS) {
            this.hasGPS = hasGPS;
            return this;
        }

        public CarBuilder setSafetyPackage(boolean hasSafetyPackage) {
            this.hasSafetyPackage = hasSafetyPackage;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}