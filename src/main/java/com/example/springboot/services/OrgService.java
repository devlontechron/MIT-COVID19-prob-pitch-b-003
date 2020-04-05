package com.example.springboot.services;

import com.example.springboot.model.NewOrgRequest;
import com.example.springboot.model.Organizations;
import com.example.springboot.repositories.OrgRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrgService {

    @Autowired
    OrgRepo orgRepo;

    public void getAllOrgNames() {
    }

    public Organizations newOrgOnboarding(NewOrgRequest nor){
        Organizations newOrg = new Organizations();
        return orgRepo.insertNewOrg(newOrg);
    }
}
