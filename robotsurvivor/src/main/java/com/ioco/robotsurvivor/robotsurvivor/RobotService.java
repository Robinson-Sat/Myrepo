package com.ioco.robotsurvivor.robotsurvivor;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

@Service
public class RobotService {

    private final String robotApiUrl = "https://robotstakeover20210903110417.azurewebsites.net/robotcpu";

    public List<Robot> getRobotsWithLocations() {
        RestTemplate restTemplate = new RestTemplate();

        // Make the HTTP GET request to the API
        Robot[] rawRobotsArray = restTemplate.getForObject(robotApiUrl, Robot[].class);

        // Convert the array to a list for easier processing
        List<Robot> rawRobots = Arrays.asList(rawRobotsArray);

        // Process raw data and create Robot objects
        List<Robot> robots = processRobots(rawRobots);

        // Sort the list of robots by category and then by name
        robots.sort(Comparator.comparing(Robot::getCategory, Comparator.nullsLast(Comparator.naturalOrder()))
                .thenComparing(Robot::getName, Comparator.nullsLast(Comparator.naturalOrder())));

        return robots;
    }

    private List<Robot> processRobots(List<Robot> rawRobots) {
        List<Robot> robots = new ArrayList<>();

        // Process raw data and create Robot objects
        for (Robot rawRobot : rawRobots) {
            Robot robot = new Robot();
            robot.setId(rawRobot.getId());
            robot.setName(defaultIfNull(rawRobot.getName(), ""));
            robot.setLocation(defaultIfNull(rawRobot.getLocation(), ""));
            robot.setCategory(defaultIfNull(rawRobot.getCategory(), ""));

            robots.add(robot);
        }

        return robots;
    }

    // Helper method to provide a default value if the input is null
    private static <T> T defaultIfNull(T value, T defaultValue) {
        return value != null ? value : defaultValue;
    }
}
