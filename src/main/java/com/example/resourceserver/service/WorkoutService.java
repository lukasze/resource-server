package com.example.resourceserver.service;

import com.example.resourceserver.model.Workout;
import com.example.resourceserver.repositoy.WorkoutRepository;
import lombok.Data;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class WorkoutService {
    private final WorkoutRepository workoutRepository;

    @PreAuthorize("#workout.user == authentication.name")
    public void saveWorkout(Workout workout) {
        workoutRepository.save(workout);
    }

    // zabezpieczenie w repository
    public List<Workout> findWorkouts() {
        return workoutRepository.findAllByUser();
    }

    // zabezpieczenie na poziomie endpointów - klasa konfiguracyjna
    public void deleteWorkout(Integer id) {
        workoutRepository.deleteById(id);
    }


}
