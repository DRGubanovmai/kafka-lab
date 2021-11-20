package com.example.kafka.controller;

import com.example.kafka.service.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final ProducerService producerService;

    @Autowired
    public Controller(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/send")
    public String generate(@RequestParam String message) {
        producerService.produce(message);
        return "send";
    }

}
