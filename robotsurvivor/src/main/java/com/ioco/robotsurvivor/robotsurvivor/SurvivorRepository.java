package com.ioco.robotsurvivor.robotsurvivor;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurvivorRepository extends JpaRepository<Survivor, Long> {
    List<Survivor> findByIsInfected(boolean isInfected);

}
