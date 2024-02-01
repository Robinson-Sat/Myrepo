package com.ioco.robotsurvivor.robotsurvivor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void deleteSurvivor(Long id) {
        survivorRepository.deleteById(id);
    }
}
