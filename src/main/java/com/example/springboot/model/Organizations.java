package com.example.springboot.model;

import java.util.List;

public class Organizations {
    String orgName;
    String admin;
    Resources metrics;
    List<HealthCareWorker> HCW;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public Resources getMetrics() {
        return metrics;
    }

    public void setMetrics(Resources metrics) {
        this.metrics = metrics;
    }

    public List<HealthCareWorker> getHCW() {
        return HCW;
    }

    public void setHCW(List<HealthCareWorker> HCW) {
        this.HCW = HCW;
    }
}
