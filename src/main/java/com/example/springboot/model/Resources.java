package com.example.springboot.model;

public class Resources {

    int masks;
    int icuBeds;
    int beds;
    int PPE;

    //how can we make this dynamic?


    public int getMasks() {
        return masks;
    }

    public void setMasks(int masks) {
        this.masks = masks;
    }

    public int getIcuBeds() {
        return icuBeds;
    }

    public void setIcuBeds(int icuBeds) {
        this.icuBeds = icuBeds;
    }

    public int getBeds() {
        return beds;
    }

    public void setBeds(int beds) {
        this.beds = beds;
    }

    public int getPPE() {
        return PPE;
    }

    public void setPPE(int PPE) {
        this.PPE = PPE;
    }
}
