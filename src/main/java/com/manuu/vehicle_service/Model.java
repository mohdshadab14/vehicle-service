package com.manuu.vehicle_service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Model {

    @JsonProperty("name")
    String name;

    @Override
    public String toString() {
        return "Model{" +
                "name='" + name + '\'' +
                '}';
    }
}
