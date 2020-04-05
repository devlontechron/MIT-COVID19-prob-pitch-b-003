package com.example.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("testData")
public class TestDataController {

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String getTestById(@RequestParam("id") String id) {
        //go to service class and pass in ID and return results
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(value = "/{Zip}", method = RequestMethod.GET)
    public String getTestByArea(@RequestParam("Zip") String zip) {
        //go to service class and pass in ID and return results
        return "Greetings from Spring Boot!";
    }
}
