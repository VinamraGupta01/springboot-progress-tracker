package com.vinamra.progresstracker.controller;

import com.vinamra.progresstracker.entity.GoalEntity;
import com.vinamra.progresstracker.service.GoalService;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goals")
public class GoalController {
    
    private final GoalService goalService;

    public GoalController(GoalService goalService){
        this.goalService=goalService;
    }

    @PostMapping
    public GoalEntity createGoal(@RequestBody GoalEntity goal){
        return goalService.createGoal(goal);
    }

    @GetMapping
    public List<GoalEntity> getAllGoals(){
        return goalService.getAllGoals();
    }

    @GetMapping("/{id}")
    public GoalEntity getGoalById(@PathVariable Long id){
        return goalService.getGoalById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteGoal(@PathVariable Long id){
        goalService.deleteGoal(id);
    }
}
