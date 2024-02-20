package com.robot.apocalypse.rest_api.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class SurvivorResource {
    private boolean water;
    private boolean food;
    private boolean medication;
    private boolean ammunition;
    public SurvivorResource() {
    }

    public SurvivorResource(boolean water, boolean food, boolean medication, boolean ammunition) {
        this.water = water;
        this.food = food;
        this.medication = medication;
        this.ammunition = ammunition;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFood() {
        return food;
    }

    public void setFood(boolean food) {
        this.food = food;
    }

    public boolean isMedication() {
        return medication;
    }

    public void setMedication(boolean medication) {
        this.medication = medication;
    }

    public boolean isAmmunition() {
        return ammunition;
    }

    public void setAmmunition(boolean ammunition) {
        this.ammunition = ammunition;
    }

    @Override
    public String toString() {
        return "SurvivorResource{" +
                "water=" + water +
                ", food=" + food +
                ", medication=" + medication +
                ", ammunition=" + ammunition +
                '}';
    }
}
