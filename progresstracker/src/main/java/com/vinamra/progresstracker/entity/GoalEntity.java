package com.vinamra.progresstracker.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name="goal_entity")
public class GoalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private GoalStatus status;

    @NotBlank(message="Title cannot be empty")
    private String title;

    private String description;

    @Positive(message="Target must be positive")
    private int target;

    public GoalEntity(){}

    public GoalStatus getStatus(){
        return status;
    }

    public void setStatus(GoalStatus status){
        this.status=status;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public int getTarget(){
        return target;
    }

    public void setTarget(int target){
        this.target=target;
    }
}