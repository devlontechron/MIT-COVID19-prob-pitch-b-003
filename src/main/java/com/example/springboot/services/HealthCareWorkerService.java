package com.example.springboot.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot.model.Civilian;
import com.example.springboot.model.HealthCareWorker;

@Service
public class HealthCareWorkerService {

    public List<HealthCareWorker> getAllHelthCareWorkerData(){
    	List<HealthCareWorker> list = new ArrayList<HealthCareWorker>();
    	HealthCareWorker h = new HealthCareWorker();
    	h.setName("Peter Gonzales");
    	h.setEmail("worker1@instituon.com");
    	h.setOrg("Institution1");
    	
    	HealthCareWorker h2 = new HealthCareWorker();
    	h2.setName("Marco Rodriguez");
    	h2.setEmail("worker2@instituon.com");
    	h2.setOrg("Institution1");
    	
    	HealthCareWorker h3 = new HealthCareWorker();
    	h2.setName("Esteban Lopez");
    	h2.setEmail("worker3@instituon.com");
    	h2.setOrg("Institution1");
    	
    	list.add(h);
    	list.add(h2);
    	list.add(h3);
    	
        return list;
    }

    public List<HealthCareWorker> getHealthCareWorkerBy(){

        return null;
    }

    public HealthCareWorker create(HealthCareWorker h){
        //abstract information to keep hippa laws?

        //repo.insert()
        //return HTTP 200
        return null;
    }
    
    
    public HealthCareWorker update(HealthCareWorker h){
        //abstract information to keep hippa laws?

        //repo.insert()
        //return HTTP 200
        return null;
    }
}
