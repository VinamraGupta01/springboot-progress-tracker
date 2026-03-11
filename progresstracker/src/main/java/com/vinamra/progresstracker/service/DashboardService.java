package com.vinamra.progresstracker.service;

import java.util.HashMap;
import java.util.Map;

import com.vinamra.progresstracker.entity.GoalStatus;
import com.vinamra.progresstracker.repository.GoalRepository;

import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final GoalRepository goalRepository;

    public DashboardService(GoalRepository goalRepository){
        this.goalRepository = goalRepository;
    }

    public Map<String, Long> getDashboardStats(){

        Map<String, Long> stats = new HashMap<>();

        stats.put("totalGoals", goalRepository.count());
        stats.put("completedGoals", goalRepository.countByStatus(GoalStatus.COMPLETED));
        stats.put("inProgressGoals", goalRepository.countByStatus(GoalStatus.IN_PROGRESS));
        stats.put("notStartedGoals", goalRepository.countByStatus(GoalStatus.NOT_STARTED));

        return stats;
    }
}