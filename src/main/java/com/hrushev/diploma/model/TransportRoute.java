package com.hrushev.diploma.model;

public class TransportRoute {
    private double costPerUnit;
    private double distance;
    private double mass;

    public TransportRoute(double costPerUnit, double distance, double mass) {
        this.costPerUnit = costPerUnit;
        this.distance = distance;
        this.mass = mass;
    }

    public TransportRoute() {}

    public double getCostPerUnit() {
        return costPerUnit;
    }

    public void setCostPerUnit(double costPerUnit) {
        this.costPerUnit = costPerUnit;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    @Override
    public String toString() {
        return "TransportRoute{" +
                "costPerUnit=" + costPerUnit +
                ", distance=" + distance +
                ", mass=" + mass +
                '}';
    }
}
