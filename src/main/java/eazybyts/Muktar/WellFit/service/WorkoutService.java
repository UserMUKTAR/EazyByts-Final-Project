package eazybyts.Muktar.WellFit.service;

import eazybyts.Muktar.WellFit.model.Workout;
import eazybyts.Muktar.WellFit.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutService {
    @Autowired
    private WorkoutRepository workoutRepository;

    public Workout addWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    public List<Workout> getWorkoutsByUser(Long userId) {
        return workoutRepository.findByUserId(userId);
    }

    public void deleteWorkout(Long id) {
        workoutRepository.deleteById(id);
    }
}

