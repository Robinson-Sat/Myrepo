package com.ioco.robotsurvivor.robotsurvivor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;




@Entity
public class Survivor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name,gender;

    private int age,infectionCounter;

    private double longitude,latitude;

    private boolean hasWater,hasFood,hasMedication,hasAmmunition,isInfected;


    // Constructors, getters, and setters
    // Default constructor
    public Survivor() {
    }

    // Constructor with parameters
    public Survivor(String name, int age, String gender, double latitude, double longitude,
                    boolean hasWater, boolean hasFood, boolean hasMedication, boolean hasAmmunition,
                    boolean isInfected, int infectionCounter) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.latitude = latitude;
        this.longitude = longitude;
        this.hasWater = hasWater;
        this.hasFood = hasFood;
        this.hasMedication = hasMedication;
        this.hasAmmunition = hasAmmunition;
        this.isInfected = isInfected;
        this.infectionCounter = infectionCounter;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isHasWater() {
        return hasWater;
    }

    public void setHasWater(boolean hasWater) {
        this.hasWater = hasWater;
    }

    public boolean isHasFood() {
        return hasFood;
    }

    public void setHasFood(boolean hasFood) {
        this.hasFood = hasFood;
    }

    public boolean isHasMedication() {
        return hasMedication;
    }

    public void setHasMedication(boolean hasMedication) {
        this.hasMedication = hasMedication;
    }

    public boolean isHasAmmunition() {
        return hasAmmunition;
    }

    public void setHasAmmunition(boolean hasAmmunition) {
        this.hasAmmunition = hasAmmunition;
    }

    public boolean isInfected() {
        return isInfected;
    }

    public void setInfected(boolean infected) {
        isInfected = infected;
    }

    public int getInfectionCounter() {
        return infectionCounter;
    }

    public void setInfectionCounter(int infectionCounter) {
        this.infectionCounter = infectionCounter;
    }
}
