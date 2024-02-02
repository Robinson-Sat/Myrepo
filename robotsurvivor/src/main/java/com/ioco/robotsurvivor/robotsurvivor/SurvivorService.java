package com.ioco.robotsurvivor.robotsurvivor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class SurvivorService {

    @Autowired
    private SurvivorRepository survivorRepository;

    public List<Survivor> getAllSurvivors() {
        return survivorRepository.findAll();
    }

    public Optional<Survivor> getSurvivorById(Long id) {
        return survivorRepository.findById(id);
    }

    public Survivor createSurvivor(Survivor survivor) {
        return survivorRepository.save(survivor);
    }

    public Survivor updateSurvivor(Long id, Survivor updatedSurvivor) {
        Optional<Survivor> existingSurvivor = survivorRepository.findById(id);

        if (existingSurvivor.isPresent()) {
            Survivor survivor = existingSurvivor.get();
            // Update fields as needed
            survivor.setName(updatedSurvivor.getName());
            survivor.setAge(updatedSurvivor.getAge());
            // Update other fields accordingly
            return survivorRepository.save(survivor);
        }

        return null; // Handle not found case
    }

    public double calculateInfectedPercentage() {
        List<Survivor> allSurvivors = survivorRepository.findAll();
        long totalSurvivors = allSurvivors.size();

        if (totalSurvivors == 0) {
            return 0.0; // Avoid division by zero
        }

        long infectedSurvivors = allSurvivors.stream()
                .filter(Survivor::isInfected)
                .count();

        return ((double) infectedSurvivors / totalSurvivors) * 100.0;
    }

    public double calculateNonInfectedPercentage() {
        return 100.0 - calculateInfectedPercentage();
    }

    public List<Survivor> getInfectedList() {
        return survivorRepository.findByIsInfected(true);
    }

    public List<Survivor> getNonInfectedList() {
        return survivorRepository.findByIsInfected(false);
    }

    public void deleteSurvivor(Long id) {
        survivorRepository.deleteById(id);
    }
}
