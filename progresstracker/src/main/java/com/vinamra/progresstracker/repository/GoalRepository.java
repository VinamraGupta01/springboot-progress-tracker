package com.vinamra.progresstracker.repository;

import com.vinamra.progresstracker.entity.GoalEntity;
import com.vinamra.progresstracker.entity.GoalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRepository extends JpaRepository<GoalEntity, Long> {

    long countByStatus(GoalStatus status);

}