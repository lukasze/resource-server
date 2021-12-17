package com.example.resourceserver.repositoy;

import com.example.resourceserver.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WorkoutReposiotry extends JpaRepository<Workout, Integer> {

    // SpEL pozwala na pobranie użytkownka z security context
    @Query("SELECT w FROM Workout w WHERE w.user = ?#{authentication.name}")
    List<Workout> findAllByUser();
}
