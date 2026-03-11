package com.vinamra.progresstracker.controller;

import org.springframework.web.bind.annotation.*;

import com.vinamra.progresstracker.entity.ProgressEntity;
import com.vinamra.progresstracker.service.ProgressService;

@RestController
@RequestMapping("/progress")
public class ProgressController {

    private final ProgressService service;

    public ProgressController(ProgressService service){
        this.service = service;
    }

    @PostMapping
    public ProgressEntity addProgress(@RequestBody ProgressEntity entry){
        return service.saveEntry(entry);
    }

    @GetMapping("/{goalId}/{target}")
    public double getProgress(@PathVariable Long goalId,
                              @PathVariable int target){

        return service.calculateProgress(goalId, target);
    }
}