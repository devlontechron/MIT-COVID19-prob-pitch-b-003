package com.example.springboot.model;

import java.util.List;

public class NewOrgRequest {
    String orgName;
    String adminEmail;
    Resources onboardData;
    List<HealthCareWorker> workers;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public Resources getOnboardData() {
        return onboardData;
    }

    public void setOnboardData(Resources onboardData) {
        this.onboardData = onboardData;
    }

    public List<HealthCareWorker> getWorkers() {
        return workers;
    }

    public void setWorkers(List<HealthCareWorker> workers) {
        this.workers = workers;
    }
}
