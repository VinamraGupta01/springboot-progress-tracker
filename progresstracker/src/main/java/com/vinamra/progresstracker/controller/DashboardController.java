package com.vinamra.progresstracker.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import com.vinamra.progresstracker.service.DashboardService;

@RestController
public class DashboardController {   

    private final DashboardService dashboardService;

    public DashboardController(DashboardService dashboardService){
        this.dashboardService=dashboardService;
    }

    @GetMapping("/dashboard")
    public Map<String,Long> getDashboard(){
        return dashboardService.getDashboardStats();
    }
}
