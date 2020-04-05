package com.example.springboot.services;

import com.example.springboot.model.Civilian;
import com.example.springboot.repositories.CivilianRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilianService {

    @Autowired
    CivilianRepo civRepo;

    public List<Civilian> getAllCivilianData(){
        return (List<Civilian>) civRepo.findAll();
    }

    public List<Civilian> getCivilianBy(){

        return null;
    }

    public Civilian onboardCivilian(Civilian newPatient){
        civRepo.save(newPatient);
        return null;
    }
}
