package com.ioco.robotsurvivor.robotsurvivor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/survivors")
public class SurvivorController {

    @Autowired
    private SurvivorService survivorService;

    @GetMapping
    public List<Survivor> getAllSurvivors() {
        return survivorService.getAllSurvivors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Survivor> getSurvivorById(@PathVariable Long id) {
        Optional<Survivor> survivor = survivorService.getSurvivorById(id);
        return survivor.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Survivor> createSurvivor(@RequestBody Survivor survivor) {
        Survivor savedSurvivor = survivorService.createSurvivor(survivor);
        return new ResponseEntity<>(savedSurvivor, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Survivor> updateSurvivor(@PathVariable Long id, @RequestBody Survivor updatedSurvivor) {
        Survivor updated = survivorService.updateSurvivor(id, updatedSurvivor);

        if (updated != null) {
            return new ResponseEntity<>(updated, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSurvivor(@PathVariable Long id) {
        survivorService.deleteSurvivor(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
