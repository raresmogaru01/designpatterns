package org.example.creational.builder;

public class Car {
    private String engine;
    private String transmission;

    private String color;
    private String interior;
    private boolean sunroof;
    private boolean gps;
    private boolean safetyPackage;

    private Car(Builder builder) {
        this.engine = builder.engine;
        this.transmission = builder.transmission;
        this.color = builder.color;
        this.interior = builder.interior;
        this.sunroof = builder.sunroof;
        this.gps = builder.gps;
        this.safetyPackage = builder.safetyPackage;
    }

    @Override
    public String toString() {
        return "Car [Engine=" + engine + ", Transmission=" + transmission +
                ", Color=" + color + ", Interior=" + interior +
                ", Sunroof=" + sunroof + ", GPS=" + gps +
                ", SafetyPackage=" + safetyPackage + "]";
    }

    public static class Builder {
        private String engine;
        private String transmission;
        private String color;
        private String interior;
        private boolean sunroof;
        private boolean gps;
        private boolean safetyPackage;

        public Builder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public Builder setTransmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setInterior(String interior) {
            this.interior = interior;
            return this;
        }

        public Builder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public Builder setGPS(boolean gps) {
            this.gps = gps;
            return this;
        }

        public Builder setSafetyPackage(boolean safetyPackage) {
            this.safetyPackage = safetyPackage;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}