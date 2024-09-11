package com.manuu.vehicle_service.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


class Edge implements Comparable<Edge> {

    @JsonProperty("source")
    int source;

    @JsonProperty("dest")
    int dest;

    @JsonProperty("weight")
    int weight;

    public Edge(){}

    // Constructor to initialize an edge
    public Edge(int source, int dest, int weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }


    @Override
    public int compareTo(Edge other) {
        return this.weight-other.weight;
    }
}