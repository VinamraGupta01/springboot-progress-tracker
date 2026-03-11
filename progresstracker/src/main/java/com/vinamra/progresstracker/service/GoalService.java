package com.vinamra.progresstracker.service;

import com.vinamra.progresstracker.entity.GoalEntity;
import com.vinamra.progresstracker.entity.GoalStatus;
import com.vinamra.progresstracker.entity.ProgressEntity;
import com.vinamra.progresstracker.repository.GoalRepository;
import com.vinamra.progresstracker.repository.ProgressRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GoalService {

    private final GoalRepository repository;

    public GoalService(GoalRepository repository){
        this.repository=repository;
    }

    public GoalEntity createGoal(GoalEntity goal){
        return repository.save(goal);
    }

    public List<GoalEntity> getAllGoals(){
        return repository.findAll();
    }

    public GoalEntity getGoalById(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Goal not found"));
    }

    public void deleteGoal(Long id){
        repository.deleteById(id);
    }
}