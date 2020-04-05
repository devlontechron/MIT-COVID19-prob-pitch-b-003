package com.example.springboot.controller;

import com.example.springboot.model.NewOrgRequest;
import com.example.springboot.services.CivilianService;
import com.example.springboot.services.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("org")
public class OrganizationController {

    @Autowired
    OrgService orgServ;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getOrgNames() {
        orgServ.getAllOrgNames();
        //go to service class and pass in ID and return results
        return "Greetings from Spring Boot!";
    }


    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String OnboardOrg(@RequestBody NewOrgRequest nor) {
        orgServ.getAllOrgNames();
        //go to service class and pass in ID and return results
        return "Greetings from Spring Boot!";
    }

}
