package com.ioco.robotsurvivor.robotsurvivor;

public class Robot {

    private Long id;
    private String name;
    private String location;
    private String category;

    // Constructors (you can generate these based on your needs)

    public Robot() {
    }

    public Robot(Long id, String name, String location, String category) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.category = category;
    }

    // Getter and Setter methods

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}

