package com.manuu.vehicle_service.controller;

import com.manuu.vehicle_service.Model;
import com.manuu.vehicle_service.config.DatabaseConnectionClient;
import com.manuu.vehicle_service.service.Graph;
import com.manuu.vehicle_service.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Stack;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/hello")
    public String sayHello(){

        myService.queryDatabase();
        return "Hello World";
    }

    @PostMapping("/calcuate")
    public String calculate(@RequestBody  Model model){

        //myService.queryDatabase();
        return model.toString();
    }

    @PostMapping("/getmst")
    public int getMinSpanningTreeCost(@RequestBody  Graph graph){
        /*Graph graph = new Graph(4); // Create a graph with 4 vertices
        graph.addEdge(0, 1, 1);
        graph.addEdge(1, 2, 2);
        graph.addEdge(2, 3, 3);
        graph.addEdge(0, 3, 4);*/

        return graph.getMST();
    }
}
