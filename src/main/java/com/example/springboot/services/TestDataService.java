package com.example.springboot.services;

import com.example.springboot.model.TestData;
import com.example.springboot.repositories.TestDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestDataService {

    @Autowired
    TestDataRepo testRepo;

    public TestData getTestDataById(String Id){
        return testRepo.findById(Id);
    }

    public TestData createNewTest(){
        TestData buildTest = new TestData();
        //TODO

        testRepo.save(buildTest);
        return buildTest;
    }

}
