package com.vinamra.progresstracker.repository;

import com.vinamra.progresstracker.entity.ProgressEntity;
import org.springframework.data.jpa.repository.*;
import java.util.List;

public interface ProgressRepository extends JpaRepository<ProgressEntity,Long> {
 List<ProgressEntity> findByGoalId(Long goalId);
}