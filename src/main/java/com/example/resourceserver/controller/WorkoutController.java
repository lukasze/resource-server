package com.example.resourceserver.controller;

import com.example.resourceserver.model.Workout;
import com.example.resourceserver.service.WorkoutService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workout")
@Data
public class WorkoutController {

    private final WorkoutService workoutService;

    @GetMapping("/")
    public List<Workout> findAll(){
        return workoutService.findWorkouts();
    }

    @PostMapping("/")
    public void add(@RequestBody Workout workout) {
        workoutService.saveWorkout(workout);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        workoutService.deleteWorkout(id);
    }

}
