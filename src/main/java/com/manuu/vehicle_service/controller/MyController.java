package com.manuu.vehicle_service.controller;

import com.manuu.vehicle_service.config.DatabaseConnectionClient;
import com.manuu.vehicle_service.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/hello")
    public String sayHello(){

        myService.queryDatabase();
        return "Hello World";
    }

}
