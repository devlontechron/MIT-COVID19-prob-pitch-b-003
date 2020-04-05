package com.example.springboot.controller;

import com.example.springboot.model.TestData;
import com.example.springboot.services.TestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testData")
public class TestDataController {

    @Autowired
    TestDataService testDataService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<TestData> getTestById(@RequestParam("id") String id) {
        //go to service class and pass in ID and return results
        return new ResponseEntity<TestData>(testDataService.getTestDataById(id), HttpStatus.OK);
    }

    @RequestMapping(value = "/{Zip}", method = RequestMethod.GET)
    public String getTestByArea(@RequestParam("Zip") String zip) {
        //go to service class and pass in ID and return results
        return "Greetings from Spring Boot!";
    }
}
