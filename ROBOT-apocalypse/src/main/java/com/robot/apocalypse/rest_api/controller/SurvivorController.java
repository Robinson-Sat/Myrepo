package com.robot.apocalypse.rest_api.controller;

import com.robot.apocalypse.rest_api.entity.A_Survivor;
import com.robot.apocalypse.rest_api.service.SurvivorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/survivors")
public class SurvivorController {

    private final SurvivorService survivorService;

    @Autowired
    public SurvivorController(SurvivorService survivorService) {
        this.survivorService = survivorService;
    }

    @GetMapping()
    public List<A_Survivor> getAllSurvivors() {
        return survivorService.getAllSurvivors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<A_Survivor> getSurvivorById(@PathVariable Long id) {
        Optional<A_Survivor> survivor = survivorService.getSurvivorById(id);

        if (survivor.isPresent()) {
            return new ResponseEntity<>(survivor.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//
    @PostMapping
    public ResponseEntity<A_Survivor> createSurvivor(@RequestBody A_Survivor survivor) {
        A_Survivor savedSurvivor = survivorService.createSurvivor(survivor);
        //method to insert into inventory
        return new ResponseEntity<>(savedSurvivor, HttpStatus.CREATED);
    }
//
    @PutMapping("/updateSurvivorLocation/{id}")
    public ResponseEntity<A_Survivor> updateSurvivorLocation(@PathVariable Long id, @RequestBody A_Survivor updatedSurvivor) {
        A_Survivor updated = survivorService.updateSurvivorLocation(id, updatedSurvivor);

        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/updateInfectionStatus/{id}")
    public ResponseEntity<A_Survivor> updateInfectionStatus(@PathVariable Long id, @RequestBody A_Survivor updatedSurvivor) {
        A_Survivor updated = survivorService.updateSurvivorStatus(id, updatedSurvivor);

        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
//
    @GetMapping("/infectedPercentage")
    public ResponseEntity<Double> calculateInfectedPercentage() {
        double infectedPercentage = survivorService.calculateInfectedPercentage();
        return ResponseEntity.ok(infectedPercentage);
    }

    @GetMapping("/nonInfectedPercentage")
    public ResponseEntity<Double> calculateNonInfectedPercentage() {
        double nonInfectedPercentage = survivorService.calculateNonInfectedPercentage();
        return ResponseEntity.ok(nonInfectedPercentage);
    }

    @GetMapping("/infectedList")
    public ResponseEntity<List<A_Survivor>> reportInfectedList() {
        List<A_Survivor> infectedList = survivorService.getInfectedList();
        return ResponseEntity.ok(infectedList);
    }

    @GetMapping("/nonInfectedList")
    public ResponseEntity<List<A_Survivor>> reportNonInfectedList() {
        List<A_Survivor> nonInfectedList = survivorService.getNonInfectedList();
        return ResponseEntity.ok(nonInfectedList);
    }
}

