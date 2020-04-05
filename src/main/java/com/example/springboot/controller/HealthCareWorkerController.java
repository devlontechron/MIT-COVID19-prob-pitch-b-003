package com.example.springboot.controller;

//import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.model.HealthCareWorker;
import com.example.springboot.services.HealthCareWorkerService;

@RestController
@RequestMapping("healthcarew")
public class HealthCareWorkerController {

    @Autowired
    HealthCareWorkerService service;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getExample() {
        //go to service class and pass in ID and return results
        return "Greetings from Spring Boot!";
    }

    @GetMapping(value = "/allhealthcare")
    public ResponseEntity<List<HealthCareWorker>> getAllHealthCareWorker() {
        List<HealthCareWorker> list = service.getAllHelthCareWorkerData();
        return new ResponseEntity<List<HealthCareWorker>>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/{ID}")
    public String getHealthCareWorkerById(@PathVariable("ID") String Id) {
        //go to service class and pass in ID and return results
    	
        return "Greetings from getHealthCareWorkerById";
    }

    @PostMapping(value = "/new")
    public ResponseEntity<HealthCareWorker> create(@RequestBody HealthCareWorker h) {
    	HealthCareWorker newHealthCareWorker = service.create(h);
        return new ResponseEntity<HealthCareWorker>(newHealthCareWorker, HttpStatus.OK);
    }
    
    @PostMapping(value = "/update")
    public ResponseEntity<HealthCareWorker> update(@RequestBody HealthCareWorker h) {
    	HealthCareWorker newHealthCareWorker = service.update(h);
        return new ResponseEntity<HealthCareWorker>(newHealthCareWorker, HttpStatus.OK);
    }
}
