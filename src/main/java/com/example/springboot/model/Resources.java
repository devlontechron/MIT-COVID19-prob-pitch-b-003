package com.example.springboot.model;

public class Resources {

    int testKits;
    int testPerDayRate;
    int testBacklog;

    //how can we make this dynamic?


    public int getTestKits() {
        return testKits;
    }

    public void setTestKits(int testKits) {
        this.testKits = testKits;
    }

    public int getTestPerDayRate() {
        return testPerDayRate;
    }

    public void setTestPerDayRate(int testPerDayRate) {
        this.testPerDayRate = testPerDayRate;
    }

    public int getTestBacklog() {
        return testBacklog;
    }

    public void setTestBacklog(int testBacklog) {
        this.testBacklog = testBacklog;
    }
}
