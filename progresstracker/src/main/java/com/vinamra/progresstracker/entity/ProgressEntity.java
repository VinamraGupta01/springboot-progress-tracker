package com.vinamra.progresstracker.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name="progress_entity")
public class ProgressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long goalId;

    private LocalDate entryDate;

    private Integer value;

    public ProgressEntity(){}

    public ProgressEntity(Long id, Long goalId, LocalDate entryDate, Integer value){
        this.id=id;
        this.goalId=goalId;
        this.entryDate=entryDate;
        this.value=value;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public Long getGoalId(){
        return goalId;
    }

    public void setGoalId(Long goalId){
        this.goalId=goalId;
    }

    public LocalDate getEntryDate(){
        return entryDate;
    }

    public void setEntryDate(LocalDate entryDate){
        this.entryDate=entryDate;
    }

    public Integer getValue(){
        return value;
    }

    public void setValue(Integer value){
        this.value=value;
    }
}