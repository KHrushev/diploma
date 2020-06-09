package com.hrushev.diploma.controllers.processors;

import com.hrushev.diploma.model.Data;
import com.hrushev.diploma.model.Specialty;
import com.hrushev.diploma.model.TransportRoute;

import java.util.List;

public class Calculator {
    public static Data process(List<Data> dataList) {
        for (Data data: dataList) {
            calculateOptimalIndex(data);
        }

        return getOptimalData(dataList);
    }

    private static void calculateOptimalIndex(Data data) {
        double b1 = 0;
        for (TransportRoute route: data.getRoutes()) {
            b1 += getMultiplier(data.getInfrastructureLevel(), 1.25/1.5, 1.1/1.25, 1/1.1)*(route.getCostPerUnit() * route.getDistance() * route.getMass() * 12);
        }

        double b2 = 0;
        for (Specialty specialty: data.getSpecialties()) {
            b2 += getMultiplier(data.getInfrastructureLevel(), 1.15/1.3, 1.05/1.15, 1/1.05)*(specialty.getAvgSalary() * (1+specialty.getMultiplier()) * specialty.getWorkerCount());
        }

        double b3 = getMultiplier(data.getInfrastructureLevel(), 1.3/1.6, 1.1/1.3, 1) * data.getRentPrice() * data.getRentArea() * 12;

        double b4 = data.getCapitalValue() * (data.getTax()/100);

        double d = data.getAvgPrice() * data.getPotCustomerCount() * getMultiplier(data.getInfrastructureLevel(), 0.3/0.4, 0.1/0.15, 0.025/0.05) * getMultiplier(data.getInfrastructureLevel(), 0.1/0.15, 0.12/0.17, 0.15/0.2);

        double b5 = d * (data.getProfitTax()/100) * getMultiplier(data.getInfrastructureLevel(), 1, 1, 0.2/0.5);

        double result = Math.floor((d-(b1+b2+b3+b4+b5)) * 100) / 100;

        data.setBruttoProfit(result);
    }

    private static double getMultiplier(String infLevel, double min, double mid, double max) {
        if (infLevel.equals("Низький")) {
            return min;
        } else if (infLevel.equals("Середній")) {
            return mid;
        } else {
            return max;
        }
    }

    private static Data getOptimalData(List<Data> dataList) {
        double optimalIndex = dataList.get(0).getBruttoProfit();
        Data optimalData = null;

        for (Data data: dataList) {
            if (data.getBruttoProfit() >= optimalIndex) {
                optimalIndex = data.getBruttoProfit();
                optimalData = data;
            }
        }

        return optimalData;
    }
}
