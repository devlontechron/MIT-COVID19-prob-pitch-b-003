package com.example.springboot.services;

import com.example.springboot.model.Civilian;
import com.example.springboot.model.TestData;
import com.example.springboot.repositories.CivilianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilianService {

    @Autowired
    CivilianRepo civRepo;

    @Autowired
    TestDataService testService;

    public List<Civilian> getAllCivilianData(){
        return (List<Civilian>) civRepo.findAll();
    }

    public Civilian getCivilianByID(String id){
        return civRepo.findById(id);
    }

    public TestData onboardCivilian(Civilian newPatient){
        civRepo.save(newPatient);
        return testService.createNewTest();
    }
}
