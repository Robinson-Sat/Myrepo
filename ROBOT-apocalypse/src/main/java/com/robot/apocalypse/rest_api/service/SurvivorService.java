package com.robot.apocalypse.rest_api.service;

import com.robot.apocalypse.rest_api.entity.A_Survivor;
import com.robot.apocalypse.rest_api.repository.SurvivorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SurvivorService {

    private final SurvivorRepository survivorRepository;

    @Autowired
    public SurvivorService(SurvivorRepository survivorRepository) {
        this.survivorRepository = survivorRepository;
    }

    public List<A_Survivor> getAllSurvivors() {
        return survivorRepository.findAll();
    }

    public Optional<A_Survivor> getSurvivorById(Long id) {
        return survivorRepository.findById(id);
    }

    public A_Survivor createSurvivor(A_Survivor survivor) {
        return survivorRepository.save(survivor);
    }

    public A_Survivor updateSurvivorLocation(Long id, A_Survivor updatedSurvivor) {
        Optional<A_Survivor> existingSurvivor = survivorRepository.findById(id);

        if (existingSurvivor.isPresent()) {
            A_Survivor survivor = existingSurvivor.get();
            survivor.setLongitude(updatedSurvivor.getLongitude());
            survivor.setLatitude(updatedSurvivor.getLatitude());
            return survivorRepository.save(survivor);
        }
        return null;
    }

    public A_Survivor updateSurvivorStatus(Long id, A_Survivor updatedSurvivor) {
        Optional<A_Survivor> existingSurvivor = survivorRepository.findById(id);

        if (existingSurvivor.isPresent()) {

            A_Survivor survivor = existingSurvivor.get();

            // Update other fields accordingly
            survivor.setInfectionCounter(updatedSurvivor.getInfectionCounter());

            // Check if infectionCounter is greater than 3 and set infectionStatus accordingly
            if (survivor.getInfectionCounter() > 3) {
                survivor.setInfectionStatus(true);
            }
            return survivorRepository.save(survivor);
        }
        return null;
    }

    public double calculateInfectedPercentage() {
        List<A_Survivor> allSurvivors = survivorRepository.findAll();
        long totalSurvivors = allSurvivors.size();

        if (totalSurvivors == 0) {
            return 0.0; // Avoid division by zero
        }

        long infectedSurvivors = allSurvivors.stream()
                .filter(A_Survivor::isInfectionStatus)
                .count();

        return ((double) infectedSurvivors / totalSurvivors) * 100.0;
    }

    public double calculateNonInfectedPercentage() {
        return 100.0 - calculateInfectedPercentage();
    }

    public List<A_Survivor> getInfectedList() {
        return survivorRepository.findByInfectionStatus(true);
    }

    public List<A_Survivor> getNonInfectedList() {
        return survivorRepository.findByInfectionStatus(false);
    }

}
