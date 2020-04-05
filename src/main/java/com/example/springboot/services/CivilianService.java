package com.example.springboot.services;

import com.example.springboot.model.Civilian;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CivilianService {

    public List<Civilian> getAllCivilianData(){
        //hit repo

        return null;
    }

    public List<Civilian> getCivilianBy(){

        return null;
    }

    public Civilian onboardCivilian(Civilian newPatient){
        //abstract information to keep hippa laws?

        //repo.insert()
        //return HTTP 200
        return null;
    }
}
