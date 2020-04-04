package com.example.springboot.model;

import java.util.Date;
import java.util.Set;

public class Civilian {
    String id;
    int age;
    String gender;
    String race;
    //metric system please!
    double weight;
    String location;
    Date created;
    Date lastUpdated;
    Set<String> conditions;
    Boolean hasPreExisitingCondition;
    Set<String> symptoms;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Set<String> getConditions() {
        return conditions;
    }

    public void setConditions(Set<String> conditions) {
        this.conditions = conditions;
    }

    public Boolean getHasPreExisitingCondition() {
        return hasPreExisitingCondition;
    }

    public void setHasPreExisitingCondition(Boolean hasPreExisitingCondition) {
        this.hasPreExisitingCondition = hasPreExisitingCondition;
    }

    public Set<String> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(Set<String> symptoms) {
        this.symptoms = symptoms;
    }
}
