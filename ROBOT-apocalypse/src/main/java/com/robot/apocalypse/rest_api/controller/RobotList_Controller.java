package com.robot.apocalypse.rest_api.controller;


import com.robot.apocalypse.rest_api.service.RobotList_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("/api")
public class RobotList_Controller {

    @Autowired
    private RobotList_Service robotService;

    @Value("${external.api.url}")
    private String apiUrl;

    @GetMapping("/ListOfRobots")
    public ResponseEntity<String> getRobotData() {
        WebClient webClient = WebClient.create();

        String result = webClient.get()
                .uri(apiUrl)
                .retrieve()
                .bodyToMono(String.class)
                .block(); //

        System.out.println("----------------");
        System.out.println(result);
        System.out.println("-----------");

        // Return the JSON in the HTTP response
        return ResponseEntity.ok()
                .header("Content-Type", "application/json")
                .body(result);
    }



}