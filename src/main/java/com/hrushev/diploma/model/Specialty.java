package com.hrushev.diploma.model;

public class Specialty {
    private double avgSalary;
    private double multiplier;
    private int workerCount;

    public Specialty(double avgSalary, double multiplier, int workerCount) {
        this.avgSalary = avgSalary;
        this.multiplier = multiplier;
        this.workerCount = workerCount;
    }

    public Specialty() {}

    public double getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(double avgSalary) {
        this.avgSalary = avgSalary;
    }

    public double getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(double multiplier) {
        this.multiplier = multiplier;
    }

    public int getWorkerCount() {
        return workerCount;
    }

    public void setWorkerCount(int workerCount) {
        this.workerCount = workerCount;
    }

    @Override
    public String toString() {
        return "Specialty{" +
                "avgSalary=" + avgSalary +
                ", multiplier=" + multiplier +
                ", workerCount=" + workerCount +
                '}';
    }
}
