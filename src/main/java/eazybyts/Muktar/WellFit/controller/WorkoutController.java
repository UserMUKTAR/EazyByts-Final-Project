package eazybyts.Muktar.WellFit.controller;


import eazybyts.Muktar.WellFit.model.Workout;
import eazybyts.Muktar.WellFit.service.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workouts")
public class WorkoutController {

    @Autowired
    private WorkoutService workoutService;
//  POST    /workout
    @PostMapping
    public ResponseEntity<Workout> addWorkout(@RequestBody Workout workout) {
        return new ResponseEntity<>(workoutService.addWorkout(workout), HttpStatus.CREATED);
    }
//GET   /user/{id}
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Workout>> getWorkoutsByUser(@PathVariable Long userId) {
        return new ResponseEntity<>(workoutService.getWorkoutsByUser(userId), HttpStatus.OK);
    }
//DELETE  /{ID}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable Long id) {
        workoutService.deleteWorkout(id);
        return ResponseEntity.noContent().build();
    }
}
