package com.hrushev.diploma.controllers.processors;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrushev.diploma.model.Data;
import com.hrushev.diploma.model.Specialty;
import com.hrushev.diploma.model.TransportRoute;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Parser {

    public static List<Data> parseDataList(String stringDataList) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);

        List<Data> dataList = new ArrayList<>();
        JsonNode listNode = null;

        try {
            listNode = mapper.readTree(stringDataList);

            for (int i = 0; i < listNode.size(); i++) {
                Data data = new Data();
                List<TransportRoute> transportRoutes = new ArrayList<>();
                List<Specialty> specialties = new ArrayList<>();
                JsonNode dataNode = listNode.get(i);

                data.setName(dataNode.get("name").asText());
                data.setAvgPrice(dataNode.get("avgPrice").asDouble());
                data.setCapitalValue(dataNode.get("capitalValue").asDouble());
                data.setInfrastructureLevel(dataNode.get("infrastructureLevel").asText());
                data.setPotCustomerCount(dataNode.get("potCustomerCount").asInt());
                data.setRentArea(dataNode.get("rentArea").asDouble());
                data.setRentPrice(dataNode.get("rentPrice").asDouble());
                data.setTax(dataNode.get("tax").asDouble());
                data.setProfitTax(dataNode.get("profitTax").asDouble());

                JsonNode routeNodes = dataNode.get("routes");
                for (int j = 0; j < routeNodes.size(); j++) {
                    TransportRoute route = new TransportRoute();
                    JsonNode routeNode = routeNodes.get(j);

                    route.setCostPerUnit(routeNode.get("costPerUnit").asDouble());
                    route.setDistance(routeNode.get("distance").asDouble());
                    route.setMass(routeNode.get("mass").asDouble());

                    transportRoutes.add(route);
                }

                data.setRoutes(transportRoutes);

                JsonNode specialtiesNodes = dataNode.get("specialties");
                for (int j = 0; j < specialtiesNodes.size(); j++) {
                    Specialty specialty = new Specialty();
                    JsonNode specialtyNode = specialtiesNodes.get(j);

                    specialty.setAvgSalary(specialtyNode.get("avgSalary").asDouble());
                    specialty.setMultiplier(specialtyNode.get("multiplier").asDouble());
                    specialty.setWorkerCount(specialtyNode.get("workerCount").asInt());

                    specialties.add(specialty);
                }

                data.setSpecialties(specialties);

                dataList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataList;
    }
}
