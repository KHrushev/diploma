package com.hrushev.diploma.model;

import java.util.List;

public class Data {
    private double bruttoProfit;

    private String name;
    private double avgPrice;
    private int potCustomerCount;
    private String infrastructureLevel;
    private double rentPrice;
    private double rentArea;
    private double capitalValue;
    private double tax;
    private double profitTax;
    private List<TransportRoute> routes;
    private List<Specialty> specialties;

    public Data() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvgPrice() {
        return avgPrice;
    }

    public void setAvgPrice(double avgPrice) {
        this.avgPrice = avgPrice;
    }

    public int getPotCustomerCount() {
        return potCustomerCount;
    }

    public void setPotCustomerCount(int potCustomerCount) {
        this.potCustomerCount = potCustomerCount;
    }

    public String getInfrastructureLevel() {
        return infrastructureLevel;
    }

    public void setInfrastructureLevel(String infrastructureLevel) {
        this.infrastructureLevel = infrastructureLevel;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public double getRentArea() {
        return rentArea;
    }

    public void setRentArea(double rentArea) {
        this.rentArea = rentArea;
    }

    public double getCapitalValue() {
        return capitalValue;
    }

    public void setCapitalValue(double capitalValue) {
        this.capitalValue = capitalValue;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getProfitTax() {
        return profitTax;
    }

    public void setProfitTax(double profitTax) {
        this.profitTax = profitTax;
    }

    public double getBruttoProfit() {
        return bruttoProfit;
    }

    public void setBruttoProfit(double bruttoProfit) {
        this.bruttoProfit = bruttoProfit;
    }

    public List<TransportRoute> getRoutes() {
        return routes;
    }

    public void setRoutes(List<TransportRoute> routes) {
        this.routes = routes;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }

    @Override
    public String toString() {
        return "Data{" +
                "optimalIndex=" + bruttoProfit +
                ", avgPrice=" + avgPrice +
                ", potCustomerCount=" + potCustomerCount +
                ", infrastructureLevel='" + infrastructureLevel + '\'' +
                ", rentPrice=" + rentPrice +
                ", rentArea=" + rentArea +
                ", capitalValue=" + capitalValue +
                ", tax=" + tax +
                ", profitTax=" + profitTax +
                ", routes=" + routes +
                ", specialties=" + specialties +
                '}';
    }
}
