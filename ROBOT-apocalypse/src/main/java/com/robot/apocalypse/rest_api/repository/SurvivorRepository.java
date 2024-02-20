package com.robot.apocalypse.rest_api.repository;

import com.robot.apocalypse.rest_api.entity.A_Survivor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurvivorRepository extends JpaRepository<A_Survivor, Long> {
    List<A_Survivor> findByInfectionStatus(boolean isInfected);

}
