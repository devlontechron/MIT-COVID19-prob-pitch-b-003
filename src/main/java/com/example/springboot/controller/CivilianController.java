package com.example.springboot.controller;

import com.example.springboot.model.Civilian;
import com.example.springboot.services.CivilianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("civilian")
public class CivilianController {

    @Autowired
    CivilianService civServ;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getExample() {
        //go to service class and pass in ID and return results
        return "Greetings from Spring Boot!";
    }

    @GetMapping(value = "/allCivs")
    public ResponseEntity<List<Civilian>> getAllCivilian() {
        List<Civilian> allCivs = civServ.getAllCivilianData();
        return new ResponseEntity<List<Civilian>>(allCivs, HttpStatus.OK);
    }

    @PostMapping(value = "/{ID}")
    public String getCivilianById(@PathVariable("ID") String Id) {
        //go to service class and pass in ID and return results
        return "Greetings from Spring Boot!";
    }

    @PostMapping(value = "/new")
    public ResponseEntity<Civilian> getCivilianById(@RequestBody Civilian newCiv) {
        Civilian addedCiv = civServ.onboardCivilian(newCiv);
        return new ResponseEntity<Civilian>(addedCiv, HttpStatus.OK);
    }
}
