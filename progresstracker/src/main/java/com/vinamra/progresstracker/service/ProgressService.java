package com.vinamra.progresstracker.service;

import com.vinamra.progresstracker.entity.ProgressEntity;
import com.vinamra.progresstracker.entity.GoalEntity;
import com.vinamra.progresstracker.repository.ProgressRepository;
import com.vinamra.progresstracker.repository.GoalRepository;
import com.vinamra.progresstracker.entity.GoalStatus;

import org.springframework.stereotype.Service;

@Service
public class ProgressService {

    private final ProgressRepository repository;
    private final GoalRepository goalRepository;

    public ProgressService(ProgressRepository repository, GoalRepository goalRepository){
        this.repository = repository;
        this.goalRepository = goalRepository;
    }

    public ProgressEntity saveEntry(ProgressEntity entry){
        return repository.save(entry);
    }

    public double calculateProgress(Long goalId, int target){

        int completed = repository.findByGoalId(goalId).size();

        double progress = ((double) completed / target) * 100;

        GoalEntity goal = goalRepository.findById(goalId).orElse(null);

        if(goal != null){
            if(progress >= 100){
                goal.setStatus(GoalStatus.COMPLETED);
            }
            else if(progress > 0){
                goal.setStatus(GoalStatus.IN_PROGRESS);
            }
            else{
                goal.setStatus(GoalStatus.NOT_STARTED);
            }

            goalRepository.save(goal);
        }

        return progress;
    }
}