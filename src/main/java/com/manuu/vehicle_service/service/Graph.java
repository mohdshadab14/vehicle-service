package com.manuu.vehicle_service.service;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;


public class Graph {
    @JsonProperty("vertices")
    int vertices;

    @JsonProperty("adjacencyList")
    LinkedList<Edge>[] adjacencyList;

    // Constructor to initialize the graph with the given number of vertices
    public Graph(){}

    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge to the graph
    public void addEdge(int source, int dest, int weight) {
        Edge edge = new Edge(source, dest, weight);
        adjacencyList[source].add(edge);
        // Adding the reverse edge since it's an undirected graph
        adjacencyList[dest].add(new Edge(dest, source, weight));
    }

    // Method to implement Prim's algorithm to find the MST
    public int getMST() {
        boolean[] inMST = new boolean[vertices]; // Array to track vertices included in MST
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        List<Edge> mst = new ArrayList<>(); // List to store the MST edges

        int startVertex = 0; // Start from any vertex (here it's 0)
        inMST[startVertex] = true;

        // Add all edges from the start vertex to the priority queue
        priorityQueue.addAll(adjacencyList[startVertex]);

        while (!priorityQueue.isEmpty()) {
            Edge currentEdge = priorityQueue.poll();
            if (!inMST[currentEdge.dest]) {
                mst.add(currentEdge); // Add the edge to the MST
                inMST[currentEdge.dest] = true;
                for (Edge edge : adjacencyList[currentEdge.dest]) {
                    if (!inMST[edge.dest]) {
                        priorityQueue.add(edge);
                    }
                }
            }
        }

        // Print the edges in the MST
        System.out.println("Minimum Spanning Tree:");
        for (Edge edge : mst) {
            System.out.println("Edge: " + edge.source + " - " + edge.dest + " Weight: " + edge.weight);
        }
        int minimumCost = 0;
        for (Edge edge : mst) {
            minimumCost+= edge.weight;
        }
        return minimumCost;
    }
}