package com.robot.apocalypse.rest_api.service;

import com.robot.apocalypse.rest_api.entity.RobotList_Entity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class RobotList_Service {
    public RobotList_Service() {
    }

    @Value("${external.api.url}")
    private String robotApiUrl;

    public List<RobotList_Entity> getRobotsWithLocations() {
        RestTemplate restTemplate = new RestTemplate();

        // Make the HTTP GET request to the API
        RobotList_Entity[] rawRobotsArray = restTemplate.getForObject(robotApiUrl, RobotList_Entity[].class);

        // Convert the array to a list for easier processing
        List<RobotList_Entity> rawRobots = Arrays.asList(rawRobotsArray);

        // Process raw data and create RobotEntity objects using Lombok
        List<RobotList_Entity> robots = processRobots(rawRobots);

        return robots;
    }

    private List<RobotList_Entity> processRobots(List<RobotList_Entity> rawRobots) {
        List<RobotList_Entity> robots = new ArrayList<>();

        // Process raw data and create RobotEntity objects using Lombok
        for (RobotList_Entity rawRobot : rawRobots) {
            RobotList_Entity robot = new RobotList_Entity();
            robot.setId(rawRobot.getId());
            robot.setModel(defaultIfNull(rawRobot.getModel(), ""));
            robot.setSerialNumber(defaultIfNull(rawRobot.getSerialNumber(), ""));
            robot.setManufacturedDate(rawRobot.getManufacturedDate());
            robot.setCategory((defaultIfNull(rawRobot.getCategory(),"")));

            robots.add(robot);
        }

        return robots;
    }

    // Helper method to provide a default value if the input is null
    private static <T> T defaultIfNull(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }
}